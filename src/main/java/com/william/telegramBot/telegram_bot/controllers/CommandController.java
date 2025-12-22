package com.william.telegramBot.telegram_bot.controllers;

import com.william.telegramBot.telegram_bot.interactions.IInterraction;
import com.william.telegramBot.telegram_bot.interactions.commands.CommandsFactory;
import com.william.telegramBot.telegram_bot.dto.MessageEntityDto;
import com.william.telegramBot.telegram_bot.dto.UpdateDTO;
import com.william.telegramBot.telegram_bot.interactions.commands.CommandsContext;
import com.william.telegramBot.telegram_bot.handler.InteractionExceptionHandler;
import com.william.telegramBot.telegram_bot.middlewares.MiddleWareChain;
import com.william.telegramBot.telegram_bot.middlewares.MiddleWareChainFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/*
* Implementação para integrar os comandos dos chats
* */
@Component
public class CommandController implements IInteractionController {

    private final CommandsFactory commandsFactory;
    private final MiddleWareChainFactory middleWareFactory;
    private final InteractionExceptionHandler interactionExceptionHandler;


    public CommandController(CommandsFactory commandsFactory, MiddleWareChainFactory middleWareFactory, InteractionExceptionHandler interactionExceptionHandler) {
        this.commandsFactory = commandsFactory;
        this.middleWareFactory = middleWareFactory;
        this.interactionExceptionHandler = interactionExceptionHandler;
    }

    @Override
    public void execute(UpdateDTO update) {

        String message = update.message().text();
        List<MessageEntityDto> entities = update.message().entities();
        String command = update
                .message().text()
                .substring(0, Integer.parseInt(entities.getFirst().length()))
                .replace("/","")
                .trim()
                .toLowerCase();

        try{
            IInterraction<CommandsContext> interaction = this.commandsFactory.getInterraction(command);
            //Define os middlewares para proteção todas rotas passam por essas camadas
            MiddleWareChain middleWareChain = middleWareFactory.executor();
            middleWareChain.next(new CommandsContext(update,interaction));
            if(middleWareChain.getRedirect() != null){
                interaction = this.commandsFactory.getInterraction(middleWareChain.getRedirect());
            }
            //Envia os dados necessarios para fazer a chamada do serviço do telegram
            interaction.setContext(new CommandsContext(update,interaction));
            interaction.action();
        }catch (Exception e){
            this.interactionExceptionHandler.handle(e,update.message().chat().id());
        }
    }
}
