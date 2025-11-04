package com.example.project.controller;

import com.example.project.Entities.Etudiant;
import com.example.project.services.IEtudiant;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/etudiant")
public class EtudiantController {
    private final IEtudiant ietudiant;

    @PostMapping("/create")
    public Etudiant create(@RequestBody Etudiant etudiant) {
        return ietudiant.create(etudiant);
    }

     @PutMapping("/update/{id}")
     public Etudiant update(@PathVariable Long id, @RequestBody Etudiant etudiant) {
         return ietudiant.update(id, etudiant);
     }
    
     @DeleteMapping("/delete/{id}")
     public void delete(@PathVariable Long id) {
         ietudiant.delete(id);
     }

     @GetMapping("/getById/{id}")
     public Etudiant getById(@PathVariable Long id) {
         return ietudiant.getById(id);
     }

     @GetMapping("/getAll")
     public List<Etudiant> getAll() {
         return ietudiant.getAll();
     }
}
