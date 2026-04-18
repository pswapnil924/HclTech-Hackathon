package com.hcltech.hackathon.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
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
