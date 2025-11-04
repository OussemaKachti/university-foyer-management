package com.example.project.services;

import com.example.project.Entities.Universite;
import java.util.List;

public interface IUniversite {
    Universite create(Universite universite);
    Universite update(Long id, Universite universite);
    void delete(Long id);
    List<Universite> getAll();
    Universite getById(Long id);
}
