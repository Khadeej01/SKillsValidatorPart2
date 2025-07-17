package com.Skills_Validator.Validation._Service.service;

import static org.junit.jupiter.api.Assertions.*;
import com.Skills_Validator.Validation._Service.model.StatutValidation;
import com.Skills_Validator.Validation._Service.model.Validation;
import com.Skills_Validator.Validation._Service.repository.ValidationRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.time.LocalDateTime;
import java.util.Optional;



@DataJpaTest
@Import(ValidationService.class)
public class ValidationServiceTest {

    @Autowired
    private ValidationRepository validationRepository;

    @Autowired
    private ValidationService validationService;

    private Validation validation;

    @BeforeEach
    void setUp() {
        validation = new Validation(
                1L, 2L, 3L, 4L,
                LocalDateTime.now(),
                StatutValidation.VALIDE
        );
    }

    @Test
    void testCreateValidation() {
        Validation saved = validationService.createValidation(validation);
        assertNotNull(saved.getId());
        assertEquals(validation.getApprenantId(), saved.getApprenantId());
    }

    @Test
    void testGetValidationById() {
        Validation saved = validationService.createValidation(validation);
        Optional<Validation> found = validationService.getValidationById(saved.getId());
        assertTrue(found.isPresent());
        assertEquals(saved.getId(), found.get().getId());
    }

    @Test
    void testGetAllValidations() {
        validationService.createValidation(validation);
        assertFalse(validationService.getAllValidations().isEmpty());
    }

    @Test
    void testUpdateValidation() {
        Validation saved = validationService.createValidation(validation);
        saved.setStatut(StatutValidation.NON_VALIDE);
        Validation updated = validationService.updateValidation(saved.getId(), saved);
        assertEquals(StatutValidation.NON_VALIDE, updated.getStatut());
    }

    @Test
    void testDeleteValidation() {
        Validation saved = validationService.createValidation(validation);
        validationService.deleteValidation(saved.getId());
        assertTrue(validationService.getValidationById(saved.getId()).isEmpty());
    }
}