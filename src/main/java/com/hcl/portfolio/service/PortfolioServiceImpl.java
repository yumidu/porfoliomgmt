package com.hcl.portfolio.service;

import com.hcl.portfolio.dto.PortfolioDto;
import com.hcl.portfolio.exception.PortfolioException;
import com.hcl.portfolio.model.Portfolio;
import com.hcl.portfolio.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PortfolioServiceImpl implements PortfolioService{

    private final PortfolioRepository portfolioRepository;

    public PortfolioServiceImpl(PortfolioRepository portfolioRepository) {
        this.portfolioRepository = portfolioRepository;
    }

    @Override
    public PortfolioDto getPortfolio(int i) throws PortfolioException{

        PortfolioDto portfolioDto = null;

        try{

            Optional<Portfolio> portfolio = portfolioRepository.findById(1);
            if(portfolio.isPresent()){
                portfolioDto = convertToDto(portfolio.get());
            }

        }catch(Exception e){
            throw new PortfolioException(e.getMessage());
        }
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
