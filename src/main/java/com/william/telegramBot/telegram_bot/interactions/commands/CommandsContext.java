package com.william.telegramBot.telegram_bot.interactions.commands;


import com.william.telegramBot.telegram_bot.interactions.IInteraction;
import com.william.telegramBot.telegram_bot.interactions.IInteractionContext;
import com.william.telegramBot.telegram_bot.dto.MessageEntityDto;
import com.william.telegramBot.telegram_bot.dto.UpdateDTO;

import java.util.List;

public class CommandsContext implements IInteractionContext<IInteraction<CommandsContext>> {
    private final UpdateDTO update;
    private final IInteraction<CommandsContext> interaction;

    public CommandsContext(UpdateDTO update, IInteraction<CommandsContext> interaction) {
        this.update = update;
        this.interaction = interaction;
    }

    public UpdateDTO update() {
        return update;
    }

   @Override
    public IInteraction<CommandsContext> interraction() {
        return this.interaction;
    }

    public Long chatId() {
        return update.message().chat().id();
    }


    public String message() {
        return update.message().text();
    }

    public Long getUserTelegramId(){
        return update.message().from().id();
    }

    public List<MessageEntityDto> getEntities(){
        return update.message().entities();
    }
}
