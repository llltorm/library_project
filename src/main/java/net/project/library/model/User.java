//package net.project.library.model;
//
//import javax.persistence.*;
//import java.util.Objects;
//
//@Entity
//@Table(name = "users")
//@Inheritance(strategy = InheritanceType.JOINED)
//public class User {
//    @Id
//    @Column(name = "user_id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//    @Column(name = "username", nullable = false)
//    private String username;
//    @Column(name = "password", nullable = false)
//    private String password;
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "role")
//    private Role role;
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public Role getRole() {
//        return role;
//    }
//
//    public void setRole(Role role) {
//        this.role = role;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        User user = (User) o;
//        return Objects.equals(id, user.id) && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(role, user.role);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, username, password, role);
//    }
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", username='" + username + '\'' +
//                ", role=" + role +
//                '}';
//    }
//}
