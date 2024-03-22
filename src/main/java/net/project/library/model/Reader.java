package net.project.library.model;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "readers")
public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "telegram")
    private String telegram;
    @OneToOne
    @JoinColumn(name = "book_id")
    private Book bookId;

    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private String role;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Book getBookId() {
        return bookId;
    }

    public void setBookId(Book bookId) {
        this.bookId = bookId;
    }

    public Reader() {
    }

    public Reader(String name, String email, String telegram) {
        this.name = name;
        this.email = email;
        this.telegram = telegram;
    }

    public Reader(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelegram() {
        return telegram;
    }

    public void setTelegram(String telegram) {
        this.telegram = telegram;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reader reader = (Reader) o;
        return id == reader.id && Objects.equals(name, reader.name) && Objects.equals(email, reader.email) && Objects.equals(telegram, reader.telegram) && Objects.equals(bookId, reader.bookId) && Objects.equals(password, reader.password) && Objects.equals(role, reader.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, telegram, bookId, password, role);
    }

    @Override
    public String toString() {
        return "Reader{" +
                ", name='" + name + '\'' +
                '}';
    }
}
