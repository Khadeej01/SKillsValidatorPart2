package com.Skills_Validator.Brief_Service.Controller;
import com.Skills_Validator.Brief_Service.Entities.Brief;
import com.Skills_Validator.Brief_Service.Services.BriefService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public class BriefController {

    private final BriefService briefService;

    public BriefController(BriefService briefService) {
        this.briefService = briefService;
    }

    @PostMapping
    public Brief create(@RequestBody Brief brief){
        return briefService.create(brief);
    }
}
