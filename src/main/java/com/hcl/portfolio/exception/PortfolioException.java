package com.hcl.portfolio.exception;

import lombok.NoArgsConstructor;
/**
 *@author Irosha Senevirathne
 *@version 1.0
 */
@NoArgsConstructor
public class PortfolioException extends RuntimeException{

    public PortfolioException(String message){
        super(message);
    }
}
