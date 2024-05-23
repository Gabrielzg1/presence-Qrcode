package com.example.presenceqrcode.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class User {
    @Id
    private Long id;

    @Column(nullable = false, name="name")
    private String name;

    @ElementCollection
    private List<String> subjects;

    @Lob
    @Column( length = 100000 )
    private String img;

    @Column(nullable = false, name = "presence")
    private Boolean presence = false;
}
