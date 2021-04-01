package tn.esprit.pidev.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.pidev.entities.Command;
import tn.esprit.pidev.entities.Delivery;
import tn.esprit.pidev.entities.DeliveryEtat;
import tn.esprit.pidev.entities.DeliveryRegion;
import tn.esprit.pidev.entities.Etat;
import tn.esprit.pidev.entities.UserConsomi;
import tn.esprit.pidev.repsitory.DeliveryRepository;
import tn.esprit.pidev.repsitory.UserRepository;
import tn.esprit.pidev.service.DeliveryService;




@RestController
@CrossOrigin("*")
public class DeliveryController {
	
	@Autowired
	private DeliveryService deliveryService;
	
	@Autowired
	private DeliveryRepository deliveryRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Value("${app.twillio.fromPhoneNo}")
	private String from;
	
	/***********************************************create****************************************************************************/
	
	@PostMapping(value = "saveDelivery")
	public String addNewDelivery(@RequestBody Delivery delivery , DeliveryRegion workzone, boolean availability, String role , Etat etat) {
		
		delivery.setEtat(DeliveryEtat.in_progress);
		
		switch (delivery.getRegion()) {
		case nabeul:
			delivery.setShippingCoast(7000);
			break;
		case tunis:
			delivery.setShippingCoast(5000);
			break;
		case sfax:
			delivery.setShippingCoast(9000);
			break;
		case mednine:
			delivery.setShippingCoast(10000);
			break;
		case gafsa:
			delivery.setShippingCoast(10000);
			break;
		case monastir:
			delivery.setShippingCoast(8000);
			break;
		case sousse:
			delivery.setShippingCoast(8000);
			break;
		case gabes:
			delivery.setShippingCoast(10000);
			break;
		case sidi_bou_zid:
			delivery.setShippingCoast(12000);
			break;
		case ben_arous:
			delivery.setShippingCoast(5000);
			break;
		case beja:
			delivery.setShippingCoast(8000);
			break;
		case kef:
			delivery.setShippingCoast(9000);
			break;
		case siliana:
			delivery.setShippingCoast(10000);
			break;
		case kairouan:
			delivery.setShippingCoast(11000);
			break;
		case tataouine:
			delivery.setShippingCoast(15000);
			break;
		case bizerte:
			delivery.setShippingCoast(7000);
			break;
		case jendouba:
			delivery.setShippingCoast(8000);
			break;
		case kasserine:
			delivery.setShippingCoast(11000);
			break;
		case tozeur:
			delivery.setShippingCoast(12000);
			break;
		case mahdia:
			delivery.setShippingCoast(7000);
			break;
		case ariana:
			delivery.setShippingCoast(6000);
			break;
		case zaghouan:
			delivery.setShippingCoast(9000);
			break;
		case kebili:
			delivery.setShippingCoast(13000);
			break;
		case manouba:
			delivery.setShippingCoast(8000);
			break;

		default:
			delivery.setShippingCoast(0);
			break;
		}
		
		availability = true;
		role = "deliveryMan";
		workzone = delivery.getRegion();
		etat = Etat.PREPARING;
		
		UserConsomi user = deliveryRepository.findDeliveryMan(workzone, availability, role);
		
			if (user != null)
				
			{
				Command cmd = deliveryRepository.findCommand(etat);
				if(cmd != null)
				{
						delivery.setCommande(cmd);
						cmd.setEtat(Etat.DELIVERY);
						delivery.setUser(user);
						
						deliveryService.saveDelivery(delivery);
						
						/*UserConsomi u = userRepository.findById(1).get();
						String a =u.getTel();
						
						String body = "your order has been successfully registered our delivery man ( phone : "+delivery.getUser().getTel()+") will contact you to deliver your package  ";
						deliveryService.sendSms("+216"+a, from, body);*/
						
						System.out.println("Delivery successfully was added");
						return"Delivery was successfully added";
						
				}
				
				else
				{
						System.out.println("there is not an order whose etat is different from PREPARING ");
						return"there is no order whose etat is different from PREPARING";
						
				}
				
			}
			
			else
			{
				System.out.println(user.getIduser());
				return"we can't delivred to : "+delivery.getRegion();
			}
			
	}
	
	/***********************************************update****************************************************************************/
	
	@PutMapping(value = "updateEtat/{id}")
	
	public String updateEtat(@PathVariable int id ,  @RequestBody DeliveryEtat etat ) {
		
		Delivery delivery = deliveryRepository.findById(id).get();
		if(delivery.getEtat()==etat)
		{
			return"Etat is already :"+etat;
		}
		
		deliveryService.updateEtat(id, etat);
		
		/*if(delivery.getEtat()==etat.delivered)
		{
			UserConsomi user = userRepository.findById(1).get();
			String a =user.getTel();
			
			String body = "you have succesfully received your package you can vote the delivery by consulting our website ";
			deliveryService.sendSms("+216"+a, from, body);
			
		}*/

		System.out.println("etat was changed");
		return"etat was changed to : "+etat;

	}
	
	/***********************************************delete****************************************************************************/
	
	@DeleteMapping(value = "deleteDelivery/{id}")
	public String deleteDelivery(@PathVariable int id) {
		System.out.println("Delivery Deleted");
		deliveryService.deleteDelivery(id);
		return "Delivery Deleted";
	}
	
	/***********************************************read****************************************************************************/
	
	@GetMapping(value = "findAllDelivery")
	public List<Delivery> findAllDelivery(){
		
	return deliveryService.getAllDelivery();

	}
	
	/***********************************************rate****************************************************************************/
	
	@PutMapping(value = "rateDelivery/{id}")
	public String rateDelivery(@PathVariable int id ,  @RequestBody int rate) {
		
		if((rate>0)&(rate<10))
			{
				deliveryService.updateRate(id, rate);
				return "you have already rated your delivery";	
			}
			
			else
			{
				return "error";
			}
		
	}	
	
	/***********************************************findDeliveryById****************************************************************************/
	
	@GetMapping(value = "findDelivery/{id}")
	public Delivery getDelivery( @PathVariable int id) {
		return deliveryService.getDelivery(id);
	}
	
	/***********************************************findDeliveryByDeliveryMan****************************************************************************/
	
	@GetMapping(value = "findByDeliveryMan/{id}")
	public List<Delivery> findAllDeliveryByDeliveryMan(@PathVariable int id){
		
		return deliveryService.getAllDeliveryByDeliveryMan(id);

	}
	
	/***************************************test**************************************/
	
	@GetMapping(value = "tt/{id}")
	public Delivery find( @PathVariable int id) {
		//id = 6;
		return deliveryRepository.findDelivery(id);	}
}


	


