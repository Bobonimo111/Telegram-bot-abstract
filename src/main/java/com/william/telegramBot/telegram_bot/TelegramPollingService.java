package com.william.telegramBot.telegram_bot;

import com.william.telegramBot.telegram_bot.dto.GetUpdatesDTO;
import com.william.telegramBot.telegram_bot.dto.UpdateDTO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class TelegramPollingService implements CommandLineRunner {

    private final TelegramClientService botClient;
    private final TelegramMessageBotService messageBot;
    private Long lastUpdateId = 0L;

    public TelegramPollingService(TelegramClientService botClient, TelegramMessageBotService messageBot) {
        this.botClient = botClient;
        this.messageBot = messageBot;
    }

    @Override
    public void run(String... args) throws Exception {

            while (true) {
                try {
                    GetUpdatesDTO response = botClient.getUpdates(lastUpdateId + 1, 30);

                    if (response != null) {
                        response.result().forEach(this::processUpdate);

                        // atualiza o offset para não chamar a mesma mensagem novamente
                        this.lastUpdateId = response.result().stream()
                                .map(UpdateDTO::update_id)
                                .max(Long::compareTo)
                                .orElse(lastUpdateId);
                    }
                } catch (Exception e) {
                    System.err.println("Error fetching updates: " + e.getMessage());
                    try { Thread.sleep(5000); } catch (InterruptedException ignored) {}
                }
            }

    }
    private void processUpdate(UpdateDTO update) {
        this.messageBot.controller(update);
    }
}
