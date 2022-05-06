package com.Gabriel.project.demo;

public class Employee extends BasicUser{
    public Employee(String name, String lastName) {
        super(name, lastName);
    }

    public int computeAccesDays() {
        return this.dataSource.getMinimumDays() * 40;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Employee;
    }
}
