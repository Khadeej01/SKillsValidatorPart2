package com.Skills_Validator.Apprenant_Service.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "rendus")
public class Rendu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    @Temporal(TemporalType.TIMESTAMP)
    private Date datedepot;

    private String statutRendu;
    private String lien;

    @ManyToOne
    @JoinColumn(name = "apprenant_id")
    private Apprenant apprenant;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public Date getDatedepot() { return datedepot; }
    public void setDatedepot(Date datedepot) { this.datedepot = datedepot; }
    public String getStatutRendu() { return statutRendu; }
    public void setStatutRendu(String statutRendu) { this.statutRendu = statutRendu; }
    public String getLien() { return lien; }
    public void setLien(String lien) { this.lien = lien; }
    public Apprenant getApprenant() { return apprenant; }
    public void setApprenant(Apprenant apprenant) { this.apprenant = apprenant; }
}
