package net.project.library.repository;

import net.project.library.model.Messages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Messages, Integer> {
}
