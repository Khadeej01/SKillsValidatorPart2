package com.Skills_Validator.Apprenant_Service.mapper;


import com.Skills_Validator.Apprenant_Service.dto.ApprenantDTO;
import com.Skills_Validator.Apprenant_Service.model.Apprenant;
import org.springframework.stereotype.Component;

@Component
    public class ApprenantMapper {
        public static Apprenant toEntity(ApprenantDTO dto) {
            return new Apprenant(dto.getNom(), dto.getPrenom(), dto.getEmail(), dto.getMotDePasse());
        }

        public static ApprenantDTO toDto(Apprenant entity) {
            return new ApprenantDTO(entity.getNom(), entity.getPrenom(), entity.getEmail(), entity.getMotDePasse());
        }
    }

