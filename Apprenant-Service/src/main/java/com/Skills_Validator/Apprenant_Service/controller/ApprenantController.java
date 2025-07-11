package com.Skills_Validator.Apprenant_Service.controller;
import com.Skills_Validator.Apprenant_Service.dto.ApprenantDTO;
import com.Skills_Validator.Apprenant_Service.dto.RenduDto;
import com.Skills_Validator.Apprenant_Service.service.ApprenantService;
import com.Skills_Validator.Apprenant_Service.Repository.RenduRepository;
import com.Skills_Validator.Apprenant_Service.mapper.RenduMapper;
import com.Skills_Validator.Apprenant_Service.model.Rendu;
import com.Skills_Validator.Apprenant_Service.model.Apprenant;
import com.Skills_Validator.Apprenant_Service.mapper.ApprenantMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.List;

@RestController
@RequestMapping("/apprenants")
public class ApprenantController {

    @Autowired
    private ApprenantService apprenantService;

    @Autowired
    private RenduRepository renduRepository;

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

    // Dépôt d'un rendu pour un apprenant
    @PostMapping("/{id}/rendus")
    public ResponseEntity<RenduDto> deposerRendu(@PathVariable Long id, @RequestBody RenduDto renduDto) {
        ApprenantDTO apprenantDTO = apprenantService.getApprenantById(id);
        if (apprenantDTO == null) return ResponseEntity.notFound().build();
        Rendu rendu = RenduMapper.toEntity(renduDto);
        Apprenant apprenant = new Apprenant();
        apprenant.setId(id);
        rendu.setApprenant(apprenant);
        rendu.setDatedepot(new java.util.Date());
        Rendu saved = renduRepository.save(rendu);
        return new ResponseEntity<>(RenduMapper.toDto(saved), HttpStatus.CREATED);
    }

    // Consultation des rendus d'un apprenant
    @GetMapping("/{id}/rendus")
    public ResponseEntity<List<RenduDto>> getRendusByApprenant(@PathVariable Long id) {
        List<Rendu> rendus = renduRepository.findByApprenantId(id);
        List<RenduDto> dtos = rendus.stream().map(RenduMapper::toDto).toList();
        return ResponseEntity.ok(dtos);
    }
}
