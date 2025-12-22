package com.william.telegramBot.telegram_bot.exception;

import lombok.Getter;

@Getter
public class InteractionException extends Exception {
    private Long chatId;
    public InteractionException(String message) {
        super(message);
    }

    public InteractionException(String message, Long chatId) {
        super(message);
        this.chatId = chatId;
    }
}
