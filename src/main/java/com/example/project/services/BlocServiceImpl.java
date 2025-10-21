package com.example.project.services;

import com.example.project.Entities.Bloc;
import com.example.project.repository.BlocRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlocServiceImpl implements IBloc {

    private final BlocRepository blocRepository;

    public BlocServiceImpl(BlocRepository blocRepository) {
        this.blocRepository = blocRepository;
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
}
