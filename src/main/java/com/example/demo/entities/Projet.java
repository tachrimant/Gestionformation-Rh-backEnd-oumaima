package com.example.demo.entities;

import javax.persistence.*;
import java.util.List;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Projet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;


    private String libelle;


    private Date dateDebut;


    private Date dateFin;


    @OneToMany(mappedBy="projet")
    @JsonIgnore
   private  List<Tache> tachesList;

}