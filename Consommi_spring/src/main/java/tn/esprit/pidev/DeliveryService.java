package tn.esprit.pidev.service;


import java.net.URI;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import tn.esprit.pidev.entities.Delivery;
import tn.esprit.pidev.entities.DeliveryEtat;
import tn.esprit.pidev.repsitory.DeliveryRepository;
import tn.esprit.pidev.serviceInterface.DeliveryInterface;



@Service
public class DeliveryService implements DeliveryInterface {

	
	@Autowired
	private DeliveryRepository deliveryRepository;
	
	/********************************************create****************************************************************/

	public void saveDelivery(Delivery delivery   ) {

		deliveryRepository.save(delivery);
	}
	
	/*********************************************update_etat***************************************************************/
	
	@Override
	public void updateEtat( int id , DeliveryEtat etat ) {
		
		deliveryRepository.updateEtat(id, etat);
		
	}
	
	/*******************************************update_rate*****************************************************************/
	
	@Override
	public void updateRate( int id , int rate ) {
		
		deliveryRepository.updateRate(id, rate);
		
	}
	
	/******************************************delete******************************************************************/
	
	public void deleteDelivery(int id) {
		
		deliveryRepository.deleteById(id);

	}
	
	/****************************************read********************************************************************/
	
	public List<Delivery> getAllDelivery() {
		
		return (List<Delivery>) deliveryRepository.findAll();
	}

	/*****************************************sms*******************************************************************/
	
	@Value("${app.twillio.accountSID}")
	private String ACCOUNT_SID;
	
	@Value("${app.twillio.authToken}")
	private String AUTH_TOKEN;
	
	@Override
	public void sendSms(String to,String from,String body) {
		
		try {
		 Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	        Message message = Message.creator( new PhoneNumber(to), new PhoneNumber(from),body) // to:to which no  you want to send sms           
	            .setMediaUrl(Arrays.asList(URI.create("https://demo.twilio.com/owl.png")))     // from: twillio given phone no
	            .setStatusCallback(URI.create("http://postb.in/1234abcd"))                      // body : text message
	            .create();

	        System.out.println(message);
	        System.out.println(message.getSid());

		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	/******************************************findDeliveryById******************************************************************/
	
	@Override
	public Delivery getDelivery(int id) {
		
	return deliveryRepository.findById(id).get();
	
	}
	
	/*****************************************findDeliveryByDeliveryMan*******************************************************************/
	
	@Override
	public List<Delivery> getAllDeliveryByDeliveryMan(int id){
		
		return deliveryRepository.getAllDeliveryByDeliveryMan(id);
		
	}
	
	/************************************************************************************************************/

	
	
	
	
	

	}
