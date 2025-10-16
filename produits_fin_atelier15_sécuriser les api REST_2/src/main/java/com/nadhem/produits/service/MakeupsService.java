package com.nadhem.produits.service;

import java.util.List;
import com.nadhem.produits.entities.Brandline;
import com.nadhem.produits.entities.Makeups;

public interface MakeupsService {

    Makeups saveMakeup(Makeups m);
    Makeups updateMakeup(Makeups m);
    void deleteMakeup(Makeups m);
    void deleteMakeupById(Long id);
    Makeups getMakeup(Long id);
    List<Makeups> getAllMakeups();

    List<Makeups> findByNom(String nom);
    List<Makeups> findByNomContains(String nom);
    List<Makeups> findByNomPrix(String nom, Double prix);
    List<Makeups> findByBrandline(Brandline brandline);
    List<Makeups> findByBrand_lineId_ligne_marque(Long id_ligne_marque);
    List<Makeups> findByOrderByNomAsc();
    List<Makeups> trierMakeupsNomPrix();
}
