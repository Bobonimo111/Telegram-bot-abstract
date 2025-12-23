package com.william.telegramBot.telegram_bot.interactions.callback.impl;

import com.william.telegramBot.telegram_bot.dto.obj.ISendMessageBase;
import com.william.telegramBot.telegram_bot.dto.obj.SendMessageBase;
import com.william.telegramBot.telegram_bot.exception.InteractionException;
import com.william.telegramBot.telegram_bot.interactions.IInteraction;
import com.william.telegramBot.telegram_bot.interactions.callback.CallBackContext;
import org.springframework.stereotype.Component;

@Component
public class testeCallback implements IInteraction<CallBackContext> {
    private CallBackContext context;


    @Override
    public ISendMessageBase action() throws InteractionException {
        SendMessageBase message = new SendMessageBase();
        message.setChatId(this.context.chatId());
        message.setText("Callback acionado");
        return message;

    }

    @Override
    public String getType() {
        return "DATA-TESTE";
    }

    @Override
    public void setContext(CallBackContext context) {
        this.context = context;
    }

    @Override
    public CallBackContext getContext() {
        return context;
    }
}
