package com.hcl.portfolio.service;

import com.hcl.portfolio.model.Position;
import org.springframework.stereotype.Service;

/**
 *
 * @author Yumidu Jayarathna
 * @since 4/27/2024
 */

@Service
public class TradeServiceImpl implements TradeService {
    @Override
    public String tradeStock(int position_id, int tradeQuantity, String tradeType) {
        if(tradeType.equals("sell")){

        }
        else if(tradeType.equals("buy")){

        }
        return null;
    }
}
