package com.example.project.services;

import com.example.project.Entities.Bloc;
import com.example.project.Entities.Chambre;
import com.example.project.Entities.Foyer;
import com.example.project.repository.BlocRepository;
import com.example.project.repository.ChambreRepository;
import com.example.project.repository.FoyerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlocServiceImpl implements IBloc {

    private final BlocRepository blocRepository;
    private final FoyerRepository foyerRepository;
    private final ChambreRepository chambreRepository;

    public BlocServiceImpl(BlocRepository blocRepository, FoyerRepository foyerRepository, ChambreRepository chambreRepository) {
        this.blocRepository = blocRepository;
        this.foyerRepository = foyerRepository;
        this.chambreRepository = chambreRepository;
    }

    @Override
    public Bloc create(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc update(Long id, Bloc bloc) {
        bloc.setIdBloc(id);
        return blocRepository.save(bloc);
    }

    @Override
    public void delete(Long id) {
        blocRepository.deleteById(id);
    }

    @Override
    public List<Bloc> getAll() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc getById(Long id) {
        return blocRepository.findById(id).orElseThrow(() -> new RuntimeException("Bloc not found"));
    }

    @Override
    public Bloc affecterBlocAFoyer(Long idBloc, Long idFoyer) {
        Bloc bloc = blocRepository.findById(idBloc)
                .orElseThrow(() -> new RuntimeException("Bloc not found"));
        
        Foyer foyer = foyerRepository.findById(idFoyer)
                .orElseThrow(() -> new RuntimeException("Foyer not found"));
        
        bloc.setFoyer(foyer);
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc) {
        Bloc bloc = blocRepository.findById(idBloc)
                .orElseThrow(() -> new RuntimeException("Bloc not found with id: " + idBloc));
        
        List<Chambre> chambres = chambreRepository.findByNumeroChambreIn(numChambre);
        
        if (chambres.isEmpty()) {
            throw new RuntimeException("No chambres found with the provided numbers");
        }
        
        for (Chambre chambre : chambres) {
            chambre.setBloc(bloc);
        }
        
        chambreRepository.saveAll(chambres);
        return blocRepository.findById(idBloc).orElse(bloc);
    }
}
