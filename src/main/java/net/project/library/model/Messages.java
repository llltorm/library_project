package net.project.library.model;

import javax.persistence.*;

@Entity
@Table(name = "message_table")
public class Messages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "message")
    private String message;

    public Messages(int id, String message) {
        this.id = id;
        this.message = message;
    }

    public Messages(String message) {
        this.message = message;
    }

    public Messages() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Messages{" +
                "id=" + id +
                ", message='" + message + '\'' +
                '}';
    }
}
