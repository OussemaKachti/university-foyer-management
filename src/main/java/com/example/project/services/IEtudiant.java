package com.example.project.services;

import com.example.project.Entities.Etudiant;
import java.util.List;

public interface IEtudiant {
    Etudiant create(Etudiant etudiant);
    Etudiant update(Long id, Etudiant etudiant);
    void delete(Long id);
    List<Etudiant> getAll();
    Etudiant getById(Long id);
}
