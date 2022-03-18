package com.Gabriel.project.model;

import javax.persistence.*;

@Entity
@Table
public class Borrow {

    @Id
    @SequenceGenerator(
            name = "borrow_sequence",
            sequenceName = "borrow_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "borrow_sequence"
    )
    private Integer id;
    @ManyToOne
    private Client clientID;
    @ManyToOne
    private Book bookID;
    private Integer quantity;

    public Borrow() {
    }

    public Borrow(Client clientID, Book bookID, Integer quantity) {
        this.clientID = clientID;
        this.bookID = bookID;
        this.quantity = quantity;
    }

    public Borrow(Integer id, Client clientID, Book bookID, Integer quantity) {
        this.id = id;
        this.clientID = clientID;
        this.bookID = bookID;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Client getClientID() {
        return clientID;
    }

    public void setClientID(Client clientID) {
        this.clientID = clientID;
    }

    public Book getBookID() {
        return bookID;
    }

    public void setBookID(Book bookID) {
        this.bookID = bookID;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "id=" + id +
                ", clientID=" + clientID +
                ", bookID=" + bookID +
                ", quantity=" + quantity +
                '}';
    }
}
