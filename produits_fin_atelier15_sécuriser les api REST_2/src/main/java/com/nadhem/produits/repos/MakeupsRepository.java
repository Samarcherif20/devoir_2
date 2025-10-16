package com.nadhem.produits.repos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.nadhem.produits.entities.Brandline;
import com.nadhem.produits.entities.Makeups;

public interface MakeupsRepository extends JpaRepository<Makeups, Long> {

    List<Makeups> findByNom(String nom);

    List<Makeups> findByNomContains(String nom);

    @Query("SELECT m FROM Makeups m WHERE m.nom LIKE %:nom% AND m.prix > :prix")
    List<Makeups> findByNomPrix(@Param("nom") String nom, @Param("prix") Double prix);

    @Query("SELECT m FROM Makeups m WHERE m.brandline = :brandline")
    List<Makeups> findByBrandline(@Param("brandline") Brandline brandline);


    List<Makeups> findByBrandline_IdLigneMarque(Long idLigneMarque);

    List<Makeups> findByOrderByNomAsc();

    @Query("SELECT m FROM Makeups m ORDER BY m.nom ASC, m.prix DESC")
    List<Makeups> trierMakeupsNomPrix();
}
