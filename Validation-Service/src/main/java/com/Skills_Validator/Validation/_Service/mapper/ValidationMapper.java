package com.Skills_Validator.Validation._Service.mapper;


import com.Skills_Validator.Validation._Service.dto.ValidationDTO;
import com.Skills_Validator.Validation._Service.model.StatutValidation;
import com.Skills_Validator.Validation._Service.model.Validation;

public class ValidationMapper {
    public static ValidationDTO toDTO(Validation validation) {
        if (validation == null) return null;
        ValidationDTO dto = new ValidationDTO();
        dto.setId(validation.getId());
        dto.setApprenantId(validation.getApprenantId());
        dto.setBriefId(validation.getBriefId());
        dto.setCompetenceId(validation.getCompetenceId());
        dto.setValidateurId(validation.getValidateurId());
        dto.setDateValidation(validation.getDateValidation());
        dto.setStatut(validation.getStatut() != null ? validation.getStatut().name() : null);
        return dto;
    }

    public static Validation toEntity(ValidationDTO dto) {
        if (dto == null) return null;
        Validation validation = new Validation();
        validation.setId(dto.getId());
        validation.setApprenantId(dto.getApprenantId());
        validation.setBriefId(dto.getBriefId());
        validation.setCompetenceId(dto.getCompetenceId());
        validation.setValidateurId(dto.getValidateurId());
        validation.setDateValidation(dto.getDateValidation());
        if (dto.getStatut() != null) {
            validation.setStatut(StatutValidation.valueOf(dto.getStatut()));
        }
        return validation;
    }
} 