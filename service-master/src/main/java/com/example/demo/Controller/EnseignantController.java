package com.example.demo.Controller;

import com.example.demo.Services.EnseignantService;
import com.example.demo.entities.Enseignant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/enseignants")
public class EnseignantController {

    @Autowired
    private EnseignantService enseignantService;

    @GetMapping
    public List<Enseignant> getAllEnseignants() {
        return enseignantService.getAllEnseignats();
    }

    @GetMapping("/{id}")
    public Enseignant getEnseignantById(@PathVariable Long id) {
        return enseignantService.getEnseignantById(id);
    }

    @PostMapping
    public Enseignant createEnseignant(@RequestBody Enseignant enseignant) {
        return enseignantService.createOrUpdateEnseignant(enseignant);
    }

    @PutMapping("/{id}")
    public Enseignant updateEnseignant(@PathVariable Long id, @RequestBody Enseignant enseignantDetails) {
        Enseignant enseignant = enseignantService.getEnseignantById(id);
        if (enseignant != null) {
            enseignant.setFirstName(enseignantDetails.getFirstName());
            enseignant.setLastName(enseignantDetails.getLastName());
            enseignant.setEmail(enseignantDetails.getEmail());
            // Ajoutez d'autres attributs à mettre à jour selon votre modèle
            return enseignantService.createOrUpdateEnseignant(enseignant);
        } else {
            // Gérer l'absence de l'enseignant avec l'ID spécifié
            // Ici, nous retournons null, ce qui peut être amélioré selon les besoins de votre application.
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteEnseignant(@PathVariable Long id) {
        enseignantService.deleteEnseignant(id);
    }
}
