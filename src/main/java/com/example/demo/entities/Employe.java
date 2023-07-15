package com.example.demo.entities;

import javax.persistence.*;
import java.util.List;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import com.example.demo.zynerator.security.bean.User;
import com.example.demo.zynerator.util.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Employe extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cin;

    @JsonFormat(locale = DateUtil.DEFAULT_DATE_FORMAT)
    private LocalDate datenaissance;

    @ManyToMany
    @JsonIgnore
    private List<Formation> formations;

}