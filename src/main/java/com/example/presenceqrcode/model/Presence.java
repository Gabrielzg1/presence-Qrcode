package com.example.presenceqrcode.model;

import lombok.Data;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Presence {
    @Id
    private String id; //subject name

    @Column(nullable = false, name="name")
    private LocalDate date;

    @ElementCollection
    private List<Long> presenceList = null;


}
