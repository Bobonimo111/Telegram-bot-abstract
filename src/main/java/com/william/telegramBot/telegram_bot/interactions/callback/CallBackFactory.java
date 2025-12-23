package com.william.telegramBot.telegram_bot.interactions.callback;

import com.william.telegramBot.telegram_bot.interactions.IInteraction;
import com.william.telegramBot.telegram_bot.exception.InteractionException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CallBackFactory {

    private final Map<String, IInteraction<CallBackContext>> mapInterractions = new HashMap<>();

    CallBackFactory(List<IInteraction<CallBackContext>> listInterractions) {
        for (IInteraction<CallBackContext> interraction : listInterractions) {
            this.mapInterractions.put(interraction.getType(), interraction);
        }
    }

    public IInteraction<CallBackContext> getInterraction(String type) throws InteractionException {
        IInteraction<CallBackContext> interraction = this.mapInterractions.get(type);
        if (interraction == null) throw new InteractionException("Call back não encontrado");
        return interraction;
    }

}
