package com.example.project.services;

import com.example.project.DTO.ProjectDetailsDTO;
import com.example.project.Entities.ProjetDetail;
import com.example.project.mapper.ProjetDetailMapper;
import com.example.project.repository.ProjetDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DTOService {

    private final ProjetDetailRepository projetDetailRepository;
    private final ProjetDetailMapper projetDetailMapper;

    public ProjectDetailsDTO getDetailsProjet(Long id) {
        ProjetDetail detail = projetDetailRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Détails du projet non trouvés"));

        // Conversion automatique avec MapStruct
        return projetDetailMapper.toDto(detail);
    }
}
