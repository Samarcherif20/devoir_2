package com.nadhem.produits.entities;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "makeup") 
@JsonPropertyOrder({ "id_makeup", "nom", "marque", "prix", "type", "brandline" })

public class Makeups {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_makeup;

    private String nom;
    private String marque;
    private Double prix;
    private String type;

    @ManyToOne
    @JoinColumn(name = "brand_line_id_ligne_marque")

    private Brandline brandline;

    public Makeups() {
        super();
    }

    public Makeups(String nom, String marque, Double prix, String type) {
        super();
        this.nom = nom;
        this.marque = marque;
        this.prix = prix;
        this.type = type;
    }

    public Long getIdMakeup() {
        return id_makeup;
    }

    public void setIdMakeup(Long id_makeup) {
        this.id_makeup = id_makeup;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Brandline getBrandLine() {
        return brandline;
    }

    public void setBrandLine(Brandline brand_line) {
        this.brandline = brand_line;
    }

    @Override
    public String toString() {
        return "Makeups [id_makeup=" + id_makeup + ", nom=" + nom + ", marque=" + marque 
                + ", prix=" + prix + ", type=" + type + "]";
    }
}
