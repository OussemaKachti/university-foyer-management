package com.example.project.services;

import com.example.project.Entities.Etudiant;
import com.example.project.repository.EtudiantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EtudiantServiceImpl implements IEtudiant {

    private final EtudiantRepository etudiantRepository;

    @Override
    public Etudiant create(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public Etudiant update(Long id, Etudiant etudiant) {
        etudiant.setIdEtudiant(id);
        return etudiantRepository.save(etudiant);
    }

    @Override
    public void delete(Long id) {
        etudiantRepository.deleteById(id);
    }

    @Override
    public List<Etudiant> getAll() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant getById(Long id) {
        return etudiantRepository.findById(id).orElseThrow(() -> new RuntimeException("Etudiant not found"));
    }
}
