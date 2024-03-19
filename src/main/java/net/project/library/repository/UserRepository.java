//package net.project.library.repository;
//
//import net.project.library.model.Role;
//import net.project.library.model.User;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//import java.util.Optional;
//
//public interface UserRepository extends JpaRepository<User, Integer> {
//    //Optional<Role> findByRoleName(String username);
//    Optional<User>findByUsernameAndAndPassword(String username, String password);
//
//    Optional<User> findByUsername( String username);
//}
