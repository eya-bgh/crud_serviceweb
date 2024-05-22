package com.example.demo.Controller;

import com.example.demo.Services.AdministrationService;
import com.example.demo.entities.Administration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/administrations")
public class AdministrationController {

    @Autowired
    private AdministrationService administrationService;

    @GetMapping
    public List<Administration> getAllAdministrations() {
        return administrationService.getAllAdministrations();
    }

    @GetMapping("/{id}")
    public Administration getAdministrationById(@PathVariable Long id) {
        return administrationService.getAdministrationById(id);
    }

    @PostMapping
    public Administration createAdministration(@RequestBody Administration administration) {
        return administrationService.createOrUpdateAdministration(administration);
    }

    @PutMapping("/{id}")
    public Administration updateAdministration(@PathVariable Long id, @RequestBody Administration administrationDetails) {
        Administration administration = administrationService.getAdministrationById(id);
        if (administration != null) {
            administration.setFirstName(administrationDetails.getFirstName());
            administration.setLastName(administrationDetails.getLastName());
            administration.setEmail(administrationDetails.getEmail());
            // Ajoutez d'autres attributs à mettre à jour selon votre modèle
            return administrationService.createOrUpdateAdministration(administration);
        } else {
            // Gérer l'absence de l'administration avec l'ID spécifié
            // Ici, nous retournons null, ce qui peut être amélioré selon les besoins de votre application.
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteAdministration(@PathVariable Long id) {
        administrationService.deleteAdministration(id);
    }
}
