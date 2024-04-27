package com.hcl.portfolio.controller;

import com.hcl.portfolio.model.requestentities.TradeRequestEntity;
import com.hcl.portfolio.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Yumidu Jayarathna
 * @since 4/27/2024
 */

@RestController
@RequestMapping("${server.contextPath}/v1/trade")
public class TradeController {
    @Autowired
    TradeService tradeService;
    @PostMapping("/trade-stock")
    ResponseEntity<String> trade(@RequestBody TradeRequestEntity tradeRequestEntity){
        return new ResponseEntity<>(tradeService.tradeStock(tradeRequestEntity), HttpStatus.OK);
    }
}
