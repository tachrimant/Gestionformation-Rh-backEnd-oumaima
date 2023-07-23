package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Formation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;


    private String title;


    private String description;

    private String etatformation;


    private Date dateDebut;


    private Date dateFin;


    @OneToMany(mappedBy = "formation")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
     private  List<FormationemEmploye> formationemEmployes;

}