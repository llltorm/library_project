package net.project.library.security;

import net.project.library.model.Reader;
import net.project.library.repository.ReaderRepository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Сервис для загрузки пользовательских данных.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final ReaderRepository readerRepository;

    public CustomUserDetailsService(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }

    /**
     * Реализация загрузки пользователя.
     *
     * @param name - имя пользователя, данные, которого загружаются в систему
     * @return - возвращает пользовательские данные
     */
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Reader reader = readerRepository.findByName(name);
        if (reader == null) {
            throw new UsernameNotFoundException("User not Found");
        }
        return new CustomUserDetails(reader);
    }
}
