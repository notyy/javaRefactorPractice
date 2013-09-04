package com.github.notyy.reafactoring.middleMan;

public class Person {
    private Department department;
    private String name;

    public Person(String name){
        this.name = name;
    }

    public Person getManager(){
        return department.getManager();
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }
}
