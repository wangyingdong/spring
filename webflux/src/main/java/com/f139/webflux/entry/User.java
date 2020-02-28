package com.f139.webflux.entry;


import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;


@Builder
@Data
@Document(collection = "user")
public class User {

    @Id
    private String id;

    @NotEmpty
    private String name;

    @Range(min = 10,max = 100)
    private Integer age;

    private String email;

    private Gender gender;


}

