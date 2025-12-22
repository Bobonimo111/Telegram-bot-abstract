package com.william.telegramBot.telegram_bot.dto.obj;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendMessageReplyMarkup extends SendMessageBase{
    @JsonProperty("reply_markup")
    Replymarkup replyMarkup;
}
