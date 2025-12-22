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

    public TelegramMessageBotService(InteractionControllerFactory interactionControllerFactory, InteractionExceptionHandler interactionExceptionHandler) {
        this.interactionControllerFactory = interactionControllerFactory;
        this.interactionExceptionHandler = interactionExceptionHandler;
    }

    //Resposavel por direcionar e executar o factory de criação
    public void controller(UpdateDTO update){
        IInteractionController InteractionController = interactionControllerFactory.getCommandController(update);
        try{
            if (InteractionController != null) InteractionController.execute(update);
        }catch (InteractionException interactionException){
            this.interactionExceptionHandler.handle(interactionException,interactionException.getChatId());
        }
    }

}
