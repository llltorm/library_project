package net.project.library.service;

import net.project.library.config.BotConfig;
import net.project.library.model.Messages;
import net.project.library.model.Reader;
import net.project.library.repository.MessageRepository;
import net.project.library.repository.ReaderRepository;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class TelegramBot extends TelegramLongPollingBot {

    private final ReaderRepository readerRepository;
    private final MessageRepository messageRepository;

    final BotConfig config;

    public TelegramBot(BotConfig config, MessageRepository messageRepository, ReaderRepository readerRepository) {
        this.config = config;
        this.messageRepository = messageRepository;
        this.readerRepository = readerRepository;
    }
    @Override
    public String getBotUsername() {
        return config.getBotName();
    }

    @Override
    public String getBotToken() {
        return config.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {

        if(update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();
            switch (messageText){
                case "/start":
                    startCommandReceived(chatId, update.getMessage().getChat().getFirstName());
                    break;
                case "/MyChatId":
                    sendMessage(chatId, String.valueOf(chatId));
                    break;
                default: sendMessage(chatId, "Sorry, command was not recognized(");
            }
        }

    }

    private void startCommandReceived(long chatId, String name) {
        String answer = "Hi " + name +", nice to meet you!";
        sendMessage(chatId, answer);
    }

    private void sendMessage(long chatId, String textToSend) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(textToSend);
        try {
            execute(message);
        }
        catch(TelegramApiException e){

        }
    }

    @Scheduled(cron = "0 * * * * *")
    private void AutomaticSendMessage() {
        try {
            var messages = messageRepository.findAll();
            var readers = readerRepository.findAll();
            for(Messages message: messages) {
                for (Reader reader : readers) {
                    sendMessage(Long.parseLong(reader.getTelegram()), message.getMessage());
                }
            }
            messageRepository.deleteAll();
        } catch (Exception e) {
            System.out.println("нет книг для отправки уведомления читателям");
        }
    }

}
