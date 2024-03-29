package net.project.library.repository;

import net.project.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Интерфейс для взаимодействия с книгами
 */
public interface BookRepository extends JpaRepository<Book, Integer> {
    /**
     * Поиск книги по названию.
     *
     * @param name - название книги
     */
    Book findByName(String name);
}
