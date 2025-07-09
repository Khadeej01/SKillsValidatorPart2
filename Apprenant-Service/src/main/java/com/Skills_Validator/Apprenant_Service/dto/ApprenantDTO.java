package com.Skills_Validator.Apprenant_Service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.List;

public class ApprenantDTO {

        private Long id;

        @NotBlank(message = "Le nom est obligatoire")
        private String nom;

        @NotBlank(message = "Le prénom est obligatoire")
        private String prenom;

        @Email(message = "Email invalide")
        @NotBlank(message = "L'email est obligatoire")
        private String email;

        @Size(min = 6, message = "Le mot de passe doit contenir au moins 6 caractères")
        private String motDePasse;

        private LocalDateTime dateInscription;
        private List<RenduDto> rendus;

        public ApprenantDto() {}

        public ApprenantDto(String nom, String prenom, String email, String motDePasse) {
            this.nom = nom;
            this.prenom = prenom;
            this.email = email;
            this.motDePasse = motDePasse;
        }

        public ApprenantDTO(String nom, String prenom, String email, String motDePasse) {
        }

        // Getters et Setters
        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }

        public String getNom() { return nom; }
        public void setNom(String nom) { this.nom = nom; }

        public String getPrenom() { return prenom; }
        public void setPrenom(String prenom) { this.prenom = prenom; }

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }

        public String getMotDePasse() { return motDePasse; }
        public void setMotDePasse(String motDePasse) { this.motDePasse = motDePasse; }

        public LocalDateTime getDateInscription() { return dateInscription; }
        public void setDateInscription(LocalDateTime dateInscription) { this.dateInscription = dateInscription; }

        public List<RenduDto> getRendus() { return rendus; }
        public void setRendus(List<RenduDto> rendus) { this.rendus = rendus; }
    }


