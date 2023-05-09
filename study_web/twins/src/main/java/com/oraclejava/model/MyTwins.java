package com.oraclejava.model;

import java.util.Date;

public class MyTwins {
    private String name;
    private Date dob;

    public MyTwins() {}

    public MyTwins(String dob) {
        String str = dob
                .replace("년", "")
                .replace("월", "")
                .replace("일", "")
                .replace(" ", "/");
        this.dob = new Date(str);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setDob(String dob) {
        String str = dob
                .replace("년", "")
                .replace("월", "")
                .replace("일", "")
                .replace(" ", "/");
        this.dob = new Date(str);
    }

    @Override
    public String toString() {
        return "MyTwins{" +
                "name='" + name + '\'' +
                ", dob=" + dob +
                '}';
    }
}
