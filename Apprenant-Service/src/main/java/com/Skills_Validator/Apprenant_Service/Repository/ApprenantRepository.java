package com.Skills_Validator.Apprenant_Service.Repository;

import com.Skills_Validator.Apprenant_Service.model.Apprenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface ApprenantRepository extends JpaRepository<Apprenant, Long> {

}

