package com.hcl.portfolio.repository;

import com.hcl.portfolio.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 *
 * @author Yumidu Jayarathna
 * @since 4/27/2024
 */
public interface PositionRepository extends JpaRepository<Position,Integer> {
    List<Position> findByPositionId(int positionId);
}
