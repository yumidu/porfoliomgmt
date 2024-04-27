package com.hcl.portfolio.service;

import com.hcl.portfolio.exceptions.TradeException;
import com.hcl.portfolio.model.Position;
import com.hcl.portfolio.model.requestentities.TradeRequestEntity;
import com.hcl.portfolio.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Yumidu Jayarathna
 * @since 4/27/2024
 */

@Service
public class TradeServiceImpl implements TradeService {
    @Autowired
    PositionRepository positionRepository;

    private static final Logger logger = LoggerFactory.getLogger(TradeServiceImpl.class);
    @Override
    public String tradeStock(TradeRequestEntity tradeRequestEntity) throws TradeException {
        String methodNameForLogs = new Object() {}.getClass().getEnclosingMethod().getName();
        if(tradeRequestEntity.getTradeType().equals("sell")){
            logger.info("stock trading sell Start in {}: {}", methodNameForLogs, tradeRequestEntity);
            Optional<Position> position = Optional.ofNullable(positionRepository.findByInstrumentIdAndPortfolioId(tradeRequestEntity.getInstrumentId(),
                    tradeRequestEntity.getPortfolioId()));
            if(position.isPresent()){
                Position pos = position.get();
                pos.setQuantity(pos.getQuantity().subtract(new BigInteger(String.valueOf(tradeRequestEntity.getTradeQuantity()))));
                Position updatedPosition = positionRepository.save(pos);
                logger.info("stock trading sell ended in {}: {}", methodNameForLogs, tradeRequestEntity);
                return "Sell operation completed for instrument";
            }
            else{
                logger.info("stock trading sell ended with no portfolio update in {}: {}", methodNameForLogs, tradeRequestEntity);
                return "The Portfolio does not contain stocks of the given instrument";
            }
        }
        else if(tradeRequestEntity.getTradeType().equals("buy")){
            logger.info("stock trading buy Start in {}: {}", methodNameForLogs, tradeRequestEntity);
            Optional<Position> position = Optional.ofNullable(positionRepository.findByInstrumentIdAndPortfolioId(tradeRequestEntity.getInstrumentId(),
                    tradeRequestEntity.getPortfolioId()));
            if(position.isPresent()){
                Position pos = position.get();
                pos.setQuantity(pos.getQuantity().add(new BigInteger(String.valueOf(tradeRequestEntity.getTradeQuantity()))));
                Position updatedPosition = positionRepository.save(pos);
                logger.info("stock trading buy ended with update to position in {}: {}", methodNameForLogs, tradeRequestEntity);
            }
            else{
                Position newPosition = new Position();
                newPosition.setQuantity(BigInteger.valueOf(tradeRequestEntity.getTradeQuantity()));
                newPosition.setPortfolioId(tradeRequestEntity.getPortfolioId());
                newPosition.setInstrumentId(tradeRequestEntity.getInstrumentId());
                logger.info("stock trading buy ended with adding a new position in {}: {}", methodNameForLogs, tradeRequestEntity);
            }
            return "Buy operation completed for instrument";
        }
        else {
            return "unknown trade type  - " + tradeRequestEntity.getTradeType();
        }
    }
}
