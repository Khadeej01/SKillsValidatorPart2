package com.Skills_Validator.Apprenant_Service.mapper;
import com.Skills_Validator.Apprenant_Service.dto.RenduDto;
import com.Skills_Validator.Apprenant_Service.model.Rendu;


public class RenduMapper {

    public static Rendu toEntity(RenduDto dto) {
        if (dto == null) return null;
        Rendu rendu = new Rendu();
        rendu.setId(dto.getId());
        rendu.setMessage(dto.getMessage());
        rendu.setDatedepot(dto.getDatedepot());
        rendu.setStatutRendu(dto.getStatutRendu());
        rendu.setLien(dto.getLien());
        return rendu;
    }

    public static RenduDto toDto(Rendu entity) {
        if (entity == null) return null;
        RenduDto dto = new RenduDto();
        dto.setId(entity.getId());
        dto.setMessage(entity.getMessage());
        dto.setDatedepot(entity.getDatedepot());
        dto.setStatutRendu(entity.getStatutRendu());
        dto.setLien(entity.getLien());
        if (entity.getApprenant() != null) {
            dto.setApprenantId(entity.getApprenant().getId());
        }
        return dto;
    }
}
