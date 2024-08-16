package com.example.demo.entity;

import com.example.demo.enums.Gender;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public class User extends BaseEntity {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String family;

    @Column(unique = true, updatable = false)
    private long nationalCode;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Data birthDay;


    @Column(unique = true, nullable = false, updatable = false)
    private String username;


    @Column(nullable = false)
    private String password;

}
