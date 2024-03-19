package net.project.library.repository;

import net.project.library.model.Reader;
import net.project.library.model.TakenBooks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TakenBooksRepository extends JpaRepository<TakenBooks, Integer> {
}
