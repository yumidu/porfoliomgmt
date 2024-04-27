package com.hcl.portfolio.service;

import com.hcl.portfolio.dto.PortfolioDto;
import com.hcl.portfolio.exception.PortfolioException;
import com.hcl.portfolio.model.Portfolio;
import com.hcl.portfolio.repository.PortfolioRepository;

import org.springframework.stereotype.Service;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class PortfolioServiceImpl implements PortfolioService{

    private final PortfolioRepository portfolioRepository;
    private static final Logger logger = LoggerFactory.getLogger(PortfolioServiceImpl.class);

    public PortfolioServiceImpl(PortfolioRepository portfolioRepository) {
        this.portfolioRepository = portfolioRepository;
    }

    @Override
    public PortfolioDto getPortfolio(int i) throws PortfolioException{
        String methodNameForLogs = new Object() {}.getClass().getEnclosingMethod().getName();
        logger.info("Get Portfolio Start in {}: {}", methodNameForLogs, i);

        PortfolioDto portfolioDto = null;

        try{

            Optional<Portfolio> portfolio = portfolioRepository.findById(1);
            if(portfolio.isPresent()){
                portfolioDto = convertToDto(portfolio.get());
            }

        }catch(Exception e){
            logger.info("Error in " + methodNameForLogs + e.getMessage());
            throw new PortfolioException(e.getMessage());
        }
        logger.info("Get Portfolio End in {}: {}", methodNameForLogs, i);
        return portfolioDto;
    }

    private PortfolioDto convertToDto(Portfolio portfolio) {

        PortfolioDto portfolioDto = new PortfolioDto();
        portfolioDto.setCustomerName(portfolio.getCustomerName());
        portfolioDto.setPortfolioNumber(portfolio.getPortfolioNumber());
        portfolioDto.setCurrentPerformance(portfolio.getCurrentPerformance());
        portfolioDto.setPortfolioValue(portfolio.getPortfolioValue());
        portfolioDto.setInvestmentStrategy(portfolio.getInvestmentStrategy());

        return portfolioDto;
    }
}
