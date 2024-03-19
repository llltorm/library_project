package net.project.library.service;

import net.project.library.model.Reader;
import net.project.library.model.TakenBooks;
import net.project.library.repository.ReaderRepository;
import net.project.library.repository.TakenBooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TakenBooksService {
    private final TakenBooksRepository takenBooksRepository;

    @Autowired
    public TakenBooksService(TakenBooksRepository takenBooksRepository) {
        this.takenBooksRepository = takenBooksRepository;
    }

    public TakenBooks findById(int id) {
        return takenBooksRepository.getOne(id);
    }

    public List<TakenBooks> findALL() {
        return takenBooksRepository.findAll();
    }

    public TakenBooks saveTakenBooks(TakenBooks takenBooks) {
        return takenBooksRepository.save(takenBooks);
    }

    public void deleteById(int id) {
        takenBooksRepository.deleteById(id);
    }

}
