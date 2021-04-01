package tn.esprit.pidev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.pidev.entities.ExchangeValue;
import tn.esprit.pidev.repository.IExchangeValueRepository;
@Service
public class ExchangeValueService implements IExchangeValueService{
@Autowired
IExchangeValueRepository exrep;
	@Override
	public ExchangeValue findByFromAndTo(String from,String to) {
		
		return exrep.findByFromAndTo(from, to);
	}
	@Override
	public ExchangeValue findbyid(int ide) {
		
		return exrep.findById(ide).get();
	}

}
