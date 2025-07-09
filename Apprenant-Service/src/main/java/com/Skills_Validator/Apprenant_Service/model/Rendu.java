package com.Skills_Validator.Apprenant_Service.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
    @Table(name = "rendus")
    public class Rendu {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "brief_id", nullable = false)
        private Long briefId;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "apprenant_id", nullable = false)
        private Apprenant apprenant;

        @Column(columnDefinition = "TEXT")
        private String contenu;

        @Column(name = "url_fichier")
        private String urlFichier;

        @Column(name = "date_soumission")
        private LocalDateTime dateSoumission;

        @Enumerated(EnumType.STRING)
        private StatutRendu statut;

        public Rendu() {}

        public Rendu(Long briefId, Apprenant apprenant, String contenu, String urlFichier) {
            this.briefId = briefId;
            this.apprenant = apprenant;
            this.contenu = contenu;
            this.urlFichier = urlFichier;
            this.dateSoumission = LocalDateTime.now();
            this.statut = StatutRendu.EN_ATTENTE;
        }

        // Getters et Setters
        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }

        public Long getBriefId() { return briefId; }
        public void setBriefId(Long briefId) { this.briefId = briefId; }

        public Apprenant getApprenant() { return apprenant; }
        public void setApprenant(Apprenant apprenant) { this.apprenant = apprenant; }

        public String getContenu() { return contenu; }
        public void setContenu(String contenu) { this.contenu = contenu; }

        public String getUrlFichier() { return urlFichier; }
        public void setUrlFichier(String urlFichier) { this.urlFichier = urlFichier; }

        public LocalDateTime getDateSoumission() { return dateSoumission; }
        public void setDateSoumission(LocalDateTime dateSoumission) { this.dateSoumission = dateSoumission; }

        public StatutRendu getStatut() { return statut; }
        public void setStatut(StatutRendu statut) { this.statut = statut; }
    }

