package com.gmail.lilllung09.airlinereservation.state;

public enum AccountState {
    //////////////////////////////////////////////////
    // 일반
    //////////////////////////////////////////////////
    Normal("normal", true),

    //////////////////////////////////////////////////
    // 에러
    //////////////////////////////////////////////////
    UNKNOWN("unknown", false),

    InvalidNAME("invalid name", false),
    InvalidID("invalid id", false),
    InvalidPW("invalid pw", false),
    InvalidBIRTH("invalid birth", false),
    InvalidPH("invalid ph", false),
    InvalidMAIL("invalid mail", false),

    DuplicatedID("duplicated id", false),
    DuplicatedPH("duplicated ph", false),
    DuplicatedMAIL("duplicated mail", false);



    private String state;
    private boolean able;

    private AccountState(String state, boolean able) {
        this.state = state;
        this.able = able;
    }

    public String getState() {
        return this.state;
    }
    public boolean getAble() {
        return this.able;
    }
}
