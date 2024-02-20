package com.shamonin.catalog.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "teamName")
    private String teamName;

    @Column(name = "country")
    private String country;

}
