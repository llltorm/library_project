package net.project.library.repository;

import net.project.library.model.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Имплементация интерфейса для взаимодействия с читателями.
 */
public interface ReaderRepository extends JpaRepository<Reader, Integer> {
    /**
     * Поиск читателя по имени.
     *
     * @param name - имя читателя
     */
    Reader findByName(String name);
}
