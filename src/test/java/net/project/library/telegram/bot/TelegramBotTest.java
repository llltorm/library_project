package net.project.library.telegram.bot;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.Message;

@ExtendWith(MockitoExtension.class)
public class TelegramBotTest {

    @Mock
    private TelegramBot telegramBot;

    @Test
    public void test_onUpdateReceived() {
        Update update = new Update();
        Message message = new Message();
        Chat chat = new Chat();
        message.setText("/start");
        chat.setId(1739275216L);
        chat.setFirstName("llltorm");
        message.setChat(chat);
        update.setMessage(message);
        telegramBot.onUpdateReceived(update);
    }
}
