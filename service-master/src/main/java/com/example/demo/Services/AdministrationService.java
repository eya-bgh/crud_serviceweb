package com.example.demo.Services;

import com.example.demo.entities.Administration;
import com.example.demo.repositories.AdministrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministrationService {

    @Autowired
    private AdministrationRepository administrationRepository;

    public List<Administration> getAllAdministrations() {
        return administrationRepository.findAll();
    }

    public Administration getAdministrationById(Long id) {
        return administrationRepository.findById(id).get();
    }

    public Administration createOrUpdateAdministration(Administration administration) {
        return administrationRepository.save(administration);
    }

    public void deleteAdministration(Long id) {
        administrationRepository.deleteById(id);
    }
}
