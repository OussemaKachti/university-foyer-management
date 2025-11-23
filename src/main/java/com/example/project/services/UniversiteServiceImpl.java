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
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        Universite universite = universiteRepository.findByNomUniversite(nomUniversite)
                .orElseThrow(() -> new RuntimeException("Universite not found with name: " + nomUniversite));
        
        Foyer foyer = foyerRepository.findById(idFoyer)
                .orElseThrow(() -> new RuntimeException("Foyer not found with id: " + idFoyer));
        
        universite.setFoyer(foyer);
        foyer.setUniversite(universite);
        
        return universiteRepository.save(universite);
    }

    @Override
    public Universite desaffecterFoyerAUniversite(long idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite)
                .orElseThrow(() -> new RuntimeException("Universite not found with id: " + idUniversite));
        
        if (universite.getFoyer() != null) {
            Foyer foyer = universite.getFoyer();
            universite.setFoyer(null);
            foyer.setUniversite(null);
        }
        
        return universiteRepository.save(universite);
    }
}
