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
public class EmployeDto {
    private Long id;
    private String cin;


    private String nom;


    private String prenom;


    private String email;


    private Date datenaissance;


}