package com.Skills_Validator.Validation._Service.service;


import com.Skills_Validator.Validation._Service.model.Validation;
import com.Skills_Validator.Validation._Service.repository.ValidationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ValidationService {
    private final ValidationRepository validationRepository;

    @Autowired
    public ValidationService(ValidationRepository validationRepository) {
        this.validationRepository = validationRepository;
    }

    public Validation createValidation(Validation validation) {
        return validationRepository.save(validation);
    }

    public Optional<Validation> getValidationById(Long id) {
        return validationRepository.findById(id);
    }

    public List<Validation> getAllValidations() {
        return validationRepository.findAll();
    }

    public Validation updateValidation(Long id, Validation updatedValidation) {
        return validationRepository.findById(id)
                .map(existing -> {
                    existing.setApprenantId(updatedValidation.getApprenantId());
                    existing.setBriefId(updatedValidation.getBriefId());
                    existing.setCompetenceId(updatedValidation.getCompetenceId());
                    existing.setValidateurId(updatedValidation.getValidateurId());
                    existing.setDateValidation(updatedValidation.getDateValidation());
                    existing.setStatut(updatedValidation.getStatut());
                    return validationRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Validation not found with id: " + id));
    }

    public void deleteValidation(Long id) {
        validationRepository.deleteById(id);
    }

    public List<Validation> getValidationsByApprenant(Long apprenantId) {
        return validationRepository.findAll().stream()
            .filter(v -> v.getApprenantId().equals(apprenantId))
            .collect(Collectors.toList());
    }

    public Map<Long, Long> getEtatGlobalParApprenant() {
        return validationRepository.findAll().stream()
            .filter(v -> v.getStatut() != null && v.getStatut().name().equals("VALIDE"))
            .collect(Collectors.groupingBy(
                Validation::getApprenantId,
                Collectors.counting()
            ));
    }
} 