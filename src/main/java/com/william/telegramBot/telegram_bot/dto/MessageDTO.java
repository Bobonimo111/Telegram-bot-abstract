package com.william.telegramBot.telegram_bot.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record MessageDTO(
        Long message_id,
        UserDTO from,
        ChatDTO chat,
        Long date,
        String text,
        List<MessageEntityDto> entities
) {
}
