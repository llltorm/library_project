package net.project.library;

import net.project.library.model.Reader;
import net.project.library.repository.ReaderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class AddTelegramToken {

    @Autowired
    private ReaderRepository repo;

    @Test
    public void addToken() {
        Reader reader = new Reader();
        reader.setName("admin1");
        reader.setEmail("mail@mail.ru");
        reader.setTelegram("1234567890");
        reader.setPassword("$2y$10$doARLHH1dHUCEBPgLW8xpuzpj9LJwBtBzo7rAb4Erin.P625U4tIG");
        reader.setRole("Admin");
        repo.save(reader);
    }

}
