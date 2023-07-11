package com.example.demo.entities;

import javax.persistence.*;
import java.util.List;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DemandeDeficheDepaie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;


    private Date datedemande;


    private Date dateEnvoieFiche;


    @ManyToOne() 
 private  Employe employe;


    @ManyToOne() 
 private  EtatDemandeFicheDepaie etat;


}