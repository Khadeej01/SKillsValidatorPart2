package com.Skills_Validator.Apprenant_Service.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "apprenants")
@PrimaryKeyJoinColumn(name = "id")
public class Apprenant extends Utilisateur {

    @OneToMany(mappedBy = "apprenant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rendu> rendus;

    public List<Rendu> getRendus() { return rendus; }
    public void setRendus(List<Rendu> rendus) { this.rendus = rendus; }
}
