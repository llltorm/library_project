package net.project.library.service;

import net.project.library.model.Reader;
import net.project.library.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderService {
    private final ReaderRepository readerRepository;

    @Autowired
    public ReaderService(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }

    public Reader findById(int id) {
        return readerRepository.getOne(id);
    }

    public List<Reader> findALL() {
        return readerRepository.findAll();
    }

    public Reader saveReader(Reader reader) {
        return readerRepository.save(reader);
    }

    public void deleteById(int id) {
        readerRepository.deleteById(id);
    }

}

