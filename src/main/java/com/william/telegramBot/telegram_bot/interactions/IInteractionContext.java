package com.william.telegramBot.telegram_bot.interactions;

import com.william.telegramBot.telegram_bot.dto.MessageEntityDto;
import com.william.telegramBot.telegram_bot.dto.UpdateDTO;

import java.util.List;

public interface IInteractionContext<T> {
    public UpdateDTO update() ;

    public Long chatId() ;

    public T interraction();

    public String message() ;

    public Long getUserTelegramId();

    public List<MessageEntityDto> getEntities();
}
