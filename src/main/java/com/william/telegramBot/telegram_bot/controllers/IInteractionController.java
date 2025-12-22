package com.william.telegramBot.telegram_bot.controllers;

import com.william.telegramBot.telegram_bot.dto.UpdateDTO;
import com.william.telegramBot.telegram_bot.exception.InteractionException;

/*
*   A ideia dessa interface é gerar um contexto designado para cada ocorrencia.
* */
public interface IInteractionController {
    void execute(UpdateDTO updateDTO) throws InteractionException;
}
