package com.Gabriel.project.demo;

public class Observer extends BasicUser{
    public Observer(String name, String lastName) {
        super(name, lastName);
    }

    public int computeAccesDays() {
        return this.dataSource.getMinimumDays() * 30;
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
