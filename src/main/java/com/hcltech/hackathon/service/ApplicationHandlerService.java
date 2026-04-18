package com.hcltech.hackathon.service;

import com.hcltech.hackathon.dto.ApplicationResponseDto;
import org.springframework.stereotype.Service;

@Service
public class ApplicationHandlerService {
    private final UserRepository userRepository;


    public ApplicationHandlerService(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    public ApplicationResponseDto handleApplication(Integer appId) {
        User user = userRepository.findByApplicationId(appId);
        Integer creditScore = user.getCreditScore();

        ApplicationResponseDto newCard = new ApplicationResponseDto();

        if (creditScore < 50) {
            newCard.setMessage("Please submit addition verification documents!");
        } else if (creditScore >= 500) {
            newCard.setCardNumber("676745459090");
            newCard.setPin(5690);
            newCard.setCartType("PLATINUM");
            newCard.setLimit(40000);
        } else if (creditScore >= 300) {
            newCard.setCardNumber("676745459090");
            newCard.setPin(5690);
            newCard.setCartType("GOLD");
            newCard.setLimit(20000);
        } else if (creditScore >= 150) {
            newCard.setCardNumber("676745459090");
            newCard.setPin(5690);
            newCard.setCartType("VISA");
            newCard.setLimit(10000);
        }

        return newCard;
    }
}
