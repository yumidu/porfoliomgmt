package com.hcl.portfolio.controller;

import com.hcl.portfolio.model.Position;
import com.hcl.portfolio.model.requestentities.CreatePositionRequestEntity;
import com.hcl.portfolio.model.responseentities.GetPositionsPerPortfolioResponse;
import com.hcl.portfolio.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author Yumidu Jayarathna
 * @since 4/27/2024
 */

@RestController
@RequestMapping("${server.contextPath}/v1/position")
public class PositionController {
    @Autowired
    PositionService positionService;

    @GetMapping("/get-positions-by-portfolio")
    ResponseEntity<List<Position>> getPositionsPerPortfolio(@RequestParam("portfolio_id") int portfolio_id){
        return new ResponseEntity<>(positionService.getAllPositionsForPortfolio(portfolio_id), HttpStatus.OK);
    }

    @GetMapping("/get-positions-by-instrument")
    ResponseEntity<List<Position>> getPositionsPerInstrument(@RequestParam("instrument_id") Long instrument_id){
        return new ResponseEntity<>(positionService.getAllPositionsForInstrument(instrument_id), HttpStatus.OK);
    }

    @GetMapping("/get-positions-by-instrument-and-portfolio")
    ResponseEntity<List<Position>> getPositionsPerInstrument(@RequestParam("portfolio_id") int portfolio_id,
                                                             @RequestParam("instrument_id") Long instrument_id){
        return new ResponseEntity<>(positionService.getAllPositionsForInstrumentAndPortfolio(instrument_id, portfolio_id), HttpStatus.OK);
    }

    @PostMapping("/create-position")
    ResponseEntity<Position> createPosition(@RequestBody CreatePositionRequestEntity createPositionRequestEntity){
        return new ResponseEntity<>(positionService.createPosition(createPositionRequestEntity),HttpStatus.OK);
    }


}
