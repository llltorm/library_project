package net.project.library.service;

import net.project.library.model.Messages;
import net.project.library.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Messages findById(int id) {
        return messageRepository.getOne(id);
    }

    public List<Messages> findAll() {
        return messageRepository.findAll();
    }

    public Messages saveMessage(Messages messages) {
        return messageRepository.save(messages);
    }

    public void deleteById(int id) {
        messageRepository.deleteById(id);
    }
}
