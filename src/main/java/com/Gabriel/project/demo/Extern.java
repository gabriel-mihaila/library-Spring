package com.Gabriel.project.demo;

public class Extern extends BasicUser{
    public Extern(String name, String lastName) {
        super(name, lastName);
    }

    public int computeAccesDays() {
        return this.dataSource.getMinimumDays() * 10;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
