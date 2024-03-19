package net.project.library.repository;

import net.project.library.model.Reader;
//import net.project.library.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReaderRepository extends JpaRepository<Reader, Integer> {

    Reader findByName(String name);
    //List<Book> findBookBy
    //<User> findByUsernameAndAndPassword(String username, String password);
    //List<Reader> getAllReadersIds(List<Integer> ids);
}
