package com.gmail.lilllung09.airlinereservation.object;

import com.gmail.lilllung09.airlinereservation.util.HashValue;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class AccountDTO {
    private String id, pw;
    private String name;

    private LocalDate birth;
    private boolean gender;

    private String ph, mail;

    private LocalDateTime t_signUp;

    public AccountDTO() {}

    @Override
    public String toString() {
        return "AccountDTO["
                + "," + id
                + "," + pw
                + "," + name
                + "," + birth
                + "," + gender
                + "," + ph
                + "," + mail
                + "," + t_signUp
                + "]";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        try {
            return HashValue.getHashValue(pw);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return this.pw;
        }
    }
    public String getPwOrigin() {
        return this.pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public LocalDateTime getT_signUp() {
        return t_signUp;
    }

    public void setT_signUp(LocalDateTime t_signUp) {
        this.t_signUp = t_signUp;
    }
}
