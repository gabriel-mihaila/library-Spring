package com.Gabriel.project.model;

import javax.persistence.*;

/**
 * The type Category.
 */
@Entity
@Table
public class Category {
    @Id
    @SequenceGenerator(
            name = "category_sequence",
            sequenceName = "category_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "category_sequence"
    )
    private Integer id;
    private String name;

    /**
     * Instantiates a new Category.
     */
    public Category() {
    }

    /**
     * Instantiates a new Category.
     *
     * @param name the name
     */
    public Category(String name) {
        this.name = name;
    }

    /**
     * Instantiates a new Category.
     *
     * @param id   the id
     * @param name the name
     */
    public Category(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
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

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
