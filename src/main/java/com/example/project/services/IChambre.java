package com.example.project.services;

import com.example.project.Entities.Chambre;
import java.util.List;

public interface IChambre {
    Chambre create(Chambre chambre);
    Chambre update(Long id, Chambre chambre);
    void delete(Long id);
    List<Chambre> getAll();
    Chambre getById(Long id);
}
