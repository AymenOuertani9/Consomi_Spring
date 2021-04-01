package tn.esprit.pidev.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import tn.esprit.pidev.entities.CurrencyConversionBean;
import tn.esprit.pidev.entities.ExchangeValue;
import tn.esprit.pidev.repository.IExchangeValueRepository;
import tn.esprit.pidev.service.IExchangeValueService;

@RestController
public class CurrencyConversionController {
	@Autowired
	Environment environement;
	@Autowired
	IExchangeValueService exserv;
	@GetMapping("/currency-converter/from/{from}/to/{to}/amount/{amount}") //where {from} and {to} represents the column 
	//returns a bean back
	public CurrencyConversionBean convertCurrency(@PathVariable("from") String from, @PathVariable("to") String to, @PathVariable("amount") BigDecimal amount)
	{
	//setting variables to currency exchange service
	Map<String, String> uriVariables=new HashMap<>();
	uriVariables.put("from", from);
	uriVariables.put("to", to);
	//calling the currency exchange service
	ResponseEntity<CurrencyConversionBean> responseEntity=new RestTemplate().getForEntity("http://localhost:8081/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class, uriVariables);
	CurrencyConversionBean response=responseEntity.getBody();
	//creating a new response bean and getting the response back and taking it into Bean
	return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), amount, amount.multiply(response.getConversionMultiple()), response.getPort());
	}

}
