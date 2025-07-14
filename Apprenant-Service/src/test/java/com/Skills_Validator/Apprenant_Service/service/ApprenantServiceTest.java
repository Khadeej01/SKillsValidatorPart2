package com.Skills_Validator.Apprenant_Service.service;

import com.Skills_Validator.Apprenant_Service.Repository.ApprenantRepository;
import com.Skills_Validator.Apprenant_Service.dto.ApprenantDTO;
import com.Skills_Validator.Apprenant_Service.model.Apprenant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class ApprenantServiceTest {

   @Autowired
   private ApprenantService apprenantService;
   @Autowired
   private ApprenantRepository apprenantRepository;

   @Test
   void testInscrire_shouldSaveAndReturnApprenantDTO() {
      // Préparation du DTO
      ApprenantDTO dto = new ApprenantDTO();
      dto.setNom("Fatima");
      dto.setPrenom("Zahra");
      dto.setEmail("fatima@test.com");
      dto.setMotDePasse("motdepasse");

      // Appel de la méthode à tester
      ApprenantDTO result = apprenantService.inscrire(dto);

      // Vérifications
      assertNotNull(result);
      assertNotNull(result.getId());
      assertEquals("fatima@test.com", result.getEmail());

      // Vérification dans la base H2
      Apprenant saved = apprenantRepository.findById(result.getId()).orElse(null);
      assertNotNull(saved);
      assertEquals("Fatima", saved.getNom());
   }



   @Test
   void testGetApprenantById_shouldReturnNull_WhenNotFound() {
      // Act
      ApprenantDTO dto = apprenantService.getApprenantById(999L);

      // Assert
      assertNull(dto);
   }


}
