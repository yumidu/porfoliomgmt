package com.hcl.portfolio.model.responseentities;

import com.hcl.portfolio.model.Position;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 *
 * @author Yumidu Jayarathna
 * @since 4/27/2024
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetPositionsPerPortfolioResponse {
    List<Position> positions;
}
