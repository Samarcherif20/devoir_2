package com.nadhem.produits.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomMakeup", types = { Makeups.class })
public interface MakeupProjection {
	public String getNomMakeup();
}

