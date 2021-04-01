package tn.esprit.pidev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.pidev.entities.ExchangeValue;
import tn.esprit.pidev.service.IExchangeValueService;

@RestController
public class CurrencyExchangeRestController {
	@Autowired
	Environment environement;
	@Autowired
	IExchangeValueService exserv;
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable("from") String from,@PathVariable("to") String to) {
		return exserv.findByFromAndTo(from, to);
		//ExchangeValue exchange=new ExchangeValue(8,from,to,BigDecimal.valueOf(60));
		//exchange.setPort(Integer.parseInt(environement.getProperty("local.server.port")));
		
	}
	@GetMapping(value = "/findcurrencybyid/{idc}")
	public ExchangeValue findbyid(@PathVariable ("idc") int ide) {
		return exserv.findbyid(ide);
	}
}
