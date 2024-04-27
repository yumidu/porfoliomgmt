package com.hcl.portfolio.model.requestentities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author Yumidu Jayarathna
 * @since 4/27/2024
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TradeRequestEntity {
    Long instrumentId;
    int portfolioId;
    int tradeQuantity;
    String tradeType;
}
