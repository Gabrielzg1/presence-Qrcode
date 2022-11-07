package com.example.presenceqrcode.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Presence {
    @Id
    private String id; //subject name

    @ElementCollection
    private List<Long> presenceList = null;


}
