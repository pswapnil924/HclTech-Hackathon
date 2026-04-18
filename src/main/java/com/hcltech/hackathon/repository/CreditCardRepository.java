package com.hcltech.hackathon.repository;

import com.hcltech.hackathon.entity.CreditCardAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCardAccount, String> {
    Optional<CreditCardAccount> findByCardNumberAndDocumentId(String cardNumber, String documentId);
}
