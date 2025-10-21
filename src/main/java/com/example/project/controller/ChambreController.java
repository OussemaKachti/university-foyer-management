package com.example.project.controller;

import com.example.project.Entities.Chambre;
import com.example.project.services.IChambre;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/chambre")
public class ChambreController {
    private final IChambre ichambre;

    @PostMapping("/create")
    public Chambre create(@RequestBody Chambre chambre) {
        return ichambre.create(chambre);
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
}
