package com.william.telegramBot.telegram_bot.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record UserDTO(
        Long id,
        boolean is_bot,
        String first_name,
        String language_code
) {

}
