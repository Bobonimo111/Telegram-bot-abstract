package com.william.telegramBot.telegram_bot.interactions.controllers;

import com.william.telegramBot.telegram_bot.dto.UpdateDTO;
import com.william.telegramBot.telegram_bot.dto.obj.ISendMessageBase;
import com.william.telegramBot.telegram_bot.exception.InteractionException;
import com.william.telegramBot.telegram_bot.interactions.IInteraction;
import com.william.telegramBot.telegram_bot.interactions.callback.CallBackContext;
import com.william.telegramBot.telegram_bot.interactions.callback.CallBackFactory;
import org.springframework.stereotype.Service;

@Service
public class CallbackController implements IInteractionController {
    private final CallBackFactory callBackFactory;

    public CallbackController(CallBackFactory callBackFactory) {
        this.callBackFactory = callBackFactory;
    }

    @Override
    public ISendMessageBase execute(UpdateDTO update) throws InteractionException {
        String callbackData = update.callback().data();

        IInteraction<CallBackContext> interaction = this.callBackFactory.getInterraction(callbackData);

        //Envia os dados necessarios para fazer a chamada do serviço do telegram
        interaction.setContext(new CallBackContext(update, interaction));
        return interaction.action();
    }
}
