package net.project.library.service;

import net.project.library.model.Messages;
import net.project.library.repository.MessageRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MessageServiceTest {

    @Mock
    private MessageRepository messageRepository;

    @InjectMocks
    private MessageService messageService;

    @Test
    public void testFindAllMessage() {
        Messages messages = new Messages();
        Mockito.when(messageRepository.findAll()).thenReturn(List.of(messages));
        List<Messages> result = messageService.findAll();
        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.size());
    }

    @Test
    public void testCreateMessage() {
        Messages messages = new Messages();
        messages.setMessage("Hello world");
        when(messageService.saveMessage(messages)).thenReturn(messages);
        Messages result = messageService.saveMessage(messages);
        Assertions.assertNotNull(result);
        Assertions.assertEquals("Hello world", result.getMessage());
        verify(messageRepository).save(result);
    }

    @Test
    public void testFindMessageById() {
        Messages messages = new Messages();
        messages.setId(1);
        when(messageService.findById(1)).thenReturn(messages);
        Messages returnedMessage = messageService.findById(1);
        assertEquals(messages.getId(), returnedMessage.getId());
    }

    @Test
    public void deleteMessage() {
        messageService.deleteById(1);
        verify(messageRepository).deleteById(1);
    }
}
