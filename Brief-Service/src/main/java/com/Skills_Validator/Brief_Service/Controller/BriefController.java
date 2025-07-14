package com.Skills_Validator.Brief_Service.Controller;
import com.Skills_Validator.Brief_Service.Entities.Brief;
import com.Skills_Validator.Brief_Service.Services.BriefService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/briefs")
public class BriefController {

    private final BriefService briefService;

    public BriefController(BriefService briefService) {
        this.briefService = briefService;
    }

    @PostMapping
    public Brief create(@RequestBody Brief brief){
        return briefService.create(brief);
    }

    @GetMapping("/{id}")
    public Optional<Brief> getById(@PathVariable Long id) {
        return briefService.getById(id);
    }

    @GetMapping
    public List<Brief> getAll(){
        return briefService.getAll();
    }

    @PutMapping("/{id}/competences")
    public Brief assignCompetences(@PathVariable Long id, @RequestBody List<Long> competenceIds) {
        return briefService.assignCompetences(id, competenceIds);
    }
}
