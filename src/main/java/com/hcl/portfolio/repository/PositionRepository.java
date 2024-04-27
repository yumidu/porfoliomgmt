package com.hcl.portfolio.repository;

import com.hcl.portfolio.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author Yumidu Jayarathna
 * @since 4/27/2024
 */
@Repository
public interface PositionRepository extends JpaRepository<Position,Integer> {
    Position findByPositionId(int positionId);
    List<Position> findByPortfolioId(int portfolioId);
    List<Position> findByInstrumentId(Long instrumentId);
    @Query(value = "SELECT * FROM m_position WHERE instrument_id = :instrumentId AND portfolio_id = :portfolioId", nativeQuery = true)
    Position findByInstrumentIdAndPortfolioId(Long instrumentId, int portfolioId);
}
