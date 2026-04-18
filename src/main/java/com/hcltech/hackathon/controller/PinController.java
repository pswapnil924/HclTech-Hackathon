package com.hcltech.hackathon.controller;

import com.hcltech.hackathon.entity.PinUpdateRequest;
import com.hcltech.hackathon.service.PinService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cards")
public class PinController {
    @Autowired
    private PinService pinService;

    @PostMapping("/first-time-pin")
    public ResponseEntity<String> changeDefaultPin(@Valid @RequestBody PinUpdateRequest request) {
        String response = pinService.updateFirstTimePin(request);
        return ResponseEntity.ok(response);
    }
}