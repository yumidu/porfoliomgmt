package com.hcl.portfolio;

import com.hcl.portfolio.model.Portfolio;
import com.hcl.portfolio.repository.PortfolioRepository;
import com.hcl.portfolio.service.PortfolioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.math.BigDecimal;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@SpringBootTest
class PortfolioApplicationTests {



	@Autowired
	private PortfolioService portfolioService;

	@MockBean
	private PortfolioRepository portfolioRepository;

	@Test
	public void shouldReturnPortfolioData() {

		BigDecimal portfolioValue = new BigDecimal("43213");
		Portfolio expectedPortfolio = new Portfolio(1,"John Doe", "1001", portfolioValue, 23.4, "Safe");

		when(portfolioRepository.findById(anyInt())).thenReturn(Optional.of(expectedPortfolio));
		Portfolio actualPortfolio = portfolioService.getPortfolio(1);
		// Assert
		assertEquals(expectedPortfolio, actualPortfolio);
	}

}
