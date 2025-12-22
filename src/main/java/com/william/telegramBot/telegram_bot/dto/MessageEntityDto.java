package com.william.telegramBot.telegram_bot.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record MessageEntityDto(
        String type,
        String length
) {
}
