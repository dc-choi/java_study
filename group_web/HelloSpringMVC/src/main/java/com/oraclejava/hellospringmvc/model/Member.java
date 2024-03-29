package com.oraclejava.hellospringmvc.model;


import org.hibernate.validator.constraints.NotEmpty;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
@Table(name = "tbl_member")
public class Member {

    @Id
    @Column(name = "id")
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z0-9]{6,12}$")
    private String id;

    @Column(name = "name")
    @NotEmpty
    private String name;

    @Column(name = "password")
    @NotEmpty
    private String password;

    @Column(name = "birth")
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
