//package net.project.library.service;
//
//import net.project.library.model.CustomUserDetails;
//import net.project.library.repository.UserRepository;
//import net.project.library.model.User;
//
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Component
//public class CustomUserDetailsService implements UserDetailsService {
//
//    private final UserRepository userRepository;
//
//    public CustomUserDetailsService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<User> user = userRepository.findByUsername(username);
////        if(user == null) {
////            throw new UsernameNotFoundException("User not Found");
////        }
//        CustomUserDetails customUserDetails = new CustomUserDetails(user);
//        return customUserDetails;
//        //return new CustomUserDetails(user);
//    }
//}
