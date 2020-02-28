package com.spring.mybatis.entity;


public enum Sex {

    UNKNOW("未知"), MALE("男"), FEMALE("女");

    private String value;

    private Sex(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String toString() {
        return this.getValue();
    }


}
