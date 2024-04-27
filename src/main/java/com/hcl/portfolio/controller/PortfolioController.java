package com.hcl.portfolio.controller;

import com.hcl.portfolio.dto.PortfolioDto;
import com.hcl.portfolio.service.PortfolioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/portfolio")
public class PortfolioController {


    private final PortfolioService portfolioService;

    public PortfolioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    @GetMapping()
    public ResponseEntity<PortfolioDto> getPortfolio(@RequestParam Integer id){
        return new ResponseEntity<>(portfolioService.getPortfolio(id), HttpStatus.OK);
    }


}
