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
   @Test
   void testUpdateApprenant_shouldUpdateAndReturnUpdatedDTO() {
      // Créer et sauvegarder un apprenant de base
      Apprenant apprenant = new Apprenant();
      apprenant.setNom("OldName");
      apprenant.setPrenom("OldPrenom");
      apprenant.setEmail("old@example.com");
      apprenant.setMotPasse("oldpass");
      apprenant.setDateInscription(LocalDate.now()); // Important
      Apprenant saved = apprenantRepository.save(apprenant);

      // Créer le nouveau DTO avec les données à mettre à jour
      ApprenantDTO updatedDTO = new ApprenantDTO();
      updatedDTO.setNom("NewName");
      updatedDTO.setPrenom("NewPrenom");
      updatedDTO.setEmail("new@example.com");
      updatedDTO.setMotDePasse("newpass");

      // Appeler la méthode à tester
      ApprenantDTO result = apprenantService.updateApprenant(saved.getId(), updatedDTO);

      // Vérification
      assertNotNull(result);
      assertEquals("NewName", result.getNom());
      assertEquals("new@example.com", result.getEmail());

      // Confirmer en base
      Apprenant updated = apprenantRepository.findById(saved.getId()).orElse(null);
      assertNotNull(updated);
      assertEquals("NewName", updated.getNom());
   }
   @Test
   void testDeleteApprenant_shouldRemoveFromDatabase() {
      // Créer et sauvegarder un apprenant
      Apprenant apprenant = new Apprenant();
      apprenant.setNom("DeleteMe");
      apprenant.setPrenom("Soon");
      apprenant.setEmail("deleteme@test.com");
      apprenant.setMotPasse("delete123");
      apprenant.setDateInscription(LocalDate.now());
      Apprenant saved = apprenantRepository.save(apprenant);

      // Supprimer
      apprenantService.deleteApprenant(saved.getId());

      // Vérifier qu’il n’existe plus
      boolean exists = apprenantRepository.existsById(saved.getId());
      assertFalse(exists);
   }


}
