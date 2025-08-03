package com.Skills_Validator.Apprenant_Service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "Le nom est obligatoire") String getNom() {
        return nom;
    }

    public void setNom(@NotBlank(message = "Le nom est obligatoire") String nom) {
        this.nom = nom;
    }

    public @NotBlank(message = "Le prénom est obligatoire") String getPrenom() {
        return prenom;
    }

    public void setPrenom(@NotBlank(message = "Le prénom est obligatoire") String prenom) {
        this.prenom = prenom;
    }

    public @Email(message = "Email invalide") @NotBlank(message = "L'email est obligatoire") String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "Email invalide") @NotBlank(message = "L'email est obligatoire") String email) {
        this.email = email;
    }

    public @Size(min = 6, message = "Le mot de passe doit contenir au moins 6 caractères") String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(@Size(min = 6, message = "Le mot de passe doit contenir au moins 6 caractères") String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public LocalDateTime getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(LocalDateTime dateInscription) {
        this.dateInscription = dateInscription;
    }

    public List<RenduDto> getRendus() {
        return rendus;
    }

    public void setRendus(List<RenduDto> rendus) {
        this.rendus = rendus;
    }
}
