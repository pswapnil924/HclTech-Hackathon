package com.hcltech.hackathon.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "credit_cards_account")
@Data
public class CreditCardAccount {
    @Id
    private String cardNumber;
    private String currentPin;
    private String documentId;
    private boolean isFirstTimeLogin;
    private LocalDateTime lastPinUpdate;
}