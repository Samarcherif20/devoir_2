package com.nadhem.produits.restcontrollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nadhem.produits.entities.Makeups;
import com.nadhem.produits.service.MakeupsService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class MakeupsRESTController {

    @Autowired
    MakeupsService makeupsService;

    @GetMapping("/all")
    public List<Makeups> getAllMakeups() {
        return makeupsService.getAllMakeups();
    }

    @GetMapping("/getbyid/{id}")
    public Makeups getMakeupById(@PathVariable("id") Long id) {
        return makeupsService.getMakeup(id);
    }

    @PostMapping("/addmakeup")
    public Makeups createMakeup(@RequestBody Makeups makeup) {
        return makeupsService.saveMakeup(makeup);
    }

    @PutMapping("/updatemakeup")
    public Makeups updateMakeup(@RequestBody Makeups makeup) {
        return makeupsService.updateMakeup(makeup);
    }

    @DeleteMapping("/delmakeup/{id}")
    public void deleteMakeup(@PathVariable("id") Long id) {
        makeupsService.deleteMakeupById(id);
    }

    @GetMapping("/makeupsbrandline/{id_ligne_marque}")
    public List<Makeups> getMakeupsByBrandlineId(@PathVariable("id_ligne_marque") Long id_ligne_marque) {
        return makeupsService.findByBrand_lineId_ligne_marque(id_ligne_marque);
    }

    @GetMapping("/auth")
    Authentication getAuth(Authentication auth) {
        return auth;
    }
}
