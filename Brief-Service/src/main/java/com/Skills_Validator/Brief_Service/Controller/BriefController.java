package com.Skills_Validator.Brief_Service.Controller;
import com.Skills_Validator.Brief_Service.Entities.Brief;
import com.Skills_Validator.Brief_Service.Services.BriefService;
import org.springframework.web.bind.annotation.*;
import java.util.List;


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

    @PutMapping("/{id}/competences")
    public Brief assignCompetences(@PathVariable Long id, @RequestBody List<Long> competenceIds) {
        return briefService.assignCompetences(id, competenceIds);
    }
}
