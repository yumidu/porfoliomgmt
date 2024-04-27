package com.hcl.portfolio.service;

import com.hcl.portfolio.exceptions.PositionNotFoundException;
import com.hcl.portfolio.exceptions.PositionSaveException;
import com.hcl.portfolio.model.Position;
import com.hcl.portfolio.model.requestentities.CreatePositionRequestEntity;
import com.hcl.portfolio.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Yumidu Jayarathna
 * @since 4/27/2024
 */

@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    PositionRepository positionRepository;
    private static final Logger logger = LoggerFactory.getLogger(PositionServiceImpl.class);

    @Override
    public List<Position> getAllPositionsForPortfolio(int portfolioId) throws PositionNotFoundException {
        String methodNameForLogs = new Object() {}.getClass().getEnclosingMethod().getName();
        logger.info("Get all positions for portfolio Start in {}: {}", methodNameForLogs, portfolioId);
        List<Position> positionsForPortfolio = positionRepository.findByPortfolioId(portfolioId);
        if(positionsForPortfolio != null && !positionsForPortfolio.isEmpty()){
            logger.info("Get all positions for portfolio End in {}: {}", methodNameForLogs, portfolioId);
            return positionsForPortfolio;
        }
        else{
            logger.info("Get all positions for portfolio end with no results {}: {}", methodNameForLogs, portfolioId);
            return new ArrayList<>();
        }

    }

    @Override
    public Position createPosition(CreatePositionRequestEntity createPositionRequestEntity) throws PositionSaveException {
        String methodNameForLogs = new Object() {}.getClass().getEnclosingMethod().getName();
        logger.info("create position flow started in {}: {}", methodNameForLogs, createPositionRequestEntity);
        Position position = new Position();
        position.setInstrumentId(createPositionRequestEntity.getInstrumentId());
        position.setPortfolioId(createPositionRequestEntity.getPortfolioId());
        position.setQuantity(createPositionRequestEntity.getQuantity());
        position.setBuyingPrice(createPositionRequestEntity.getBuyingPrice());
        position.setSellingPrice(createPositionRequestEntity.getSellingPrice());

        Position savedPosition = positionRepository.save(position);
        logger.info("create position flow completed in {}: {}", methodNameForLogs, createPositionRequestEntity);
        return savedPosition;
    }

    @Override
    public List<Position> getAllPositionsForInstrument(Long instrumentId) throws PositionNotFoundException {
        String methodNameForLogs = new Object() {}.getClass().getEnclosingMethod().getName();
        logger.info("get all positions for instrument flow started in {}: {}", methodNameForLogs, instrumentId);
        List<Position> positionsForInstrument = positionRepository.findByInstrumentId(instrumentId);
        if(positionsForInstrument != null && !positionsForInstrument.isEmpty()){
            logger.info("get all positions for instrument flow ended in {}: {}", methodNameForLogs, instrumentId);
            return positionsForInstrument;

        }
        else{
            logger.info("get all positions for instrument flow ended with no results {}: {}", methodNameForLogs, instrumentId);
            return new ArrayList<>();
        }
    }

    @Override
    public Position getAllPositionsForInstrumentAndPortfolio(Long instrumentId, int portfolio_id) throws PositionNotFoundException {
        String methodNameForLogs = new Object() {}.getClass().getEnclosingMethod().getName();
        logger.info("get all positions for instrument and portfolio flow started in {}: {}: {}", methodNameForLogs, instrumentId, portfolio_id);
        Optional<Position> positionsForPortfolioAndInstrument = Optional
                .ofNullable(positionRepository.findByInstrumentIdAndPortfolioId(instrumentId, portfolio_id));
        if(positionsForPortfolioAndInstrument.isPresent()){
            logger.info("get all positions for instrument and portfolio flow ended in {}: {}: {}", methodNameForLogs, instrumentId, portfolio_id);
            return positionsForPortfolioAndInstrument.get();
        }
        else{
            logger.info("get all positions for instrument and portfolio flow ended with no results {}: {}: {}", methodNameForLogs, instrumentId, portfolio_id);
            return null;
        }
    }
}
