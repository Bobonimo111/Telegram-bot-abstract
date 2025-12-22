package com.william.telegramBot.telegram_bot.interactions.commands;


import com.william.telegramBot.telegram_bot.interactions.IInterraction;
import com.william.telegramBot.telegram_bot.interactions.IInterractionContext;
import com.william.telegramBot.telegram_bot.dto.MessageEntityDto;
import com.william.telegramBot.telegram_bot.dto.UpdateDTO;

import java.util.List;

public class CommandsContext implements IInterractionContext<IInterraction<CommandsContext>> {
    private final UpdateDTO update;
    private final IInterraction<CommandsContext> interaction;

    public CommandsContext(UpdateDTO update, IInterraction<CommandsContext> interaction) {
        this.update = update;
        this.interaction = interaction;
    }

    public UpdateDTO update() {
        return update;
    }

   @Override
    public IInterraction<CommandsContext> interraction() {
        return this.interaction;
    }

    public Long chatId() {
        return update.message().chat().id();
    }


    public String text() {
        return update.message().text();
    }

    public Long getUserTelegramId(){
        return update.message().from().id();
    }

    public List<MessageEntityDto> getEntities(){
        return update.message().entities();
    }
}
