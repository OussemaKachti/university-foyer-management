package com.example.project.services;

import com.example.project.Entities.Chambre;
import com.example.project.Entities.TypeChambre;
import java.util.List;

public interface IChambre {
    Chambre create(Chambre chambre);
    Chambre update(Long id, Chambre chambre);
    void delete(Long id);
    List<Chambre> getAll();
    Chambre getById(Long id);
    Chambre affecterChambreABloc(Long idChambre, Long idBloc);
    List<Chambre> getChambresParNomUniversite(String nomUniversite);
    List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre typeC);
    List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(String nomUniversite, TypeChambre type);
}
