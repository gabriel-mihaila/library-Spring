package com.Gabriel.project.model;

import javax.persistence.*;

/**
 * The type Book.
 */
@Entity
@Table
public class Book {
    @Id
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )
    private Integer id;
    private String name;
    private String author;
    @ManyToOne
    private Category category;
    private Integer quantity;

    /**
     * Instantiates a new Book.
     */
    public Book() {
    }

    /**
     * Instantiates a new Book.
     *
     * @param name     the name
     * @param author   the author
     * @param category the category
     * @param quantity the quantity
     */
    public Book(String name, String author, Category category, Integer quantity) {
        this.name = name;
        this.author = author;
        this.category = category;
        this.quantity = quantity;
    }

    /**
     * Instantiates a new Book.
     *
     * @param id       the id
     * @param name     the name
     * @param author   the author
     * @param category the category
     * @param quantity the quantity
     */
    public Book(Integer id, String name, String author, Category category, Integer quantity) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.category = category;
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
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets author.
     *
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets author.
     *
     * @param author the author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Gets category.
     *
     * @return the category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Sets category.
     *
     * @param category the category
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * Gets quantity.
     *
     * @return the quantity
     */
    public int getQuantity() {
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
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", category=" + category +
                ", quantity=" + quantity +
                '}';
    }
}
