package com.william.telegramBot.telegram_bot.interactions.commands.impl;

import com.william.telegramBot.telegram_bot.TelegramClientService;
import com.william.telegramBot.telegram_bot.dto.obj.ISendMessageBase;
import com.william.telegramBot.telegram_bot.dto.obj.InlineKeyboardButton;
import com.william.telegramBot.telegram_bot.dto.obj.Replymarkup;
import com.william.telegramBot.telegram_bot.dto.obj.SendMessageReplyMarkup;
import com.william.telegramBot.telegram_bot.exception.InteractionException;
import com.william.telegramBot.telegram_bot.interactions.IInterraction;
import com.william.telegramBot.telegram_bot.interactions.commands.CommandsContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class start implements IInterraction<CommandsContext> {

    private final TelegramClientService telegramClientService;
    private CommandsContext context;

    public start(TelegramClientService telegramClientService) {
        this.telegramClientService = telegramClientService;
    }

    @Override
    public void action() throws InteractionException {
        this.telegramClientService.sendMessage(this.makeMenu());
    }

    @Override
    public String getType() {
        return "start";
    }

    @Override
    public void setContext(CommandsContext context) {
        this.context  = context;
    }

    @Override
    public CommandsContext getContext() {
        return context;
    }

    private ISendMessageBase makeMenu(){
        InlineKeyboardButton testeBTN = new InlineKeyboardButton();
        testeBTN.setText("teste");
        testeBTN.setCallbackData("DATA-TESTE");


        SendMessageReplyMarkup message = new SendMessageReplyMarkup();
        Replymarkup replymarkup =  Replymarkup.builder()
                .inlineKeyboard(List.of(List.of(testeBTN)))
                .build();

        message.setChatId(this.context.chatId());
        message.setText("Menu principal");
        message.setReplyMarkup(replymarkup);

        return message;
    }
}
