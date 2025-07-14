package org.skillsvalidator.skillsvalidator.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.skillsvalidator.skillsvalidator.dto.CompetenceDTO;
import org.skillsvalidator.skillsvalidator.dto.SousCompetenceDTO;
import org.skillsvalidator.skillsvalidator.model.Competence;
import org.skillsvalidator.skillsvalidator.model.SousCompetence;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-10T17:06:09+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class CompetenceMapperImpl implements CompetenceMapper {

    @Override
    public CompetenceDTO toDto(Competence competence) {
        if ( competence == null ) {
            return null;
        }

        CompetenceDTO competenceDTO = new CompetenceDTO();

        competenceDTO.setId( competence.getId() );
        competenceDTO.setName( competence.getName() );
        competenceDTO.setValidated( competence.isValidated() );
        competenceDTO.setSousCompetences( toSousCompetenceDtoList( competence.getSousCompetences() ) );

        return competenceDTO;
    }

    @Override
    public Competence toEntity(CompetenceDTO competenceDTO) {
        if ( competenceDTO == null ) {
            return null;
        }

        Competence competence = new Competence();

        competence.setId( competenceDTO.getId() );
        competence.setName( competenceDTO.getName() );
        competence.setValidated( competenceDTO.isValidated() );
        competence.setSousCompetences( toSousCompetenceEntityList( competenceDTO.getSousCompetences() ) );

        return competence;
    }

    @Override
    public List<CompetenceDTO> toDtoList(List<Competence> competences) {
        if ( competences == null ) {
            return null;
        }

        List<CompetenceDTO> list = new ArrayList<CompetenceDTO>( competences.size() );
        for ( Competence competence : competences ) {
            list.add( toDto( competence ) );
        }

        return list;
    }

    @Override
    public List<Competence> toEntityList(List<CompetenceDTO> competenceDTOs) {
        if ( competenceDTOs == null ) {
            return null;
        }

        List<Competence> list = new ArrayList<Competence>( competenceDTOs.size() );
        for ( CompetenceDTO competenceDTO : competenceDTOs ) {
            list.add( toEntity( competenceDTO ) );
        }

        return list;
    }

    @Override
    public SousCompetenceDTO toSousCompetenceDto(SousCompetence sousCompetence) {
        if ( sousCompetence == null ) {
            return null;
        }

        SousCompetenceDTO sousCompetenceDTO = new SousCompetenceDTO();

        sousCompetenceDTO.setId( sousCompetence.getId() );
        sousCompetenceDTO.setName( sousCompetence.getName() );
        sousCompetenceDTO.setValidated( sousCompetence.isValidated() );

        return sousCompetenceDTO;
    }

    @Override
    public SousCompetence toSousCompetenceEntity(SousCompetenceDTO sousCompetenceDTO) {
        if ( sousCompetenceDTO == null ) {
            return null;
        }

        SousCompetence sousCompetence = new SousCompetence();

        sousCompetence.setId( sousCompetenceDTO.getId() );
        sousCompetence.setName( sousCompetenceDTO.getName() );
        sousCompetence.setValidated( sousCompetenceDTO.isValidated() );

        return sousCompetence;
    }

    @Override
    public List<SousCompetenceDTO> toSousCompetenceDtoList(List<SousCompetence> sousCompetences) {
        if ( sousCompetences == null ) {
            return null;
        }

        List<SousCompetenceDTO> list = new ArrayList<SousCompetenceDTO>( sousCompetences.size() );
        for ( SousCompetence sousCompetence : sousCompetences ) {
            list.add( toSousCompetenceDto( sousCompetence ) );
        }

        return list;
    }

    @Override
    public List<SousCompetence> toSousCompetenceEntityList(List<SousCompetenceDTO> sousCompetenceDTOs) {
        if ( sousCompetenceDTOs == null ) {
            return null;
        }

        List<SousCompetence> list = new ArrayList<SousCompetence>( sousCompetenceDTOs.size() );
        for ( SousCompetenceDTO sousCompetenceDTO : sousCompetenceDTOs ) {
            list.add( toSousCompetenceEntity( sousCompetenceDTO ) );
        }

        return list;
    }
}
