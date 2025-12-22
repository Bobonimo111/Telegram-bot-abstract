package com.william.telegramBot.telegram_bot.handler;

import com.william.telegramBot.telegram_bot.TelegramClientService;
import org.springframework.stereotype.Component;

@Component
public class InteractionExceptionHandler {
    private final TelegramClientService telegramClientService;

    public InteractionExceptionHandler(TelegramClientService telegramClientService) {
        this.telegramClientService = telegramClientService;
    }

    public void handle(Exception e, Long chatId) {
        telegramClientService.sendMessage(chatId,e.getMessage());
    }
}
