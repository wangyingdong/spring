package com.f139.aop.pojo;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class User {


    private Integer id;
    private String name;
}
