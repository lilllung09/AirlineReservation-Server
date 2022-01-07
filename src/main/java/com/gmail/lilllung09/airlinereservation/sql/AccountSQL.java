package com.gmail.lilllung09.airlinereservation.sql;

import org.apache.ibatis.annotations.Select;

public class AccountSQL {
    public static final String TABLE_ACCOUNT = "ACCOUNT";

    public static final String SELECT_ALL = "SELECT * FROM " + TABLE_ACCOUNT;
    public static final String SIGNUP_ACCOUNT = "INSERT INTO " + TABLE_ACCOUNT + "(id, pw, name, birth, gender, ph, mail) VALUES(#{id}, #{pw}, #{name}, #{birth}, #{gender}, #{ph}, #{mail})";

    public String signupAccount() {
        StringBuilder query = new StringBuilder();

        query.append("INSERT INTO ");
        query.append(TABLE_ACCOUNT).append("(id, pw, name, birth, gender, ph, mail)");
        query.append(" VALUES(#{account.id}, #{account.pw}, #{account.name}, #{account.birth}, #{account.gender}, #{account.ph}, #{account.mail})");

        System.out.println(query.toString());

        return query.toString();
    }

    public String isDuplicated() {
        StringBuilder query = new StringBuilder();

        query.append("SELECT ").append("${column} ");
        query.append("FROM ").append(TABLE_ACCOUNT).append(" ");
        query.append("WHERE ").append("${column} = ").append("#{data}");

        System.out.println(query.toString());
        return query.toString();
    }
}
