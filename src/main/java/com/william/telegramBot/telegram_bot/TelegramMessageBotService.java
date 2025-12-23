package com.william.telegramBot.telegram_bot;

import com.william.telegramBot.telegram_bot.interactions.controllers.IInteractionController;
import com.william.telegramBot.telegram_bot.interactions.controllers.InteractionControllerFactory;
import com.william.telegramBot.telegram_bot.dto.UpdateDTO;
import com.william.telegramBot.telegram_bot.exception.InteractionException;
import com.william.telegramBot.telegram_bot.handler.InteractionExceptionHandler;
import org.springframework.stereotype.Service;

@Service
public class TelegramMessageBotService {

    private final InteractionControllerFactory interactionControllerFactory;
    private final InteractionExceptionHandler interactionExceptionHandler;
    private final TelegramClientService telegramClientService;

    public TelegramMessageBotService(InteractionControllerFactory interactionControllerFactory, InteractionExceptionHandler interactionExceptionHandler, TelegramClientService telegramClientService) {
        this.interactionControllerFactory = interactionControllerFactory;
        this.interactionExceptionHandler = interactionExceptionHandler;
        this.telegramClientService = telegramClientService;
    }

    //Resposavel por direcionar e executar o factory de criação
    public void controller(UpdateDTO update){
        IInteractionController InteractionController = interactionControllerFactory.getCommandController(update);
        try{
            if (InteractionController != null) this.telegramClientService.sendMessage(InteractionController.execute(update));
        }catch (InteractionException interactionException){
            this.interactionExceptionHandler.handle(interactionException,interactionException.getChatId());
        }
    }

}
