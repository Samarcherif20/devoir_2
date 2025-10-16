package com.nadhem.produits.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nadhem.produits.entities.Brandline;
import com.nadhem.produits.entities.Makeups;
import com.nadhem.produits.repos.MakeupsRepository;

@Service
public class MakeupsServiceImpl implements MakeupsService {

    @Autowired
    MakeupsRepository makeupsRepository;

    @Override
    public Makeups saveMakeup(Makeups m) {
        return makeupsRepository.save(m);
    }

    @Override
    public Makeups updateMakeup(Makeups m) {
        return makeupsRepository.save(m);
    }

    @Override
    public void deleteMakeup(Makeups m) {
        makeupsRepository.delete(m);
    }

    @Override
    public void deleteMakeupById(Long id) {
        makeupsRepository.deleteById(id);
    }

    @Override
    public Makeups getMakeup(Long id) {
        return makeupsRepository.findById(id).get();
    }

    @Override
    public List<Makeups> getAllMakeups() {
        return makeupsRepository.findAll();
    }

    @Override
    public List<Makeups> findByNom(String nom) {
        return makeupsRepository.findByNom(nom);
    }

    @Override
    public List<Makeups> findByNomContains(String nom) {
        return makeupsRepository.findByNomContains(nom);
    }

    @Override
    public List<Makeups> findByNomPrix(String nom, Double prix) {
        return makeupsRepository.findByNomPrix(nom, prix);
    }

    @Override
    public List<Makeups> findByBrandline(Brandline brandline) {
        return makeupsRepository.findByBrandline(brandline);
    }

    @Override
    public List<Makeups> findByBrand_lineId_ligne_marque(Long id_ligne_marque) {
        return makeupsRepository.findByBrandline_IdLigneMarque(id_ligne_marque);
    }

    @Override
    public List<Makeups> findByOrderByNomAsc() {
        return makeupsRepository.findByOrderByNomAsc();
    }

    @Override
    public List<Makeups> trierMakeupsNomPrix() {
        return makeupsRepository.trierMakeupsNomPrix();
    }
}
