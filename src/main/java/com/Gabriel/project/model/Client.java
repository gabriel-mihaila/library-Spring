package com.Gabriel.project.model;

import javax.persistence.*;

/**
 * The type Client.
 */
@Entity
@Table
public class Client {
    @Id
    @SequenceGenerator(
            name = "client_sequence",
            sequenceName = "client_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "client_sequence"
    )
    private Integer id;
    private String name;
    private String address;
    private String email;
    private Integer age;

    /**
     * Instantiates a new Client.
     */
    public Client() {
    }

    /**
     * Instantiates a new Client.
     *
     * @param name    the name
     * @param address the address
     * @param email   the email
     * @param age     the age
     */
    public Client(String name, String address, String email, Integer age) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.age = age;
    }

    /**
     * Instantiates a new Client.
     *
     * @param id      the id
     * @param name    the name
     * @param address the address
     * @param email   the email
     * @param age     the age
     */
    public Client(int id, String name, String address, String email, Integer age) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.age = age;
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
     * Gets address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets age.
     *
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets age.
     *
     * @param age the age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
