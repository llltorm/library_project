package net.project.library.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "readers")
public class Reader{
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

    public Book getBookId() {
        return bookId;
    }

    public void setBookId(Book bookId) {
        this.bookId = bookId;
    }

    public Reader() {
    }
//    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
//            CascadeType.REFRESH, CascadeType.DETACH})
//    @Column(name = "book_id", nullable = false)
//    private String bookId;

//    @Column(name = "password", nullable = false)
//    private String password;

//    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
//    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
//    @Enumerated(EnumType.STRING)
//    private Set<Role> roles;

    //--------------------------------------------
//    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
//            CascadeType.REFRESH, CascadeType.DETACH})
//    //@JoinColumn(name = "reader_id")
//    @JoinTable(
//            name = "taken_books",
//            joinColumns = @JoinColumn(name = "reader_id"),
//            inverseJoinColumns = @JoinColumn(name = "book_id")
//    )
//    private List<Book> listTakenBooks;

    //--------------------------------------------
//    public void addBookToReader(Book book) {
//        if (listTakenBooks == null) {
//            listTakenBooks = new ArrayList<>();
//        }
//        listTakenBooks.add(book);
//    }
//
//
//    public void deleteBookToReader(Book book) {
//        listTakenBooks.remove(book);
//    }
//
//    public Reader() {
//    }
//
//    public List<Book> getListTakenBooks() {
//        return listTakenBooks;
//    }
//
//    public void setListTakenBooks(List<Book> listTakenBooks) {
//        this.listTakenBooks = listTakenBooks;
//    }

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

//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }

//    public Set<Role> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(Set<Role> roles) {
//        this.roles = roles;
//    }

//    @Override
//    public String toString() {
//        return "Reader{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", email='" + email + '\'' +
//                ", telegram='" + telegram + '\'' +
//                '}';
//    }

    @Override
    public String toString() {
        return "Reader{" +
                ", name='" + name + '\'' +
                '}';
    }
}
