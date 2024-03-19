//package net.project.library.model;
//
//import javax.persistence.Entity;
//import javax.persistence.Table;
//
//import javax.persistence.*;
//import java.util.Objects;
//
//@Entity
//@Table(name = "roles")
//public class Role {
//    @Id
//    @Column(name = "role_id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    @Column(name = "name", nullable = false)
//    private String roleName;
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getRoleName() {
//        return roleName;
//    }
//
//    public void setRoleName(String roleName) {
//        this.roleName = roleName;
//    }
//
//    @Override
//    public String toString() {
//        return "Role{" +
//                "id=" + id +
//                ", roleName='" + roleName + '\'' +
//                '}';
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Role role = (Role) o;
//        return Objects.equals(id, role.id) && Objects.equals(roleName, role.roleName);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, roleName);
//    }
//}
