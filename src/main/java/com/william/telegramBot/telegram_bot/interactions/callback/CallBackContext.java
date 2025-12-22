package com.william.telegramBot.telegram_bot.interactions.callback;

import com.william.telegramBot.telegram_bot.interactions.IInterraction;
import com.william.telegramBot.telegram_bot.interactions.IInterractionContext;
import com.william.telegramBot.telegram_bot.dto.MessageEntityDto;
import com.william.telegramBot.telegram_bot.dto.UpdateDTO;
import com.william.telegramBot.telegram_bot.interactions.commands.CommandsContext;

import java.util.List;


// A estrutura base de um callback é diferente ele segue o padrão update().callback() e não update.message()
public class CallBackContext implements IInterractionContext<IInterraction<CallBackContext>> {

    private final UpdateDTO update;
    private final IInterraction<CallBackContext> interaction;

    public CallBackContext(UpdateDTO update, IInterraction<CallBackContext> interaction) {
        this.update = update;
        this.interaction = interaction;
    }

    @Override
    public UpdateDTO update() {
        return this.update;
    }

    @Override
    public Long chatId() {
        return this.update.callback().message().chat().id();
    }

    @Override
    public IInterraction<CallBackContext> interraction() {
        return this.interaction;
    }

    @Override
    public String message() {
        return this.update.callback().message().text();
    }

    @Override
    public Long getUserTelegramId() {
        return this.update.callback().from().id();
    }

    @Override
    public List<MessageEntityDto> getEntities() {
        return List.of();
    }
}
