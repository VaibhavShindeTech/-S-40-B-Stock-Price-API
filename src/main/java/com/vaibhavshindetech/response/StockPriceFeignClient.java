package com.vaibhavshindetech.response;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 
 * @author Vaibhav
 *
 */
@FeignClient(name = "STOCK-PRICE-API")
public interface StockPriceFeignClient {
	@GetMapping(value = { "/stock/price/{name}" })
	public Double findStockPriceByStockName(@PathVariable(value = "name") String stockName);
}
