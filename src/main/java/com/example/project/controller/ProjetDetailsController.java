package com.example.project.controller;

import com.example.project.DTO.ProjectDetailsDTO;
import com.example.project.services.DTOService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/projet")
public class ProjetDetailsController {
    
    private final DTOService projetDetailService;

    @GetMapping("/{id}/details")
    public ProjectDetailsDTO getDetails(@PathVariable Long id) {
        return projetDetailService.getDetailsProjet(id);
    }
}
