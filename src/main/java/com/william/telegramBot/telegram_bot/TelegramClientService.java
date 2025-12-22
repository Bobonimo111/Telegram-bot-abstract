package com.william.telegramBot.telegram_bot;

import com.william.telegramBot.telegram_bot.dto.GetUpdatesDTO;
import com.william.telegramBot.telegram_bot.dto.WebHookDto;
import com.william.telegramBot.telegram_bot.dto.obj.ISendMessageBase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URL;

@Service
public class TelegramClientService {

    private final TelegramBotClient telegramBotClient;
    private final String token;

    public TelegramClientService(TelegramBotClient telegramBotClient, @Value("${telegram-api-key}") String token) {
        this.telegramBotClient = telegramBotClient;
        this.token = token;
    }

     //Verifica a disponibilidade do bot
    public String getMe() {
        return telegramBotClient.getMe(this.token);
    }

    public GetUpdatesDTO getUpdates() {
        return telegramBotClient.getUpdates(this.token);
    }

    public void sendMessage(Long chatId,String text){
        telegramBotClient.sendMessage(this.token,chatId,text);
    }

    public void sendMessage(Long chatId, ISendMessageBase message){
        telegramBotClient.sendMessage(this.token,message);
    }

    public void sendMessage(ISendMessageBase message){
        telegramBotClient.sendMessage(this.token,message);
    }

    public WebHookDto setWebhook(URL url){
       return telegramBotClient.setWebhook(this.token,url);
    }

    public void removeWebHook(){
        telegramBotClient.deleteWebHook(this.token);
    }
}
