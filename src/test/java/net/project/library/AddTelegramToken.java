package net.project.library;

import net.project.library.model.Book;
import net.project.library.model.Reader;
import net.project.library.repository.ReaderRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
public class AddTelegramToken {

    @Autowired
    private ReaderRepository repo;

    @Test
    public void addToken() {
        Reader reader = new Reader();
        reader.setName("Admin Admin");
        reader.setEmail("mail@mail.ru");
        reader.setTelegram("343245657");
        repo.save(reader);
    }

}
