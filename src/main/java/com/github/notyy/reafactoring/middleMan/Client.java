package com.github.notyy.reafactoring.middleMan;

public class Client {
    public static void main(String[] args){
        Person notyy = new Person("notyy");
        Person john = new Person("john");
        Department department = new Department(notyy);
        john.setDepartment(department);
        System.out.println(john.getManager().getName());
    }
}
