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
public class KeyBoardButton {
    private String text;
    private String url;
    @JsonProperty("web_app")
    private WebApp webApp;

    public KeyBoardButton(String text, String url) {
        this.text = text;
        this.url = url;
    }

    public KeyBoardButton(String text, WebApp webApp) {
        this.text = text;
        this.webApp = webApp;
    }
}
