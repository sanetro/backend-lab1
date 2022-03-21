package com.lab1;

public class User {
    private String name;
    private String surname;
    private int age;

    public User(){

    }

    public void setName(String name){
        this.name = name;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }
    public void setAge(int age){this.age = age;}

    public String getName(){
        return this.name;
    }

    public String getSurname(){
        return this.surname;
    }
    public int getAge(){
        return this.age;
    }
}
