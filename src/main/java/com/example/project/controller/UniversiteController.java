package com.example.project.controller;

import com.example.project.Entities.Universite;
import com.example.project.services.IUniversite;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/universite")
public class UniversiteController {
    private final IUniversite iuniversite;

    @PostMapping("/create")
    public Universite create(@RequestBody Universite universite) {
        return iuniversite.create(universite);
    }

     @PutMapping("/update/{id}")
     public Universite update(@PathVariable Long id, @RequestBody Universite universite) {
         return iuniversite.update(id, universite);
     }
    
     @DeleteMapping("/delete/{id}")
     public void delete(@PathVariable Long id) {
         iuniversite.delete(id);
     }

     @GetMapping("/getById/{id}")
     public Universite getById(@PathVariable Long id) {
         return iuniversite.getById(id);
     }

     @GetMapping("/getAll")
     public List<Universite> getAll() {
         return iuniversite.getAll();
     }
}
