package com.service.currencyconversion.service.controller;

import com.service.currencyconversion.service.constant.CurrencyConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="currency-exchange",url="localhost:8080")
public interface CurrencyExchangeProxy {
    @GetMapping("/currency-exchange/{from}/to/{to}")
    public CurrencyConversion retrieveExchangeValues(@PathVariable("from") String from, @PathVariable("to") String to);
}
