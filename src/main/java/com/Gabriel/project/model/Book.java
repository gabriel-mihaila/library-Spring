package com.Gabriel.project.model;

import javax.persistence.*;

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

    public Book() {
    }

    public Book(String name, String author, Category category, Integer quantity) {
        this.name = name;
        this.author = author;
        this.category = category;
        this.quantity = quantity;
    }

    public Book(Integer id, String name, String author, Category category, Integer quantity) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.category = category;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

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
