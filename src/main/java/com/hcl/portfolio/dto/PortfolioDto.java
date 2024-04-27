package com.hcl.portfolio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PortfolioDto {

    private String customerName;
    private String portfolioNumber;
    private BigDecimal portfolioValue;
    private double currentPerformance;
    private String investmentStrategy;
}
