package com.william.telegramBot.telegram_bot.interactions;

import com.william.telegramBot.telegram_bot.dto.obj.ISendMessageBase;
import com.william.telegramBot.telegram_bot.exception.InteractionException;

public interface IInteraction<T> {
    ISendMessageBase action() throws InteractionException;


    /*
    * Type is required to identify in factory, defini this or nothing will hapen
    * */
    String getType();

    /*
     * This context contain all data sent by telegram update,
     * set this and you will interact by request
    * */
    void setContext(T context);

    T getContext();
}
