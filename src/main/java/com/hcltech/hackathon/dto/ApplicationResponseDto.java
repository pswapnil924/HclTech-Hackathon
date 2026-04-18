package com.hcltech.hackathon.dto;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationResponseDto {

    private String cartType;
    private String cardNumber;
    private Integer pin;
    private Integer limit;

    private String message;

}
