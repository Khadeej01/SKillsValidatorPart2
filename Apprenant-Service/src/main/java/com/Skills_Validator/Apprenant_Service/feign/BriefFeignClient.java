package com.Skills_Validator.Apprenant_Service.feign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;


@FeignClient(name = "briefService" ,url = "http://localhost:8080")
public interface BriefFeignClient {


    @GetMapping("/Briefs/{id}")
    ResponseEntity<Map<String, Object>> getBriefsById(@PathVariable("id") Long id);


}