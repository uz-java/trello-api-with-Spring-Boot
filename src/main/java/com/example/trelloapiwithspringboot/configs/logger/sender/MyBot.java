package com.example.trelloapiwithspringboot.configs.logger.sender;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.HashSet;
import java.util.Set;

/**
 * @author "Tojaliyev Asliddin"
 * @since 13/11/22 00:38 (Sunday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
public class MyBot extends TelegramLongPollingBot {

    private static Set<String> chatIds = new HashSet<>(Set.of("5016346952")); //Chat ids are automatically added to hashset but you can save them at database of your choice.
    @Override
    public String getBotUsername() {
        return "asliddincontact_bot";
    }

    @Override
    public String getBotToken() {
        return "AAEIQ7CTN1Q3rTYld7wLX1pfrBRAdeP0p2I"; // enter bot token. You can take it from botFather on telegram.
    }

    @Override
    public void onUpdateReceived(Update update) {
        chatIds.add(update.getMessage().getChatId().toString());
    }

    public void SendMessage(String message) {
        for (String chatId : chatIds) {
            SendMessage sendMessage = new SendMessage(chatId, message);
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
