package com.example.presenceqrcode.model;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data // Getters and Setters
@Entity
public class Teacher {
    @Id
    private String id;

    @Column(nullable = false, name="name")
    private String name;

    @Column(nullable = false, name="subject", unique = true)
    private String subject;

    @ElementCollection
    private List<Long> studentsRa;

}

