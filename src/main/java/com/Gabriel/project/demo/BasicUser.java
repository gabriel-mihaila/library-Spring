package com.Gabriel.project.demo;


/**
 * The type Basic user.
 */
public abstract class BasicUser {
    private String name ;
    private String lastName ;


    /**
     * The Data source.
     */
    public DataSource dataSource;

    /**
     * Instantiates a new Basic user.
     *
     * @param name     the name
     * @param lastName the last name
     */
    public BasicUser(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
        dataSource = new DataSourceImpl();
    }

    /**
     * Compute acces days int.
     *
     * @return the int
     */
    public abstract int computeAccesDays();

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }


}
