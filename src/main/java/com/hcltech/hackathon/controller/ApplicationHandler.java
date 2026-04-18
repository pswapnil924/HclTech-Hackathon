package com.hcltech.hackathon.controller;

import com.hcltech.hackathon.dto.ApplicationResponseDto;
import com.hcltech.hackathon.service.ApplicationHandlerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/application")
public class ApplicationHandler {

    private final ApplicationHandlerService applicationHandlerService;

    public ApplicationHandler(ApplicationHandlerService applicationHandlerService) {
        this.applicationHandlerService = applicationHandlerService;
    }


    @GetMapping("/{applicationId}")
    public ApplicationResponseDto handleApplication(@PathVariable String applicationId ){
        return  applicationHandlerService.handleApplication(applicationId);
    }
}
