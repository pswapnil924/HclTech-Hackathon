package com.hcltech.hackathon.service;

import java.math.BigDecimal;

public class CustomerCreditRatingServiceImpl{

    private static final BigDecimal HIGH_SALARY_THRESHOLD = new BigDecimal("200000");
    private static final BigDecimal LOW_SALARY_THRESHOLD = new BigDecimal("50000");

    private static final int SCORE_HIGH = 500;
    private static final int SCORE_MEDIUM = 150;
    private static final int SCORE_LOW = 50;

    /**
     * Calculates the credit score based on annual salary.
     *
     * @param annualSalary The annual salary of the applicant
     * @return int The calculated credit score
     */
    public int getCreditScore(BigDecimal annualSalary) {
        if (annualSalary == null) {
            throw new IllegalArgumentException("Salary cannot be null");
        }

        if (annualSalary.compareTo(HIGH_SALARY_THRESHOLD) > 0) {
            return SCORE_HIGH;
        } else if (annualSalary.compareTo(LOW_SALARY_THRESHOLD) > 0) {
            return SCORE_MEDIUM;
        } else {
            return SCORE_LOW;
        }
    }
}
