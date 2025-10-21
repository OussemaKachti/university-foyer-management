package com.example.project.services;

import com.example.project.Entities.Bloc;
import java.util.List;

public interface IBloc {
    Bloc create(Bloc bloc);
    Bloc update(Long id, Bloc bloc);
    void delete(Long id);
    List<Bloc> getAll();
    Bloc getById(Long id);
}
