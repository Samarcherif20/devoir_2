package com.nadhem.produits.entities;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Brandline {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLigneMarque;
    
    private String nom_ligne;
    private String description;
    private String public_cible;
    private Date date_lancement;
    
    @JsonIgnore
    @OneToMany(mappedBy = "brandline")
    private List<Makeups> makeups;
}
