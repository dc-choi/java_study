package com.oraclejava.hellospringmvc.model;

import org.hibernate.validator.constraints.NotEmpty;

public class Login {

    @NotEmpty
    private String id;

    @NotEmpty
    private String pass;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
