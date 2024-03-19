package net.project.library.service;

import net.project.library.model.Librarian;
import net.project.library.repository.LibrarianRepository;

import java.util.List;

public class LibrarianService {
    private final LibrarianRepository librarianRepository;

    public LibrarianService(LibrarianRepository librarianRepository) {
        this.librarianRepository = librarianRepository;
    }

    public Librarian findById(int id) {
        return librarianRepository.getOne(id);
    }

    public List<Librarian> findALL() {
        return librarianRepository.findAll();
    }

    public Librarian saveBook(Librarian librarian) {
        return librarianRepository.save(librarian);
    }

    public void deleteById(int id) {
        librarianRepository.deleteById(id);
    }
}
