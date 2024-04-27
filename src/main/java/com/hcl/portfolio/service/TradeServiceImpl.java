package com.hcl.portfolio.service;

import com.hcl.portfolio.model.Position;
import com.hcl.portfolio.model.requestentities.TradeRequestEntity;
import com.hcl.portfolio.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;

/**
 *
 * @author Yumidu Jayarathna
 * @since 4/27/2024
 */

@Service
public class TradeServiceImpl implements TradeService {
    @Autowired
    PositionRepository positionRepository;
    @Override
    public String tradeStock(TradeRequestEntity tradeRequestEntity) {
        if(tradeRequestEntity.getTradeType().equals("sell")){
            Optional<Position> position = Optional.ofNullable(positionRepository.findByInstrumentIdAndPortfolioId(tradeRequestEntity.getInstrumentId(),
                    tradeRequestEntity.getPortfolioId()));
            if(position.isPresent()){
                Position pos = position.get();
                pos.setQuantity(pos.getQuantity().subtract(new BigInteger(String.valueOf(tradeRequestEntity.getTradeQuantity()))));
                Position updatedPosition = positionRepository.save(pos);
                return "Sell operation completed for instrument";
            }
            else{
                return "The Portfolio does not contain stocks of the given instrument";
            }
        }
        else if(tradeRequestEntity.getTradeType().equals("buy")){
            Optional<Position> position = Optional.ofNullable(positionRepository.findByInstrumentIdAndPortfolioId(tradeRequestEntity.getInstrumentId(),
                    tradeRequestEntity.getPortfolioId()));
            if(position.isPresent()){
                Position pos = position.get();
                pos.setQuantity(pos.getQuantity().add(new BigInteger(String.valueOf(tradeRequestEntity.getTradeQuantity()))));
                Position updatedPosition = positionRepository.save(pos);
            }
            else{
                Position newPosition = new Position();
                newPosition.setQuantity(BigInteger.valueOf(tradeRequestEntity.getTradeQuantity()));
                newPosition.setPortfolioId(tradeRequestEntity.getPortfolioId());
                newPosition.setInstrumentId(tradeRequestEntity.getInstrumentId());
            }
            return "Buy operation completed for instrument";
        }
        else {
            return "unknown trade type  - " + tradeRequestEntity.getTradeType();
        }
    }
}
