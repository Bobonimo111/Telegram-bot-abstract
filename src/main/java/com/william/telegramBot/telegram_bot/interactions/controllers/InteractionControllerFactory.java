package com.william.telegramBot.telegram_bot.interactions.controllers;

import com.william.telegramBot.telegram_bot.dto.UpdateDTO;
import org.springframework.stereotype.Service;

@Service
public class InteractionControllerFactory {

    private final CommandController commandController;
    private final CallbackController callbackController;

    InteractionControllerFactory(CommandController commandController, CallbackController callbackController){
        this.commandController = commandController;
        this.callbackController = callbackController;
    }

    //Aqui eu crio uma regra pra instanciar cada um
    public IInteractionController getCommandController(UpdateDTO update) {
        if (update.edited_message() != null) {
            return null;
        }

        if (    update.message() != null &&
                update.message().chat().type().equals("private") &&
                update.message().entities() != null &&
                "bot_command".equals(update.message().entities().getFirst().type())
        ) {
            return commandController;
        }

        if(update.callback() != null){
            return callbackController;
        }

        return null;
    }
}
