package com.shamonin.catalog.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name="players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "gender")
    private String gender;

    @Column(name = "birthDayDate")
    private Date birthDayDate;

    @Column(name = "teamName")
    private String teamName;

    @Column(name = "Country")
    private String Country;
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;
    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

}




