package net.project.library.model;

import javax.persistence.*;

@Entity
@Table(name = "taken_books")
public class TakenBooks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "reader_id")
    private String readerId;
    @Column(name = "book_id")

    private String bookId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TakenBooks() {
    }
    public String getReaderId() {
        return readerId;
    }

    public void setReaderId(String readerId) {
        this.readerId = readerId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "TakenBooks{" +
                "id=" + id +
                ", readerId='" + readerId + '\'' +
                ", bookId='" + bookId + '\'' +
                '}';
    }
}
