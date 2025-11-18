package com.example.project.services;

import com.example.project.Entities.Bloc;
import com.example.project.Entities.Chambre;
import com.example.project.repository.BlocRepository;
import com.example.project.repository.ChambreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ChambreServiceImpl implements IChambre {

    private final ChambreRepository chambreRepository;
    private final BlocRepository blocRepository;

    @Override
    public Chambre create(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public Chambre update(Long id, Chambre chambre) {
        chambre.setIdChambre(id);
        return chambreRepository.save(chambre);
    }

    @Override
    public void delete(Long id) {
        chambreRepository.deleteById(id);
    }

    @Override
    public List<Chambre> getAll() {
        return chambreRepository.findAll();
    }

    @Override
    public Chambre getById(Long id) {
        return chambreRepository.findById(id).orElseThrow(() -> new RuntimeException("Chambre not found"));
    }

    @Override
    public Chambre affecterChambreABloc(Long idChambre, Long idBloc) {
        Chambre chambre = chambreRepository.findById(idChambre)
                .orElseThrow(() -> new RuntimeException("Chambre not found"));
        
        Bloc bloc = blocRepository.findById(idBloc)
                .orElseThrow(() -> new RuntimeException("Bloc not found"));
        
        chambre.setBloc(bloc);
        return chambreRepository.save(chambre);
    }
}
