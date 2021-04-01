package tn.esprit.pidev.service;



import tn.esprit.pidev.entities.ExchangeValue;

public interface IExchangeValueService {
	public ExchangeValue findByFromAndTo( String from , String to);
	public ExchangeValue findbyid(int ide);
}
