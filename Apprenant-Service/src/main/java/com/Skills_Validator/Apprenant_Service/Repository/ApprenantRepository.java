package com.Skills_Validator.Apprenant_Service.Repository;


import com.Skills_Validator.Apprenant_Service.model.Apprenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
    public interface ApprenantRepository extends JpaRepository<Apprenant, Long> {
        Optional<Apprenant> findByEmail(String email);
        boolean existsByEmail(String email);

        @Query("SELECT a FROM Apprenant a WHERE a.nom LIKE %:nom% OR a.prenom LIKE %:nom%")
        List<Apprenant> findByNomOrPrenomContaining(@Param("nom") String nom);
    }

