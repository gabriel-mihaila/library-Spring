package com.Gabriel.project.model;

import javax.persistence.*;

/**
 * The type Borrow.
 */
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

    /**
     * Instantiates a new Borrow.
     */
    public Borrow() {
    }

    /**
     * Instantiates a new Borrow.
     *
     * @param clientID the client id
     * @param bookID   the book id
     * @param quantity the quantity
     */
    public Borrow(Client clientID, Book bookID, Integer quantity) {
        this.clientID = clientID;
        this.bookID = bookID;
        this.quantity = quantity;
    }

    /**
     * Instantiates a new Borrow.
     *
     * @param id       the id
     * @param clientID the client id
     * @param bookID   the book id
     * @param quantity the quantity
     */
    public Borrow(Integer id, Client clientID, Book bookID, Integer quantity) {
        this.id = id;
        this.clientID = clientID;
        this.bookID = bookID;
        this.quantity = quantity;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets client id.
     *
     * @return the client id
     */
    public Client getClientID() {
        return clientID;
    }

    /**
     * Sets client id.
     *
     * @param clientID the client id
     */
    public void setClientID(Client clientID) {
        this.clientID = clientID;
    }

    /**
     * Gets book id.
     *
     * @return the book id
     */
    public Book getBookID() {
        return bookID;
    }

    /**
     * Sets book id.
     *
     * @param bookID the book id
     */
    public void setBookID(Book bookID) {
        this.bookID = bookID;
    }

    /**
     * Gets quantity.
     *
     * @return the quantity
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Sets quantity.
     *
     * @param quantity the quantity
     */
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
