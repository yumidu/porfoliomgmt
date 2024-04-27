package com.hcl.portfolio.service;

import com.hcl.portfolio.exceptions.TradeException;
import com.hcl.portfolio.model.requestentities.TradeRequestEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author Yumidu Jayarathna
 * @since 4/27/2024
 */
@Service
public interface TradeService {
    String tradeStock(TradeRequestEntity tradeRequestEntity) throws TradeException;

}
