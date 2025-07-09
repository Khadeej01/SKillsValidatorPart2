package com.Skills_Validator.Apprenant_Service.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "apprenants")
public class Apprenant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String motDePasse;

    @Column(name = "date_inscription")
    private LocalDateTime dateInscription;

    @OneToMany(mappedBy = "apprenant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Rendu> rendus;

    public Apprenant() {}

    public Apprenant(String nom, String prenom, String email, String motDePasse) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.dateInscription = LocalDateTime.now();
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

    public List<Rendu> getRendus() { return rendus; }
    public void setRendus(List<Rendu> rendus) { this.rendus = rendus; }
}

