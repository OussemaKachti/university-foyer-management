package com.example.project.services;

import com.example.project.Entities.Foyer;
import com.example.project.repository.FoyerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FoyerServiceImpl implements IFoyer {

    private final FoyerRepository foyerRepository;

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
}
