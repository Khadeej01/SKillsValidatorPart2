package com.Skills_Validator.Brief_Service.Entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Brief {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String contexte;
    private String outils;
    private String livrable;

    public Brief(Long id, String contexte, String outils, String livrable) {
        this.id = id;
        this.contexte = contexte;
        this.outils = outils;
        this.livrable = livrable;
    }

    public Brief() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContexte() {
        return contexte;
    }

    public void setContexte(String contexte) {
        this.contexte = contexte;
    }

    public String getOutils() {
        return outils;
    }

    public void setOutils(String outils) {
        this.outils = outils;
    }

    public String getLivrable() {
        return livrable;
    }

    public void setLivrable(String livrable) {
        this.livrable = livrable;
    }
}
