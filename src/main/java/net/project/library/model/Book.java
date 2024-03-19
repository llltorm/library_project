package net.project.library.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "author")
    private String author;

//    @Column(name = "reader_id")
//    private int readerId;
//
//    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
//            CascadeType.REFRESH, CascadeType.DETACH})
//    @JoinTable(
//            name = "taken_books",
//            joinColumns = @JoinColumn(name = "book_id"),
//            inverseJoinColumns = @JoinColumn(name = "reader_id")
//    )
//    private List<Reader> listReaders;
//
//    public List<Reader> getListReaders() {
//        return listReaders;
//    }
//
//    public void setListReaders(List<Reader> listReaders) {
//        this.listReaders = listReaders;
//    }

    public Book() {
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

//    public int getReaderId() {
//        return readerId;
//    }
//
//    public void setReaderId(int readerId) {
//        this.readerId = readerId;
//    }

//    @Override
//    public String toString() {
//        return "Book{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", author='" + author + '\'' +
//                '}';
//    }


    @Override
    public String toString() {
        return this.name;
    }
}
