package tn.esprit.pidev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.pidev.entities.UserConsomi;
import tn.esprit.pidev.entities.UserEtat;
import tn.esprit.pidev.service.UserService;


@RestController
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	
	@PostMapping(value = "saveUser")
	public String addNewUser(@RequestBody UserConsomi user ) {
		
		user.setAvailability(true);
		
		
		
		
		
	

		userService.saveUser(user);
		return "Added Successfully";
	}
	
	@PutMapping(value = "updateUser")
	
	public UserConsomi updateUser(@RequestBody UserConsomi user) {
		
		//User u = userRepository.findById(user.getIdUser()).get();
		if(user.getEtat()==UserEtat.paied)
		  {
			user.setPremium(0);
			user.setTotHour(0);
			}
		
		return userService.updateUser(user);
	}
	
	@DeleteMapping(value = "deleteUser")
	public String deleteUser(@RequestParam Integer id) {
		System.out.println("At delete User");
		userService.deleteUser(id);
		
		return "User Deleted";
	}
	
	@GetMapping(value = "findAllUser")
	public List<UserConsomi> findAllUser(){
		return userService.getAllUser();
	}

	
	
}
