package com.william.telegramBot.telegram_bot.middlewares;


import com.william.telegramBot.telegram_bot.exception.InteractionException;
import com.william.telegramBot.telegram_bot.interactions.commands.CommandsContext;

public interface IMiddleware {
    public void handle(CommandsContext context, MiddleWareChain chain) throws InteractionException;
}
