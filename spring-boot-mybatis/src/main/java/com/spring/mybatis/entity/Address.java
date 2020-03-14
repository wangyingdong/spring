package com.spring.mybatis.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    private String province;
    private String city;
    private String area;
    private String street;
}
