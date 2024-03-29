package net.project.library.service;

import net.project.library.model.Reader;
import net.project.library.repository.ReaderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Сервис для взаимодействия с читателями.
 */
@Service
public class ReaderService {
    private final ReaderRepository readerRepository;

    public ReaderService(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }

    /**
     * Метод поиска читателя по id.
     */
    public Reader findById(int id) {
        return readerRepository.getOne(id);
    }

    /**
     * Метод поиска всех читателей.
     */
    public List<Reader> findAll() {
        return readerRepository.findAll();
    }

    /**
     * Метод сохранения читателя.
     */
    public Reader saveReader(Reader reader) {
        return readerRepository.save(reader);
    }

    /**
     * Метод удаления читател по id.
     */
    public void deleteById(int id) {
        readerRepository.deleteById(id);
    }
}

