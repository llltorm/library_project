package net.project.library.repository;

import net.project.library.model.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibrarianRepository extends JpaRepository<Librarian, Integer> {
}
