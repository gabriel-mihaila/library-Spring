package com.Gabriel.project.demo;

public class UserFactory {

    public BasicUser createUser(UserType userType){
        if(userType.equals(UserType.EMPLOYEE))
            return new Employee("Matei", "Grigore");
        if(userType.equals(UserType.OBSERVER))
            return new Observer("Mihai", "Dumitru");
        if(userType.equals(UserType.EXTERN))
            return new Extern("Flavia", "Muntean");

        return null;
    }
}
