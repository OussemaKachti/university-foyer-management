package com.example.project.services;

import com.example.project.Entities.Foyer;
import com.example.project.Entities.Universite;
import com.example.project.repository.FoyerRepository;
import com.example.project.repository.UniversiteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UniversiteServiceImpl implements IUniversite {

    private final UniversiteRepository universiteRepository;
    private final FoyerRepository foyerRepository;

    @Override
    public Universite create(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public Universite update(Long id, Universite universite) {
        universite.setIdUniversite(id);
        return universiteRepository.save(universite);
    }

    @Override
    public void delete(Long id) {
        universiteRepository.deleteById(id);
    }

    @Override
    public List<Universite> getAll() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite getById(Long id) {
        return universiteRepository.findById(id).orElseThrow(() -> new RuntimeException("Universite not found"));
    }

    @Override
    public Universite affecterFoyerAUniversite(Long idUniversite, Long idFoyer) {
        Universite universite = universiteRepository.findById(idUniversite)
                .orElseThrow(() -> new RuntimeException("Universite not found"));
        
        Foyer foyer = foyerRepository.findById(idFoyer)
                .orElseThrow(() -> new RuntimeException("Foyer not found"));
        
        universite.setFoyer(foyer);
        foyer.setUniversite(universite);
        
        return universiteRepository.save(universite);
    }
}
