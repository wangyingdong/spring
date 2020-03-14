package com.f139.security.entry;


import lombok.*;


@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    private String name;
    private String email;


}
