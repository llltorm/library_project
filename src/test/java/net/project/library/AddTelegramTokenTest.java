package net.project.library;

import net.project.library.model.Reader;
import net.project.library.repository.ReaderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class AddTelegramTokenTest {

    @Autowired
    private ReaderRepository repo;

    @Test
    public void addNewUserWithMyTelegramToken() {
        Reader reader = new Reader();
        reader.setName("name");
        reader.setEmail("mail@mail.ru");
        reader.setTelegram("1234567890");
        reader.setPassword("$2y$10$doARLHH1dHUCEBPgLW8xpuzpj9LJwBtBzo7rAb4Erin.P625U4tIG");
        reader.setRole("ADMIN");
        repo.save(reader);
        Reader reader2 = repo.findByName(reader.getName());
        reader2.setName("name" + reader2.getId());
        repo.save(reader2);
    }
}
