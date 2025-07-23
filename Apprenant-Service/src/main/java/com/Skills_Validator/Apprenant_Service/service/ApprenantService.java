package com.Skills_Validator.Apprenant_Service.service;

import com.Skills_Validator.Apprenant_Service.Repository.ApprenantRepository;
import com.Skills_Validator.Apprenant_Service.dto.ApprenantDTO;
import com.Skills_Validator.Apprenant_Service.mapper.ApprenantMapper;
import com.Skills_Validator.Apprenant_Service.model.Apprenant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ApprenantService {

    @Autowired
    ApprenantRepository apprenantRepository;

    public ApprenantDTO inscrire(ApprenantDTO dto) {
        try {
            Apprenant apprenant = ApprenantMapper.toEntity(dto);
            apprenant = apprenantRepository.save(apprenant);
            return ApprenantMapper.toDto(apprenant);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erreur lors de l'inscription de l'apprenant: " + e.getMessage(), e);
        }
    }

    public ApprenantDTO getApprenantById(Long id) {
        return apprenantRepository.findById(id)
                .map(ApprenantMapper::toDto)
                .orElse(null);
    }

    public List<ApprenantDTO> getAllApprenants() {
        return apprenantRepository.findAll().stream()
                .map(ApprenantMapper::toDto)
                .collect(Collectors.toList());
    }

    public ApprenantDTO updateApprenant(Long id, ApprenantDTO dto) {
        Optional<Apprenant> optional = apprenantRepository.findById(id);
        if (optional.isPresent()) {
            Apprenant apprenant = optional.get();
            apprenant.setNom(dto.getNom());
            apprenant.setPrenom(dto.getPrenom());
            apprenant.setEmail(dto.getEmail());
            apprenant.setMotPasse(dto.getMotDePasse());
            return ApprenantMapper.toDto(apprenantRepository.save(apprenant));
        }
        return null;
    }

    public void deleteApprenant(Long id) {
        apprenantRepository.deleteById(id);
    }
}