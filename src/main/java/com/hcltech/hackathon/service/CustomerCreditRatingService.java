package com.hcltech.hackathon.service;

import java.math.BigDecimal;

public interface CustomerCreditRatingService {

    int getCreditScore(BigDecimal Salary);
}
