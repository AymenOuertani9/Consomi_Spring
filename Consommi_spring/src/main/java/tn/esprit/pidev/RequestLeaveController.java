package tn.esprit.pidev.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.pidev.entities.RequestLeave;
import tn.esprit.pidev.entities.RequestLeaveEtat;
import tn.esprit.pidev.entities.UserConsomi;
import tn.esprit.pidev.repsitory.RequestLeaveRepository;
import tn.esprit.pidev.repsitory.UserRepository;
import tn.esprit.pidev.service.RequestLeaveService;

@RestController
@CrossOrigin("*")
public class RequestLeaveController {
	
	@Autowired
	private RequestLeaveService requestLeaveService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RequestLeaveRepository requestLeaveRepository;
	
	/******************************************Create***********************************************************************/
	
	@PostMapping(value = "saveRequestLeave")
	public String addNewRequestLeave(@RequestBody RequestLeave requestLeave) {
		
		requestLeave.setEtat(RequestLeaveEtat.in_progress);
		
		UserConsomi user = userRepository.findById(2).get();
		requestLeave.setUser(user);
		
		if(requestLeave.getStartDate().compareTo(requestLeave.getEndDate()) < 0)
		{
			System.out.println("Request Leave was addes");

		}
		else 
		{
			return "start date :"+requestLeave.getStartDate()+" is greather than end date : "+requestLeave.getEndDate();
		}
		
		
		requestLeaveService.saveRequestLeave(requestLeave);
		return "RequestLeave was Successfully added";
	}
	
	/******************************************updateEtat***********************************************************************/
	
	@PutMapping(value = "updateRequestleaveEtat/{id}")
	public String updateRequestleave( @PathVariable int id ,@RequestBody RequestLeaveEtat etat  ) {
		
		RequestLeave requestLeave = requestLeaveRepository.findById(id).get();
		UserConsomi user = userRepository.findById(requestLeave.getUser().getIduser()).get();
		
		if(requestLeave.getEtat()==RequestLeaveEtat.accepted)
		  {
			user.setAvailability(false);
			
		  }
		
		else if(requestLeave.getEtat()==RequestLeaveEtat.refuse)
		{
			user.setAvailability(true);
			
		}
		
		requestLeaveService.updateEtat(id, etat);
		return "etat was changed" ;	
	}
	
	/***********************************************delete******************************************************************/
	
	@DeleteMapping(value = "deleteRequestLeave/{id}")
	public String deleteRequestLeave(@PathVariable int id) {
		
		requestLeaveService.deleteRequestLeave(id);
		System.out.println("RequestLeave was deleted");
		return "RequestLeave was Deleted";
		
	}
	
	/**************************************findAll***************************************************************************/
	
	@GetMapping(value = "findAllRequestLeave")
	public List<RequestLeave> findAllUser(){
		
		return requestLeaveService.getAllRequestLeave();
	}
	
	/******************************************findByUser***********************************************************************/


}
