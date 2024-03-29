package net.project.library.service;

import net.project.library.model.Book;
import net.project.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Сервис для взаимодействия с книгами.
 */
@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /**
     * Метод поиска книги по id.
     */
    public Book findById(int id) {
        return bookRepository.getOne(id);
    }

    /**
     * Метод поиска всех книг.
     */
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    /**
     * Метод сохранения книги.
     */
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    /**
     * Метод удаления книги по id.
     */
    public void deleteById(int id) {
        bookRepository.deleteById(id);
    }
}
