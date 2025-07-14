package com.Skills_Validator.Validation._Service.controller;

import com.Skills_Validator.Validation._Service.dto.ValidationDTO;
import com.Skills_Validator.Validation._Service.mapper.ValidationMapper;
import com.Skills_Validator.Validation._Service.model.Validation;
import com.Skills_Validator.Validation._Service.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/validations")
public class ValidationController {
    private final ValidationService validationService;

    @Autowired
    public ValidationController(ValidationService validationService) {
        this.validationService = validationService;
    }

    @PostMapping
    public ResponseEntity<ValidationDTO> createValidation(@RequestBody ValidationDTO validationDTO) {
        Validation created = validationService.createValidation(ValidationMapper.toEntity(validationDTO));
        return ResponseEntity.ok(ValidationMapper.toDTO(created));
    }

    @GetMapping
    public ResponseEntity<List<ValidationDTO>> getAllValidations() {
        List<ValidationDTO> dtos = validationService.getAllValidations().stream()
            .map(ValidationMapper::toDTO)
            .toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ValidationDTO> getValidationById(@PathVariable Long id) {
        return validationService.getValidationById(id)
                .map(ValidationMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ValidationDTO> updateValidation(@PathVariable Long id, @RequestBody ValidationDTO validationDTO) {
        try {
            Validation updated = validationService.updateValidation(id, ValidationMapper.toEntity(validationDTO));
            return ResponseEntity.ok(ValidationMapper.toDTO(updated));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteValidation(@PathVariable Long id) {
        validationService.deleteValidation(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/apprenant/{apprenantId}")
    public ResponseEntity<List<ValidationDTO>> getValidationsByApprenant(@PathVariable Long apprenantId) {
        List<ValidationDTO> dtos = validationService.getValidationsByApprenant(apprenantId).stream()
            .map(com.Skills_Validator.Validation._Service.mapper.ValidationMapper::toDTO)
            .toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/etat-global")
    public ResponseEntity<Map<Long, Long>> getEtatGlobalParApprenant() {
        return ResponseEntity.ok(validationService.getEtatGlobalParApprenant());
    }
} 