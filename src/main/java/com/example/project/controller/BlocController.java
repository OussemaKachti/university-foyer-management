package com.example.project.controller;

import com.example.project.Entities.Bloc;
import com.example.project.services.IBloc;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/bloc")
public class BlocController {
    private final IBloc ibloc;

    @PostMapping("/create")
    public Bloc create(@RequestBody Bloc bloc) {
        return ibloc.create(bloc);
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
