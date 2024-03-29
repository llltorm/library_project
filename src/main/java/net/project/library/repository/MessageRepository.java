package net.project.library.repository;

import net.project.library.model.Messages;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Интерфейс для взаимодействия с сообщениями для читателя.
 */
public interface MessageRepository extends JpaRepository<Messages, Integer> {
}
