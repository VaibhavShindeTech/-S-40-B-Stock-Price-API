package com.vaibhavshindetech.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaibhavshindetech.response.StockPriceFeignClient;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Vaibhav
 *
 */
@RestController
@RequestMapping(value = { "/stock" })
@Slf4j
public class StockCalcRestcontroller {
	@Autowired
	private StockPriceFeignClient stockPriceFeignClient;

	@GetMapping(value = { "/cost/{name}/{qty}" })
	public Double totalCostOfStock(@PathVariable(value = "name") String stockNmae,
			@PathVariable(value = "qty") Integer quantity) {
		log.info("inside totalCostOfStock() method of StockCalcRestcontroller");
		Double stockPrice = stockPriceFeignClient.findStockPriceByStockName(stockNmae);
		Double totalCost = stockPrice * quantity;
		return totalCost;
	}
}
