package com.example.project.controller;

import com.example.project.Entities.Foyer;
import com.example.project.services.IFoyer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/foyer")
public class FoyerController {
    private final IFoyer ifoyer;

    @PostMapping("/create")
    public Foyer create(@RequestBody Foyer foyer) {
        return ifoyer.create(foyer);
    }

     @PutMapping("/update/{id}")
     public Foyer update(@PathVariable Long id, @RequestBody Foyer foyer) {
         return ifoyer.update(id, foyer);
     }
    
     @DeleteMapping("/delete/{id}")
     public void delete(@PathVariable Long id) {
         ifoyer.delete(id);
     }

     @GetMapping("/getById/{id}")
     public Foyer getById(@PathVariable Long id) {
         return ifoyer.getById(id);
     }

     @GetMapping("/getAll")
     public List<Foyer> getAll() {
         return ifoyer.getAll();
     }
}
