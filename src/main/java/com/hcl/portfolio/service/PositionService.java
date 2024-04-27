package com.hcl.portfolio.service;

import com.hcl.portfolio.exceptions.PositionNotFoundException;
import com.hcl.portfolio.model.Position;
import com.hcl.portfolio.model.requestentities.CreatePositionRequestEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author Yumidu Jayarathna
 * @since 4/27/2024
 */
@Service
public interface PositionService {

    List<Position> getAllPositionsForPortfolio(int portfolioId) throws PositionNotFoundException;
    Position createPosition(CreatePositionRequestEntity createPositionRequestEntity);
    List<Position> getAllPositionsForInstrument(Long instrumentId) throws PositionNotFoundException;
    Position getAllPositionsForInstrumentAndPortfolio(Long instrumentId, int portfolio_id) throws PositionNotFoundException;


}
