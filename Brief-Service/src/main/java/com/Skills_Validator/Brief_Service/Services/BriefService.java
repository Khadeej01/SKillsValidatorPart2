package com.Skills_Validator.Brief_Service.Services;
import com.Skills_Validator.Brief_Service.Entities.Brief;
import com.Skills_Validator.Brief_Service.Repositories.BriefRepositorie;
import org.springframework.stereotype.Service;


@Service
public class BriefService {
    private final BriefRepositorie briefRepositorie;

    public BriefService(BriefRepositorie briefRepositorie) {
        this.briefRepositorie = briefRepositorie;
    }


    public Brief create(Brief brief){
        return briefRepositorie.save(brief);
    }
}
