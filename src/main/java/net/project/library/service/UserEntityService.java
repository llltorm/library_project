//package net.project.library.service;
//
//import net.project.library.config.PasswordConfig;
//import net.project.library.model.User;
//import net.project.library.repository.RoleRepository;
//import net.project.library.repository.UserRepository;
//import org.springframework.stereotype.Component;
//
//@Component
//public class UserEntityService {
//    private final RoleRepository roleRepository;
//    private final PasswordConfig passwordEncoder;
//    private final UserRepository userRepository;
//
//    public UserEntityService(RoleRepository roleRepository, PasswordConfig passwordEncoder, UserRepository userRepository) {
//        this.roleRepository = roleRepository;
//        this.passwordEncoder = passwordEncoder;
//        this.userRepository = userRepository;
//    }
//
//    public User register(String username, String password){
//        if(username!=null && password !=null){
//            User user = new User();
//            user.setUsername(username);
//            user.setPassword(passwordEncoder.passwordEncoder().encode(password));
//
//            user.setRole(roleRepository.findByRoleName("USER").orElse(null));
//
//            return userRepository.save(user);
//        }
//        else return null;
//    }
//
//    public User authenticate(String username ,String password){
//        return userRepository.findByUsernameAndAndPassword(username,password)
//                .orElse(null);
//    }
//}
