package com.oraclejava.hellospringmvc.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;
import java.util.Date;

public class Member {
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z0-9]{6,12}$")
    private String id;
    @NotEmpty
    private String name;
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z0-9]{6,12}$")
    private String password;
    private Date birth;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }
}
