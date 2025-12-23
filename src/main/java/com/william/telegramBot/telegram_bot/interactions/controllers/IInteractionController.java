package com.william.telegramBot.telegram_bot.interactions.controllers;

import com.william.telegramBot.telegram_bot.dto.UpdateDTO;
import com.william.telegramBot.telegram_bot.dto.obj.ISendMessageBase;
import com.william.telegramBot.telegram_bot.exception.InteractionException;

/*
*   A ideia dessa interface é gerar um contexto designado para cada ocorrencia.
* */
public interface IInteractionController {
    ISendMessageBase execute(UpdateDTO updateDTO) throws InteractionException;
}
