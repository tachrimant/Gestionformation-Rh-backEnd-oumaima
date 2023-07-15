package com.example.demo.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.text.Normalizer;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormationemEmploye {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;

    @ManyToOne
    private Employe employe;

    @ManyToOne
    private Formation formation;


}
