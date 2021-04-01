package tn.esprit.pidev.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.twilio.rest.chat.v1.service.User;

import tn.esprit.pidev.entities.ExtraTime;
import tn.esprit.pidev.entities.UserConsomi;
import tn.esprit.pidev.entities.UserEtat;
import tn.esprit.pidev.repsitory.ExtraTimeRepository;
import tn.esprit.pidev.repsitory.UserRepository;
import tn.esprit.pidev.service.ExtraTimeService;

@RestController
@CrossOrigin("*")
public class ExtraTimeController {
	
	@Autowired
	private ExtraTimeService extraTimeService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ExtraTimeRepository extraTimeRepository;
	
	/**************************************************create*********************************************************************/

	@PostMapping(value = "saveExtraTime")
	public String addNewExtraTime(@RequestBody ExtraTime extraTime) {
		
		extraTime.setDateExtraTima(new Date());
		UserConsomi user = userRepository.findById(2).get();
		extraTime.setUser(user);
		user.setTotHour(user.getTotHour()+extraTime.getNbrHour());
		user.setPremium(user.getTotHour()*15000);
		user.setEtat(UserEtat.unpaid);
		
		System.out.println("added");
		extraTimeService.saveExtraTime(extraTime);
		return "Added Successfully";
	}
	/**************************************************update*********************************************************************/

	@PutMapping(value = "updateExtraTime/{id}")
	public String updateExtraTime( @PathVariable int id,  @RequestBody int nbrHour) { 
		
		ExtraTime extraTime = extraTimeRepository.findById(id).get();

		UserConsomi user = userRepository.findById(2).get();
		extraTime.setUser(user);
		user.setTotHour((user.getTotHour()-extraTime.getNbrHour())+nbrHour);
		user.setPremium(user.getTotHour()*15000);
				extraTimeRepository.updateNbHour(id, nbrHour);;
				return"extra time was changed"+nbrHour+extraTime.getNbrHour();
	}
	/**************************************************Delete*********************************************************************/
	@DeleteMapping(value = "deleteExtraTime/{id}")
	public String deleteExtraTime(@PathVariable int id) {
		System.out.println("At delete ExtraTime");
		extraTimeService.deleteExtraTime(id);
		
		return "ExtraTime Deleted";
	}
	
	/**************************************************findAll*********************************************************************/
	
	@GetMapping(value = "findAllExtraTime")
	public List<ExtraTime> findAllExtraTime(){
		return extraTimeService.getAllExtraTime();
	}
	
	/**************************************************user*********************************************************************/
	@PutMapping(value = "updateuser/{id}")
	public String updateUser( @PathVariable int id,  @RequestBody UserEtat etat) { 
		
		UserConsomi user = userRepository.findById(id).get();
		if(etat==UserEtat.paied)
		  {
			user.setPremium(0);
			user.setTotHour(0);
			}
		extraTimeRepository.updateUser(id, etat);
		return"etat  was changed";
	}

}
