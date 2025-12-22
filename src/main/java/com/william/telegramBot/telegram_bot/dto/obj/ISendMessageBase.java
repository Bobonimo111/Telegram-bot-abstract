package com.william.telegramBot.telegram_bot.dto.obj;

public interface ISendMessageBase {
    Long getChatId();
    void setChatId(Long chatId);

    String getText();
    void setText(String text);
}
