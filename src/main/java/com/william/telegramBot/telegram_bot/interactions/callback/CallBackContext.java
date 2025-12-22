package com.william.telegramBot.telegram_bot.interactions.callback;

import com.william.telegramBot.telegram_bot.interactions.IInterraction;
import com.william.telegramBot.telegram_bot.interactions.IInterractionContext;
import com.william.telegramBot.telegram_bot.dto.MessageEntityDto;
import com.william.telegramBot.telegram_bot.dto.UpdateDTO;

import java.util.List;


// A estrutura base de um callback é diferente ele segue o padrão update().callback() e não update.message()
public class CallBackContext implements IInterractionContext<IInterraction<CallBackContext>> {

    @Override
    public UpdateDTO update() {

        return null;
    }

    @Override
    public Long chatId() {
        return 0L;
    }

    @Override
    public IInterraction<CallBackContext> interraction() {
        return null;
    }

    @Override
    public String text() {
        return "";
    }

    @Override
    public Long getUserTelegramId() {
        return 0L;
    }

    @Override
    public List<MessageEntityDto> getEntities() {
        return List.of();
    }
}
