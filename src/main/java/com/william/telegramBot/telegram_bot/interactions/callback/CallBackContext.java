package com.william.telegramBot.telegram_bot.interactions.callback;

import com.william.telegramBot.telegram_bot.interactions.IInteraction;
import com.william.telegramBot.telegram_bot.interactions.IInteractionContext;
import com.william.telegramBot.telegram_bot.dto.MessageEntityDto;
import com.william.telegramBot.telegram_bot.dto.UpdateDTO;

import java.util.List;


// A estrutura base de um callback é diferente ele segue o padrão update().callback() e não update.message()
public class CallBackContext implements IInteractionContext<IInteraction<CallBackContext>> {

    private final UpdateDTO update;
    private final IInteraction<CallBackContext> interaction;

    public CallBackContext(UpdateDTO update, IInteraction<CallBackContext> interaction) {
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
    public IInteraction<CallBackContext> interraction() {
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
