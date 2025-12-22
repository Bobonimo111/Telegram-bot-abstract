package com.william.telegramBot.telegram_bot.controllers;

import com.william.telegramBot.telegram_bot.dto.UpdateDTO;
import org.springframework.stereotype.Service;

@Service
public class InteractionControllerFactory {

    private final CommandController commandController;

    InteractionControllerFactory(CommandController commandController){
        this.commandController = commandController;
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

        return null;
    }
}
