package com.hcl.portfolio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "m_portfolio")
@NoArgsConstructor
@AllArgsConstructor
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    private String customerName;
    private String portfolioNumber;
    private BigDecimal portfolioValue;
    private double currentPerformance;
    private String investmentStrategy;
}
