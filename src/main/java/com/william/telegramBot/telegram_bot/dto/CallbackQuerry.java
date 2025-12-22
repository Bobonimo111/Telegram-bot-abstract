package com.william.telegramBot.telegram_bot.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CallbackQuerry(
        Long id,
        UserDTO from,
        MessageDTO message,
        String data
) {

}
