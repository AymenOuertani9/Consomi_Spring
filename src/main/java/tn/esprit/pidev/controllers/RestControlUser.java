package tn.esprit.pidev.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.pidev.entities.User;
import tn.esprit.pidev.repositories.UserRepository;
import tn.esprit.pidev.services.IUserService;

@RestController
public class RestControlUser {
	
	@Autowired
	IUserService userrep;
	@Autowired
	UserRepository userrep1;
	
	
	//http://localhost:8085/ajouterUser
	@PostMapping("/user/ajouterUser")
	@ResponseBody()
	public User ajouterEmploye(@RequestBody() User user)
	{
//        Optional<tn.esprit.pidev.entities.User> User = userrep1.findByUserName((user.getUserName()));
//        if (User != null) throw new RuntimeException("this Client already exists");

		userrep.ajouterUser(user);
		return user;
	}
	//http://localhost:8085/SpringMVC/servlet
	@GetMapping("/")
	public String home(){
		return ("<h1>welcome</h1>");
		
	}
	//http://localhost:8085/SpringMVC/servlet/user
	@GetMapping("/user")
	public String User(){
		return ("<h1>welcome</h1>");
	}
	//http://localhost:8085/SpringMVC/servlet/admin
	@GetMapping("/admin")
	public String admin(){
		return ("<h1>welcome admin</h1>");
	}
	
	

}
