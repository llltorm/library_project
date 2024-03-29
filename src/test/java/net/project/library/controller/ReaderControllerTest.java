package net.project.library.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.project.library.model.Book;
import net.project.library.model.Messages;
import net.project.library.model.Reader;
import net.project.library.service.BookService;
import net.project.library.service.MessageService;
import net.project.library.service.ReaderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import javax.ws.rs.core.MediaType;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = ReaderController.class)
@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
@AutoConfigureMockMvc
public class ReaderControllerTest {

    @MockBean
    private ReaderService readerService;

    @MockBean
    private BookService bookService;

    @MockBean
    private MessageService messageService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test_createReader() throws Exception {
        Reader reader = new Reader("Пётр петров", "wer@mail.ru", "1234567890");
        when(readerService.saveReader(reader)).thenReturn(reader);
        mockMvc.perform(post("/reader-create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(reader)))
                .andExpect(redirectedUrl("/readers"))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    void test_showCreateReaderForm() throws Exception {
        mockMvc.perform(get("/reader-create"))
                .andExpect(status().isOk());
    }

    @Test
    void test_findAllReader() throws Exception {
        List<Reader> readerList = Arrays.asList(new Reader("Пётр петров", "wer@mail.ru", "1234567890"),
                new Reader("Алексей Алексеев", "asd@mail.ru", "0987654321"));
        when(readerService.findAll()).thenReturn(readerList);
        mockMvc.perform(get("/readers")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


    @Test
    void test_updateReader() throws Exception {
        Reader reader = new Reader("Пётр петров", "wer@mail.ru", "1234567890");
        when(readerService.findById(reader.getId())).thenReturn(reader);
        mockMvc.perform(post("/reader-update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(reader)))
                .andExpect(redirectedUrl("/readers"))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    void test_showUpdateReaderForm() throws Exception {
        Reader reader = new Reader("Пётр петров", "wer@mail.ru", "1234567890");
        when(readerService.findById(reader.getId())).thenReturn(reader);
        mockMvc.perform(get("/reader-update/{id}", reader.getId()))
                .andExpect(status().isOk());
    }

    @Test
    void test_deleteReader() throws Exception {
        Reader reader = new Reader("Пётр петров", "wer@mail.ru", "1234567890");
        doNothing().when(readerService).deleteById(reader.getId());
        mockMvc.perform(get("/reader-delete/{id}", reader.getId()))
                .andExpect(redirectedUrl("/readers"));
    }

    @Test
    void test_showAddTakenBookForm() throws Exception {
        Reader reader = new Reader("Пётр петров", "wer@mail.ru", "1234567890");
        List<Book> bookList = Arrays.asList(new Book("Война и мир", "Лев Толстой"),
                new Book("Преступление и наказание", "Фёдор Достоевский"));
        when(readerService.findById(reader.getId())).thenReturn(reader);
        when(bookService.findAll()).thenReturn(bookList);
        when(bookService.findById(bookList.get(0).getId())).thenReturn(bookList.get(0));
        mockMvc.perform(get("/add-take-book/{id}", reader.getId()))
                .andExpect(status().isOk());
    }

    @Test
    void test_addTakenBook() throws Exception {
        Reader reader = new Reader("Пётр петров", "wer@mail.ru", "1234567890");
        Book book = new Book("Война и мир", "Лев Толстой");
        reader.setBookId(book);
        when(readerService.saveReader(reader)).thenReturn(reader);
        mockMvc.perform(post("/add-take-book")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(reader)))
                .andExpect(redirectedUrl("/readers"))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    void test_deleteTakenBook() throws Exception {
        Reader reader = new Reader("Пётр петров", "wer@mail.ru", "1234567890");
        Book book = new Book("Война и мир", "Лев Толстой");
        Messages message = new Messages("Hello world");
        reader.setBookId(book);
        when(readerService.findById(reader.getId())).thenReturn(reader);
        when(bookService.findById(book.getId())).thenReturn(book);
        when(readerService.saveReader(reader)).thenReturn(reader);
        when(messageService.saveMessage(message)).thenReturn(message);
        mockMvc.perform(get("/reader-delete-take-book/{id}", reader.getId()))
                .andExpect(redirectedUrl("/readers"));
    }
}
