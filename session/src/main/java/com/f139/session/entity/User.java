package com.f139.session.entity;

import lombok.*;

import java.io.Serializable;


@Getter
@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 8655851615465363473L;
    private Long id;
    private String username;
    private String password;


}
