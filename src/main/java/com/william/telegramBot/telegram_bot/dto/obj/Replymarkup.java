package com.william.telegramBot.telegram_bot.dto.obj;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public class Replymarkup {

        @JsonProperty("keyboard")
        private List<List<KeyBoardButton>> keyboard;

        @JsonProperty("inline_keyboard")
        private List<List<InlineKeyboardButton>> inlineKeyboard;


    }
