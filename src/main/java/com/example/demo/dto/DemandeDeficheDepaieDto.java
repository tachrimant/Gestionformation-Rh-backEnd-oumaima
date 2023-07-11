package com.example.demo.dto;

import java.util.List;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DemandeDeficheDepaieDto {
    private Long id;
    private String code;


    private Date datedemande;


    private Date dateEnvoieFiche;


    private EmployeDto employeDto;


    private EtatDemandeFicheDepaieDto etatDto;


}