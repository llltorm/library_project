package net.project.library.repository;

import net.project.library.model.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReaderRepository extends JpaRepository<Reader, Integer> {

    Reader findByTelegram(String idChatUser);

    Reader findByName(String name);
}
