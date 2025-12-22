package com.william.telegramBot.telegram_bot.interactions.callback.impl;

import com.william.telegramBot.telegram_bot.TelegramClientService;
import com.william.telegramBot.telegram_bot.dto.obj.SendMessageBase;
import com.william.telegramBot.telegram_bot.exception.InteractionException;
import com.william.telegramBot.telegram_bot.interactions.IInterraction;
import com.william.telegramBot.telegram_bot.interactions.callback.CallBackContext;
import org.springframework.stereotype.Component;

@Component
public class testeCallback implements IInterraction<CallBackContext> {
    private CallBackContext context;
    private final TelegramClientService service;

    public testeCallback(TelegramClientService service) {
        this.service = service;
    }

    @Override
    public void action() throws InteractionException {
        SendMessageBase message = new SendMessageBase();
        message.setChatId(this.context.chatId());
        message.setText("Callback acionado");
        service.sendMessage(message);
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
