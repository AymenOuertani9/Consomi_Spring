package tn.esprit.pidev.serviceInterface;

import java.util.List;

import tn.esprit.pidev.entities.Delivery;
import tn.esprit.pidev.entities.DeliveryEtat;


public interface DeliveryInterface {
	
	public void saveDelivery(Delivery delivery );
	public void updateEtat( int id , DeliveryEtat etat );
	public void updateRate( int id , int rate );
	public void deleteDelivery(int id);
	public List<Delivery> getAllDelivery();
	public void sendSms(String to, String from, String body);
	public Delivery getDelivery(int id);
	public List<Delivery> getAllDeliveryByDeliveryMan(int id);
	

	

}
