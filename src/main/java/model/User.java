package model;

import java.util.Objects;

public class User {
    private Long id;
    private String name;
    private String lastName;

    public User() {

    }

    public User(Long id, String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
        this.id = id;

    }

    public User(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }


    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setName(String name) {
        this.name = name;
    }

}