package com.william.telegramBot.telegram_bot.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record UpdateDTO(
         Long update_id,
         MessageDTO message,
         @JsonProperty("callback_query")
         CallbackQuerry callback,
         EditedMenssageDTO edited_message
) {
}
