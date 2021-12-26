package com.gmail.lilllung09.airlinereservation.vo;

import java.time.LocalDateTime;

public class TestVO {
    private String id;
    private String name;
    private LocalDateTime localDateTime;



    public TestVO() {
        this("0000", "default");
    }
    public TestVO(String id, String name) {
        this(id, name, LocalDateTime.now());
    }
    public TestVO(String id, String name, LocalDateTime localDateTime) {
        this.id = id;
        this.name = name;
        this.localDateTime = localDateTime;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }
}
