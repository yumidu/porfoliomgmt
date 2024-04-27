package com.hcl.portfolio.service;

import com.hcl.portfolio.model.Position;
import com.hcl.portfolio.model.requestentities.CreatePositionRequestEntity;
import com.hcl.portfolio.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Yumidu Jayarathna
 * @since 4/27/2024
 */

@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    PositionRepository positionRepository;

    @Override
    public List<Position> getAllPositionsForPortfolio(int portfolioId) {
        List<Position> positionsForPortfolio = positionRepository.findByPortfolioId(portfolioId);
        if(positionsForPortfolio != null && !positionsForPortfolio.isEmpty()){
            return positionsForPortfolio;
        }
        else{
            return new ArrayList<>();
        }
    }

    @Override
    public Position createPosition(CreatePositionRequestEntity createPositionRequestEntity) {
        Position position = new Position();
        position.setInstrumentId(createPositionRequestEntity.getInstrumentId());
        position.setPortfolioId(createPositionRequestEntity.getPortfolioId());
        position.setQuantity(createPositionRequestEntity.getQuantity());
        position.setBuyingPrice(createPositionRequestEntity.getBuyingPrice());
        position.setSellingPrice(createPositionRequestEntity.getSellingPrice());

        Position savedPosition = positionRepository.save(position);
        return savedPosition;
    }

    @Override
    public List<Position> getAllPositionsForInstrument(Long instrumentId) {
        List<Position> positionsForInstrument = positionRepository.findByInstrumentId(instrumentId);
        if(positionsForInstrument != null && !positionsForInstrument.isEmpty()){
            return positionsForInstrument;
        }
        else{
            return new ArrayList<>();
        }
    }

    @Override
    public Position getAllPositionsForInstrumentAndPortfolio(Long instrumentId, int portfolio_id) {
        Optional<Position> positionsForPortfolioAndInstrument = Optional
                .ofNullable(positionRepository.findByInstrumentIdAndPortfolioId(instrumentId, portfolio_id));
        if(positionsForPortfolioAndInstrument.isPresent()){
            return positionsForPortfolioAndInstrument.get();
        }
        else{
            return null;
        }
    }
}
