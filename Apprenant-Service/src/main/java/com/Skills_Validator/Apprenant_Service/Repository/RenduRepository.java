package com.Skills_Validator.Apprenant_Service.Repository;

import com.Skills_Validator.Apprenant_Service.model.Rendu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RenduRepository extends JpaRepository<Rendu, Long> {
    List<Rendu> findByApprenantId(Long apprenantId);
    List<Rendu> findByBriefId(Long briefId);
    List<Rendu> findByApprenantIdAndBriefId(Long apprenantId, Long briefId);

    @Query("SELECT r FROM Rendu r WHERE r.apprenant.id = :apprenantId ORDER BY r.dateSoumission DESC")
    List<Rendu> findByApprenantIdOrderByDateSoumissionDesc(@Param("apprenantId") Long apprenantId);
}
