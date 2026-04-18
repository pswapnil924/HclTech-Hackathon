package com.hcltech.hackathon.service;

import com.hcltech.hackathon.dto.ApplicationResponseDto;
import com.hcltech.hackathon.entity.User;
import com.hcltech.hackathon.repository.UserRepository;
import org.springframework.stereotype.Service;


@Service
public class ApplicationHandlerService {
    private final UserRepository userRepository;


    public ApplicationHandlerService(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    public ApplicationResponseDto handleApplication(String appId) {

        User user = userRepository.findByApplicationId(appId)
                .orElseThrow(() -> new RuntimeException("Application not present"));

        Integer creditScore = user.getCreditScore();

        if (creditScore <= 50) {
            return new ApplicationResponseDto(null, null, null, null, "Provide additional verification document");
        }

        if (creditScore >= 500) {
            return new ApplicationResponseDto("PLATINUM", "676745459090", 5698, 40000, "Successful");
        }

        if (creditScore >= 300) {
            return new ApplicationResponseDto("GOLD", "345689008768", 5698, 20000,
                    "Successful");
        }

        return new ApplicationResponseDto("VISA", "128745632099", 5698, 10000, "Successful");
    }
}
