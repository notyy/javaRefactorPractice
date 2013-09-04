package com.github.notyy.reafactoring.middleMan;

public class Department {
    private Person manager;

    public Department(Person manager){
        this.manager = manager;
    }

    public Person getManager() {
        return manager;
    }
}
