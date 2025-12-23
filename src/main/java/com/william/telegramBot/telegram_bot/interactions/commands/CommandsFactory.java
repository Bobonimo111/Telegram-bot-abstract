package com.william.telegramBot.telegram_bot.interactions.commands;

import com.william.telegramBot.telegram_bot.interactions.IInteraction;
import com.william.telegramBot.telegram_bot.exception.InteractionException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommandsFactory {

    private final Map<String, IInteraction<CommandsContext>> mapInterractions = new HashMap<>();

    CommandsFactory(List<IInteraction<CommandsContext>> listInterractions) {
        for (IInteraction<CommandsContext> interraction : listInterractions) {
            this.mapInterractions.put(interraction.getType(), interraction);
        }
    }

    public IInteraction<CommandsContext> getInterraction(String type) throws InteractionException {
        IInteraction<CommandsContext> interraction = this.mapInterractions.get(type);
        if (interraction == null) throw new InteractionException("Commando não encontrado");
        return interraction;
    }
}
