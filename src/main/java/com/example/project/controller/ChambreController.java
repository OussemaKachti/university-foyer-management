package com.example.project.controller;

import com.example.project.DTO.ChambreDTO;
import com.example.project.Entities.Chambre;
import com.example.project.Entities.TypeChambre;
import com.example.project.mapper.ChambreMapper;
import com.example.project.services.IChambre;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/chambre")
public class ChambreController {
    private final IChambre ichambre;
    private final ChambreMapper chambreMapper;

    @PostMapping("/create")
    public ChambreDTO create(@RequestBody ChambreDTO chambreDTO) {
        Chambre chambre = chambreMapper.toEntity(chambreDTO);
        Chambre createdChambre = ichambre.create(chambre);
        return chambreMapper.toDto(createdChambre);
    }

    @PostMapping("/{idChambre}/affecterBloc/{idBloc}")
    public Chambre affecterChambreABloc(
            @PathVariable Long idChambre,
            @PathVariable Long idBloc) {
        return ichambre.affecterChambreABloc(idChambre, idBloc);
    }

     @PutMapping("/update/{id}")
     public Chambre update(@PathVariable Long id, @RequestBody Chambre chambre) {
         return ichambre.update(id, chambre);
     }
    
     @DeleteMapping("/delete/{id}")
     public void delete(@PathVariable Long id) {
         ichambre.delete(id);
     }

     @GetMapping("/getById/{id}")
     public Chambre getById(@PathVariable Long id) {
         return ichambre.getById(id);
     }

    @GetMapping("/getAll")
    public List<Chambre> getAll() {
        return ichambre.getAll();
    }

    @GetMapping("/parUniversite")
    public List<Chambre> getChambresParNomUniversite(@RequestParam String nomUniversite) {
        return ichambre.getChambresParNomUniversite(nomUniversite);
    }

    @GetMapping("/parBlocEtType")
    public List<Chambre> getChambresParBlocEtType(
            @RequestParam long idBloc,
            @RequestParam TypeChambre typeC) {
        return ichambre.getChambresParBlocEtType(idBloc, typeC);
    }

    @GetMapping("/nonReservees")
    public List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(
            @RequestParam String nomUniversite,
            @RequestParam TypeChambre type) {
        return ichambre.getChambresNonReserveParNomUniversiteEtTypeChambre(nomUniversite, type);
    }
}
