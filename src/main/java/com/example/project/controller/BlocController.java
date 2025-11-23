package com.example.project.controller;

import com.example.project.DTO.BlocDTO;
import com.example.project.Entities.Bloc;
import com.example.project.mapper.BlocMapper;
import com.example.project.services.IBloc;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/bloc")
public class BlocController {
    private final IBloc ibloc;
    private final BlocMapper blocMapper;

    @PostMapping("/create")
    public BlocDTO create(@RequestBody BlocDTO blocDTO) {
        Bloc bloc = blocMapper.toEntity(blocDTO);
        Bloc createdBloc = ibloc.create(bloc);
        return blocMapper.toDto(createdBloc);
    }

    @PostMapping("/{idBloc}/affecterFoyer/{idFoyer}")
    public Bloc affecterBlocAFoyer(
            @PathVariable Long idBloc,
            @PathVariable Long idFoyer) {
        return ibloc.affecterBlocAFoyer(idBloc, idFoyer);
    }

    @PostMapping("/{idBloc}/affecterChambres")
    public Bloc affecterChambresABloc(
            @PathVariable long idBloc,
            @RequestBody List<Long> numChambre) {
        return ibloc.affecterChambresABloc(numChambre, idBloc);
    }

     @PutMapping("/update/{id}")
     public Bloc update(@PathVariable Long id, @RequestBody Bloc bloc) {

        return ibloc.update(id, bloc);
     }
    
     @DeleteMapping("/delete/{id}")
     public void delete(@PathVariable Long id) {
         ibloc.delete(id);
     }

     @GetMapping("/getById/{id}")
     public Bloc getById(@PathVariable Long id) {
         return ibloc.getById(id);
     }

     @GetMapping("/getAll")
     public List<Bloc> getAll() {
         return ibloc.getAll();
     }
}
