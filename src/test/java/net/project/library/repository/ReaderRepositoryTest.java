package net.project.library.repository;

import net.project.library.model.Reader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(true)
public class ReaderRepositoryTest {
    @Autowired
    private ReaderRepository repo;

    @Test
    public void testAddNewReader() {
        Reader reader = new Reader();
        reader.setName("Пётр Петров");
        reader.setEmail("mail@mail.ru");
        reader.setTelegram("343245657");
        Reader saveReader = repo.save(reader);
        Assertions.assertEquals(saveReader.getName(), "Пётр Петров");
        Assertions.assertEquals(saveReader.getEmail(), "mail@mail.ru");
        Assertions.assertEquals(saveReader.getTelegram(), "343245657");
    }

    @Test
    public void testFindAllReaders() {
        Iterable<Reader> readers = repo.findAll();
        Assertions.assertNotNull(readers);
        for (Reader reader : readers) {
            System.out.println(reader);
        }
    }

    @Test
    public void testFindReadersByName() {
        Reader reader = new Reader();
        reader.setName("Пётр Петров");
        reader.setEmail("mail@mail.ru");
        reader.setTelegram("343245657");
        repo.save(reader);
        Reader nameSaveReader = repo.findByName("Пётр Петров");
        System.out.println(nameSaveReader.getName());
        Assertions.assertEquals(nameSaveReader.getName(), "Пётр Петров");
        Assertions.assertEquals(nameSaveReader.getEmail(), "mail@mail.ru");
        Assertions.assertEquals(nameSaveReader.getTelegram(), "343245657");
    }

    @Test
    public void testUpdateReader() {
        Reader reader = new Reader();
        reader.setName("Пётр Петров");
        reader.setEmail("mail@mail.ru");
        reader.setTelegram("343245657");
        repo.save(reader);
        int readerId = reader.getId();
        Optional<Reader> optionalReader = repo.findById(readerId);
        Reader newReader = optionalReader.get();
        newReader.setName("Пётр Петров1");
        newReader.setEmail("mail@mail.ru1");
        newReader.setTelegram("3432456571");
        repo.save(newReader);
        Assertions.assertEquals(newReader.getName(), "Пётр Петров1");
        Assertions.assertEquals(newReader.getEmail(), "mail@mail.ru1");
        Assertions.assertEquals(newReader.getTelegram(), "3432456571");
    }

    @Test
    public void testFindReaderById() {
        Reader reader = new Reader();
        reader.setName("Пётр Петров");
        reader.setEmail("mail@mail.ru");
        reader.setTelegram("343245657");
        repo.save(reader);
        int readerId = reader.getId();
        Optional<Reader> optionalReader = repo.findById(readerId);
        Reader newReader = optionalReader.get();
        Assertions.assertEquals(newReader.getId(), readerId);
        System.out.println(optionalReader.get());
    }

    @Test
    public void testDeleteReaderById() {
        Reader reader = new Reader();
        reader.setName("Летающий слон");
        reader.setEmail("mail@mail.ru");
        reader.setTelegram("343245657");
        repo.save(reader);
        int readerId = reader.getId();
        boolean isExistBeforeDelete = repo.findById(readerId).isPresent();
        repo.deleteById(readerId);
        boolean notExistAfterDelete = repo.findById(readerId).isPresent();
        Assertions.assertTrue(isExistBeforeDelete);
        Assertions.assertFalse(notExistAfterDelete);
    }
}
