package com.william.telegramBot.telegram_bot.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record WebHookDto(
        	Boolean ok,
            Boolean result,
            String description
) {
}
