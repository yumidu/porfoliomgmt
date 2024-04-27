package com.hcl.portfolio.service;

import org.springframework.stereotype.Service;

/**
 *
 * @author Yumidu Jayarathna
 * @since 4/27/2024
 */
@Service
public interface TradeService {
    String sellStock(int position_id, int quantity);
    String buyStock(int position_id, int quantity);

}
