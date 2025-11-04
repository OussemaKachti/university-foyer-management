package com.example.project.services;

import com.example.project.Entities.Universite;
import com.example.project.repository.UniversiteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UniversiteServiceImpl implements IUniversite {

    private final UniversiteRepository universiteRepository;

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
}
