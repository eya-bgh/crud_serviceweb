package com.example.demo.repositories;

import com.example.demo.entities.Administration;
import com.example.demo.entities.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministrationRepository extends JpaRepository<Administration, Long> {
}
