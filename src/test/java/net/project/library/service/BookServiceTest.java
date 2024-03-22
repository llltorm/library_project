package net.project.library.service;

import net.project.library.model.Book;
import net.project.library.repository.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    public void testFindAllBooks() {
        Book book = new Book();
        Mockito.when(bookRepository.findAll()).thenReturn(List.of(book));
        List<Book> result = bookService.findALL();
        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.size());
    }

    @Test
    public void testCreateBook() {
        Book book = new Book();
        book.setName("bookName");
        when(bookService.saveBook(book)).thenReturn(book);
        Book result = bookService.saveBook(book);
        Assertions.assertNotNull(result);
        Assertions.assertEquals("bookName", result.getName());
        verify(bookRepository).save(result);
    }

    @Test
    public void testFindBookById() {
        Book book = new Book();
        book.setId(1);
        when(bookRepository.findById(1)).thenReturn(Optional.of(book));
        Optional returnedBook = bookRepository.findById(1);
        Book newReturnedBook = (Book) returnedBook.get();
        assertEquals(book.getId(), newReturnedBook.getId());
    }

    @Test
    void deleteBook() {
        bookService.deleteById(1);
        verify(bookRepository).deleteById(1);
    }
}
