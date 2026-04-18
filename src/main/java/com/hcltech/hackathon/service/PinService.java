package com.hcltech.hackathon.service;

import com.hcltech.hackathon.entity.CreditCardAccount;
import com.hcltech.hackathon.entity.PinUpdateRequest;
import com.hcltech.hackathon.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class PinService {
    @Autowired
    private CreditCardRepository repository;

    @Transactional
    public String updateFirstTimePin(PinUpdateRequest request) {
        // 1. Validate New PIN match
        if (!request.getNewPin().equals(request.getConfirmNewPin())) {
            throw new RuntimeException("New PINs do not match");
        }

        // 2. Find Card and Validate Identity
        CreditCardAccount card = repository.findByCardNumberAndDocumentId(request.getCardNumber(), request.getDocumentId())
                .orElseThrow(() -> new RuntimeException("Invalid Card or Identity Details"));

        // 3. Verify it's actually the first login and the default PIN is correct
        if (!card.isFirstTimeLogin() || !card.getCurrentPin().equals(request.getFirstTimePin())) {
            throw new RuntimeException("Authentication failed or PIN already changed");
        }

        // 4. Update PIN and Audit Info
        card.setCurrentPin(request.getNewPin());
        card.setFirstTimeLogin(false);
        card.setLastPinUpdate(LocalDateTime.now());

        repository.save(card);

        return "PIN GENERATED";
    }
}
