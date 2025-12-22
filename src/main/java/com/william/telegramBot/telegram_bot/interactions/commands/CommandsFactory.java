package com.william.telegramBot.telegram_bot.interactions.commands;

import com.william.telegramBot.telegram_bot.interactions.IInterraction;
import com.william.telegramBot.telegram_bot.exception.InteractionException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommandsFactory {

    private final Map<String, IInterraction<CommandsContext>> mapInterractions = new HashMap<>();

    CommandsFactory(List<IInterraction<CommandsContext>> listInterractions) {
        for (IInterraction<CommandsContext> interraction : listInterractions) {
            this.mapInterractions.put(interraction.getType(), interraction);
        }
    }

    public IInterraction<CommandsContext> getInterraction(String type) throws InteractionException {
        IInterraction<CommandsContext> interraction = this.mapInterractions.get(type);
        if (interraction == null) throw new InteractionException("Commando não encontrado");
        return interraction;
    }
}
