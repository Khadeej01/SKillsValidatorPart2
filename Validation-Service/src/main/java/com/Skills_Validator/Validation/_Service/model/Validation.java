package com.Skills_Validator.Validation._Service.model;



import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Validation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    private Long apprenantId;
    private Long briefId;
    private Long competenceId;
    private Long validateurId;

    private LocalDateTime dateValidation;

    @Enumerated(EnumType.STRING)
    private StatutValidation statut;

    // Getters et setters
    // Constructeurs (par défaut et avec paramètres)
}