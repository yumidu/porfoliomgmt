package com.hcl.portfolio.model.requestentities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigInteger;

/**
 *
 * @author Yumidu Jayarathna
 * @since 4/27/2024
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreatePositionRequestEntity {
    private Long instrumentId;
    private int portfolioId;
    private BigInteger quantity;
    private double buyingPrice;
    private double sellingPrice;
}
