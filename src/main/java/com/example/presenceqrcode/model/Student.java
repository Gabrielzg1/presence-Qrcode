package com.example.presenceqrcode.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, name="name")
    private String name;

    @Column(nullable = false, name="ra", unique=true)
    private String ra;

    @Lob
    @Column( length = 100000 )
    private String img;
}
