package com.william.telegramBot.telegram_bot.interactions.callback;

import com.william.telegramBot.telegram_bot.interactions.IInterraction;
import com.william.telegramBot.telegram_bot.exception.InteractionException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CallBackFactory {

    private final Map<String, IInterraction<CallBackContext>> mapInterractions = new HashMap<>();

    CallBackFactory(List<IInterraction<CallBackContext>> listInterractions) {
        for (IInterraction<CallBackContext> interraction : listInterractions) {
            this.mapInterractions.put(interraction.getType(), interraction);
        }
    }

    public IInterraction<CallBackContext> getInterraction(String type) throws InteractionException {
        IInterraction<CallBackContext> interraction = this.mapInterractions.get(type);
        if (interraction == null) throw new InteractionException("Call back não encontrado");
        return interraction;
    }

}
