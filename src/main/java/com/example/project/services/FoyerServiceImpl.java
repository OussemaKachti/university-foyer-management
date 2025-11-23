package com.example.project.services;

import com.example.project.Entities.Bloc;
import com.example.project.Entities.Foyer;
import com.example.project.Entities.Universite;
import com.example.project.repository.FoyerRepository;
import com.example.project.repository.UniversiteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class FoyerServiceImpl implements IFoyer {

    private final FoyerRepository foyerRepository;
    private final UniversiteRepository universiteRepository;

    @Override
    public Foyer create(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public Foyer update(Long id, Foyer foyer) {
        foyer.setIdFoyer(id);
        return foyerRepository.save(foyer);
    }

    @Override
    public void delete(Long id) {
        foyerRepository.deleteById(id);
    }

    @Override
    public List<Foyer> getAll() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer getById(Long id) {
        return foyerRepository.findById(id).orElseThrow(() -> new RuntimeException("Foyer not found"));
    }

    @Override
    @Transactional
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite)
                .orElseThrow(() -> new RuntimeException("Universite not found with id: " + idUniversite));
        
        if (foyer.getBlocs() != null) {
            for (Bloc bloc : foyer.getBlocs()) {
                bloc.setFoyer(foyer);
            }
        }
        
        Foyer savedFoyer = foyerRepository.save(foyer);
        
        universite.setFoyer(savedFoyer);

        universiteRepository.save(universite);
        
        return foyerRepository.findById(savedFoyer.getIdFoyer()).orElse(savedFoyer);
    }
}
