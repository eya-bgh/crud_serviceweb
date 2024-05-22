package com.example.demo.Services;


import com.example.demo.entities.Enseignant;
import com.example.demo.repositories.EnseignantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EnseignantService {

    @Autowired
    private EnseignantRepository enseigantRepository;

    public List<Enseignant> getAllEnseignats() {
        return enseigantRepository.findAll();
    }

    public Enseignant getEnseignantById(Long id) {
        return enseigantRepository.findById(id).get();
    }

    public Enseignant createOrUpdateEnseignant(Enseignant enseignant) {
        return enseigantRepository.save(enseignant);
    }

    public void deleteEnseignant(Long id) {
        enseigantRepository.deleteById(id);
    }
}
