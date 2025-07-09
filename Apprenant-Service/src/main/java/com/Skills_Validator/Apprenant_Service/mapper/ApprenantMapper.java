package com.Skills_Validator.Apprenant_Service.mapper;

import com.Skills_Validator.Apprenant_Service.dto.ApprenantDTO;
import com.Skills_Validator.Apprenant_Service.dto.RenduDto;
import com.Skills_Validator.Apprenant_Service.model.Apprenant;
import com.Skills_Validator.Apprenant_Service.model.Rendu;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ApprenantMapper {

    public static Apprenant toEntity(ApprenantDTO dto) {
        Apprenant apprenant = new Apprenant();
        apprenant.setId(dto.getId());
        apprenant.setNom(dto.getNom());
        apprenant.setPrenom(dto.getPrenom());
        apprenant.setEmail(dto.getEmail());
        apprenant.setMotPasse(dto.getMotDePasse());
        apprenant.setDateInscription(dto.getDateInscription().toLocalDate());
        if(dto.getRendus() != null) {
            List<Rendu> rendus = dto.getRendus()
                    .stream()
                    .map(RenduMapper::toEntity)
                    .collect(Collectors.toList());
            apprenant.setRendus(rendus);
        }
        return apprenant;
    }
    public static ApprenantDTO toDto(Apprenant entity) {
        ApprenantDTO dto = new ApprenantDTO();
        dto.setId(entity.getId());
        dto.setNom(entity.getNom());
        dto.setPrenom(entity.getPrenom());
        dto.setEmail(entity.getEmail());
        dto.setMotDePasse(entity.getMotPasse());
        dto.setDateInscription(entity.getDateInscription().atStartOfDay());

        if(entity.getRendus() != null) {
            List<RenduDto> rendusDto = entity.getRendus()
                    .stream()
                    .map(RenduMapper::toDto)
                    .collect(Collectors.toList());
            dto.setRendus(rendusDto);
        }

        return dto;
    }

}
