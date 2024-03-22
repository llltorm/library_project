package net.project.library.service;

import net.project.library.model.CustomUserDetails;
import net.project.library.model.Reader;
import net.project.library.repository.ReaderRepository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final ReaderRepository readerRepository;

    public CustomUserDetailsService(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Reader reader = readerRepository.findByName(name);
        if(reader == null) {
            throw new UsernameNotFoundException("User not Found");
        }
        return new CustomUserDetails(reader);
//        CustomUserDetails customUserDetails = new CustomUserDetails(user);
//        return customUserDetails;
//        //return new CustomUserDetails(user);
    }
}
