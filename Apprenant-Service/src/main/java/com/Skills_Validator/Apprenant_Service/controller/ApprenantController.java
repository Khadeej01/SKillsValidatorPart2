package com.Skills_Validator.Apprenant_Service.controller;
import com.Skills_Validator.Apprenant_Service.dto.ApprenantDTO;
import com.Skills_Validator.Apprenant_Service.service.ApprenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apprenants")
public class ApprenantController {

    @Autowired
    private ApprenantService apprenantService;

    @PostMapping("/inscription")
    public ResponseEntity<ApprenantDTO> inscrire(@RequestBody ApprenantDTO dto) {
        return ResponseEntity.ok(apprenantService.inscrire(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApprenantDTO> getById(@PathVariable Long id) {
        ApprenantDTO dto = apprenantService.getApprenantById(id);
        if (dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public List<ApprenantDTO> getAll() {
        return apprenantService.getAllApprenants();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApprenantDTO> update(@PathVariable Long id, @RequestBody ApprenantDTO dto) {
        ApprenantDTO updated = apprenantService.updateApprenant(id, dto);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        apprenantService.deleteApprenant(id);
        return ResponseEntity.noContent().build();
    }
}
