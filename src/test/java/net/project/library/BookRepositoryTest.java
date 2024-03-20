package net.project.library;

import net.project.library.model.Book;
import net.project.library.repository.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(true)
public class BookRepositoryTest {

    @Autowired
    private BookRepository repo;

    @Test
    public void testAddNewBook() {
        Book book = new Book();
        book.setName("Летающий слон");
        book.setAuthor("Борис Акунин");
        Book saveBook = repo.save(book);
        Assertions.assertEquals(saveBook.getName(), "Летающий слон");
        Assertions.assertEquals(saveBook.getAuthor(), "Борис Акунин");
        Assertions.assertNotEquals(saveBook.getId(), 0);
    }

    @Test
    public void testFindAllBook() {
        Iterable<Book> books = repo.findAll();
        Assertions.assertNotNull(books);
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    public void testFindBookByName() {
        Book book = new Book();
        book.setName("Летающий слон");
        book.setAuthor("Борис Акунин");
        Book nameSaveBook = repo.findByName("Летающий слон");
        System.out.println(nameSaveBook.getName());
        Assertions.assertEquals(nameSaveBook.getName(), "Тёмные начала");
    }

    @Test
    public void testUpdateBook() {
        Book book = new Book();
        book.setName("Летающий слон");
        book.setAuthor("Борис Акунин");
        repo.save(book);
        int bookId = book.getId();
        Optional<Book> optionalBook = repo.findById(bookId);
        Book newBook = optionalBook.get();
        book.setName("Гордость и предубеждение1");
        book.setAuthor("Акунин Борис");
        repo.save(book);
        Assertions.assertEquals(newBook.getName(), "Гордость и предубеждение1");
        Assertions.assertEquals(newBook.getAuthor(), "Акунин Борис");
    }

    @Test
    public void testFindBookById() {
        Book book = new Book();
        book.setName("Летающий слон");
        book.setAuthor("Борис Акунин");
        repo.save(book);
        int bookId = book.getId();
        Optional<Book> optionalBook = repo.findById(bookId);
        Book newBook = optionalBook.get();
        Assertions.assertEquals(newBook.getId(), bookId);
        System.out.println(optionalBook.get());
    }

    @Test
    public void testDeleteBookById() {
        Book book = new Book();
        book.setName("Летающий слон");
        book.setAuthor("Борис Акунин");
        repo.save(book);
        int bookId = book.getId();
        boolean isExistBeforeDelete = repo.findById(bookId).isPresent();
        repo.deleteById(bookId);
        boolean notExistAfterDelete = repo.findById(bookId).isPresent();
        Assertions.assertTrue(isExistBeforeDelete);
        Assertions.assertFalse(notExistAfterDelete);
    }

}
