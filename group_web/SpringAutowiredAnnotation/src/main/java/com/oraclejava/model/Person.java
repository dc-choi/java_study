package com.oraclejava.model;

import org.springframework.beans.factory.annotation.Autowired;

public class Person {
    private String name;
    private Integer age;
    @Autowired
    private Notebook notebook;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Notebook getNotebook() {
        return notebook;
    }

    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
    }
}
