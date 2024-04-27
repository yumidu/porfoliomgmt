package com.hcl.portfolio.service;

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

    List<Position> getAllPositionsForPortfolio(int portfolioId);
    Position createPosition(CreatePositionRequestEntity createPositionRequestEntity);


}
