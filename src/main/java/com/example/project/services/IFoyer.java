package com.example.project.services;

import com.example.project.Entities.Foyer;
import java.util.List;

public interface IFoyer {
    Foyer create(Foyer foyer);
    Foyer update(Long id, Foyer foyer);
    void delete(Long id);
    List<Foyer> getAll();
    Foyer getById(Long id);
}
