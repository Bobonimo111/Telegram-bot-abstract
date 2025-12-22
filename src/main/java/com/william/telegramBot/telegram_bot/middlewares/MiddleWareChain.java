package com.william.telegramBot.telegram_bot.middlewares;

import com.william.telegramBot.telegram_bot.exception.InteractionException;
import com.william.telegramBot.telegram_bot.interactions.commands.CommandsContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MiddleWareChain {
    private final List<IMiddleware> middlewares;
    private int index = 0;
    private String route = null;

    public MiddleWareChain(List<IMiddleware> middlewares) {
        this.middlewares = middlewares;
    }

    // Executa o próximo middleware da cadeia
    public void next(CommandsContext context) throws InteractionException {
        if (index < middlewares.size()) {
            middlewares.get(index++).handle(context, this);
        }
    }

    public void redirect(String route){
        this.route = route;
    }

    public String getRedirect(){
        return this.route;
    }
}