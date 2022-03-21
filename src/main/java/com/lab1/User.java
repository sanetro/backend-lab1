package com.lab1;

public class User {
    private String name;
    private String surname;
    private String[] hobby;

    public User(String name, String surname, String[] hobby){
        this.name = name;
        this.surname = surname;
        this.hobby = hobby;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setSurname(){
        this.surname = surname;
    }

    public String getName(){
        return this.name;
    }

    public String getSurname(){
        return this.surname;
    }
}
