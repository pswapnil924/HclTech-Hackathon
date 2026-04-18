package com.hcltech.hackathon.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PinUpdateRequest {
    @NotBlank @Size(min = 16, max = 16)
    private String cardNumber;

    @NotBlank @Size(min = 4, max = 4)
    private String firstTimePin;

    @NotBlank
    private String documentId;

    @NotBlank @Size(min = 4, max = 4)
    private String newPin;

    @NotBlank
    private String confirmNewPin;
}