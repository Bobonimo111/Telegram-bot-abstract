package com.william.telegramBot.telegram_bot.interactions;

import com.william.telegramBot.telegram_bot.exception.InteractionException;

public interface IInterraction<T> {
    void action() throws InteractionException;

    String getType();

    void setContext(T context);

    T getContext();
}
