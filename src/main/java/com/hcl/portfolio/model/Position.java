package com.hcl.portfolio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

/**
 *
 * @author Yumidu Jayarathna
 * @since 4/27/2024
 */

@Data
@Entity
@Table(name = "m_position")
@NoArgsConstructor
@AllArgsConstructor
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int positionId;
    private Long instrumentId;
    private BigInteger quantity;
    private int portfolioId;
    private double buyingPrice;
    private double sellingPrice;
}
