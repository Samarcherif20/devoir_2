package com.nadhem.produits.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.nadhem.produits.entities.Brandline;

@RepositoryRestResource(path = "brd")
public interface BrandlineRepository extends JpaRepository<Brandline, Long> {

}
