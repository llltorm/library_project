package net.project.library.service;

import net.project.library.model.Messages;
import net.project.library.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Сервис для взаимодействия с сообщениями читателю в телеграмме.
 */
@Service
public class MessageService {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    /**
     * Метод поиска сообщения по id.
     */
    public Messages findById(int id) {
        return messageRepository.getOne(id);
    }

    /**
     * Метод поиска всех сообщений.
     */
    public List<Messages> findAll() {
        return messageRepository.findAll();
    }

    /**
     * Метод сохранения сообщения.
     */
    public Messages saveMessage(Messages messages) {
        return messageRepository.save(messages);
    }

    /**
     * Метод удаления сообщения по id.
     */
    public void deleteById(int id) {
        messageRepository.deleteById(id);
    }
}
