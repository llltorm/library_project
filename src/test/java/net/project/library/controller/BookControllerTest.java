package net.project.library.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.project.library.model.Book;
import net.project.library.service.BookService;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = BookController.class)
@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
@AutoConfigureMockMvc
public class BookControllerTest {

    @MockBean
    private BookService bookService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test_createBook() throws Exception {
        Book book = new Book("Война и мир", "Лев Толстой");
        when(bookService.saveBook(book)).thenReturn(book);
        mockMvc.perform(post("/book-create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(book)))
                .andExpect(redirectedUrl("/books"))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    void test_showCreateBookForm() throws Exception {
        mockMvc.perform(get("/book-create"))
                .andExpect(status().isOk());
    }

    @Test
    void test_findAllBook() throws Exception {
        List<Book> bookList = Arrays.asList(new Book("Война и мир", "Лев Толстой"),
                new Book("Преступление и наказание", "Фёдор Достоевский"));
        when(bookService.findAll()).thenReturn(bookList);
        mockMvc.perform(get("/books")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void test_updateBook() throws Exception {
        Book book = new Book("Война и мир", "Лев Толстой");
        when(bookService.findById(book.getId())).thenReturn(book);
        mockMvc.perform(post("/book-update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(book)))
                .andExpect(redirectedUrl("/books"))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    void test_showUpdateBookForm() throws Exception {
        Book book = new Book("Война и мир", "Лев Толстой");
        when(bookService.findById(book.getId())).thenReturn(book);
        mockMvc.perform(get("/book-update/{id}", book.getId()))
                .andExpect(status().isOk());
    }

    @Test
    void test_deleteBook() throws Exception {
        Book book = new Book("Война и мир", "Лев Толстой");
        doNothing().when(bookService).deleteById(book.getId());
        mockMvc.perform(get("/book-delete/{id}", book.getId()))
                .andExpect(redirectedUrl("/books"));
    }
}
