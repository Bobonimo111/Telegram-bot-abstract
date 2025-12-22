package com.william.telegramBot.telegram_bot;

import com.william.telegramBot.telegram_bot.dto.GetUpdatesDTO;
import com.william.telegramBot.telegram_bot.dto.WebHookDto;
import com.william.telegramBot.telegram_bot.dto.obj.ISendMessageBase;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.net.URL;

@FeignClient(name = "TelegramApi", url = "https://api.telegram.org")
public interface TelegramBotClient {

    @GetMapping("bot{token}/getMe")
    public String getMe(@PathVariable String token);

    @GetMapping("bot{token}/getUpdates")
    public GetUpdatesDTO getUpdates(@PathVariable String token,
                                    @RequestParam("offset") Long offset,
                                    @RequestParam("timeout") Integer timeout);

    @GetMapping("bot{token}/sendMessage")
    public String sendMessage(@PathVariable String token,
                              @RequestParam(required = true) Long chat_id,
                              @RequestParam(required = false) String text);

    @PostMapping("bot{token}/sendMessage")
    public String sendMessage(@PathVariable String token,
                              @RequestBody(required = true) ISendMessageBase message);

    @GetMapping("bot{token}/setWebhook")
    public WebHookDto setWebhook(@PathVariable String token,
                                 @RequestParam(required = true) URL url);

    @GetMapping("bot{token}/deleteWebhook")
    public String deleteWebHook(@PathVariable String token);
}
