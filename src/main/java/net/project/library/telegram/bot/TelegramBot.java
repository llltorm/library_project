package net.project.library.telegram.bot;

import net.project.library.telegram.config.BotConfig;
import net.project.library.model.Messages;
import net.project.library.model.Reader;
import net.project.library.repository.MessageRepository;
import net.project.library.repository.ReaderRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 * Класс для взаимодействия пользователя с телеграмм ботом.
 */
@Component
public class TelegramBot extends TelegramLongPollingBot {

    private final ReaderRepository readerRepository;
    private final MessageRepository messageRepository;
    private final BotConfig config;

    public TelegramBot(BotConfig config, MessageRepository messageRepository, ReaderRepository readerRepository) {
        this.config = config;
        this.messageRepository = messageRepository;
        this.readerRepository = readerRepository;
    }

    /**
     * Метод возвращает имя пользователя в телеграмм.
     */
    @Override
    public String getBotUsername() {
        return config.getBotName();
    }

    /**
     * Метод возвращает токен телеграмм бота, который должен отправить сообщение.
     */
    @Override
    public String getBotToken() {
        return config.getToken();
    }

    /**
     * Метод, который срабатывает каждый раз при получении ботом нового сообщения
     * от пользователя.
     *
     * @param update - класс телеграмм бота, в котором хранится информация о пользователе,
     *              отправившим сообщение
     */
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();

            switch (messageText) {
                case "/start":
                    startCommandReceived(chatId, update.getMessage().getChat().getFirstName());
                    break;
                case "/MyChatId":
                    sendMessage(chatId, String.valueOf(chatId));
                    break;
                default:
                    sendMessage(chatId, "Sorry, command was not recognized(");
            }
        }

    }

    /**
     * Метод ответа пользователя на от вет /start.
     *
     * @param chatId - идентификатор чата, куда нужно отправить сообщение
     * @param name - ник пользователя, которому нужно отправить сообщение
     */
    private void startCommandReceived(long chatId, String name) {
        String answer = "Hi " + name + ", nice to meet you!";
        sendMessage(chatId, answer);
    }

    /**
     * Метод отправки текстового сообщения пользователю.
     *
     * @param chatId - идентификатор чата, куда нужно отправить сообщение
     * @param textToSend - текст, который необходимо отправить пользователю
     */
    private void sendMessage(long chatId, String textToSend) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(textToSend);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            System.out.println("Ошибка отправки сообщения в телеграмм" + e);
        }
    }

    /**
     * Метод автоматической отправки уведомления о возвращении книги в библиотеку.
     */
    @Scheduled(cron = "0 * * * * *")
    private void automaticSendMessage() {
        try {
            var messages = messageRepository.findAll();
            var readers = readerRepository.findAll();
            for (Messages message : messages) {
                for (Reader reader : readers) {
                    sendMessage(Long.parseLong(reader.getTelegram()), message.getMessage());
                }
            }
            messageRepository.deleteAll();
        } catch (Exception e) {
            System.out.println("Ошибка отправки уведомления в телеграмм" + e);
        }
    }
}
