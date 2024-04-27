package com.hcl.portfolio.repository;

import com.hcl.portfolio.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 *
 * @author Yumidu Jayarathna
 * @since 4/27/2024
 */
public interface PositionRepository extends JpaRepository<Position,Integer> {
    List<Position> findByPortoflioId(int portfolioId);
    List<Position> findByInstrumentId(Long instrumentId);
    @Query(value = "SELECT * FROM m_position WHERE instrument_id = :instrumentId AND portfolio_id = :portfolioId", nativeQuery = true)
    List<Position> findByInstrumentIdAndPortfolioId(Long instrumentId, int portfolioId);
}
