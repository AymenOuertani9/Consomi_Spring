package tn.esprit.pidev.controllers;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.multipart.MultipartFile;


import lombok.Data;
import tn.esprit.pidev.entities.Chat;
import tn.esprit.pidev.entities.Contrat;
import tn.esprit.pidev.entities.UserConsomi;
import tn.esprit.pidev.repositories.ContratRepository;
import tn.esprit.pidev.repositories.UserRepository;
import tn.esprit.pidev.services.IUserService;
import tn.esprit.pidev.services.UserServiceImpl;

@RestController
public class RestControlUser {
	
	@Autowired
	IUserService userrep;
	@Autowired
	UserRepository userrep1;
	@Autowired
	UserServiceImpl use;
	@Autowired
	ContratRepository az;
	
	
	
	
	//http://localhost:8085/register
	@PostMapping("/register")
    public String register(@RequestBody() UserConsomi user) {
        return userrep.saveUser(user);
    }
	//http://localhost:8085/confirm
	 @GetMapping(path = "confirm")
	    public String confirm(@RequestParam("token") String token) {
	        return use.confirmToken(token);
	    }
	//http://localhost:8085/
	@GetMapping("/")
	public String home(){
		return ("<h1>welcome</h1>");
		
	}
	//http://localhost:8085/user
	@GetMapping("/user")
	public String User(){
		return ("<h1>welcome</h1>");
	}
	//http://localhost:8085/admin
	@GetMapping("/admin")
	public String admin(){
		return ("<h1>welcome admin</h1>");
	}
	
//	@Data
//	class UserForm{
//	    private String username;
//	    private String password;
//	    private String confirmedPassword;
//		public String getUsername() {
//			
//			
//			
//			return username;
//		}
//		public UserForm() {
//			super();
//			// TODO Auto-generated constructor stub
//		}
//		
//		
//		
//		public UserForm(String username, String password, String confirmedPassword) {
//			super();
//			this.username = username;
//			this.password = password;
//			this.confirmedPassword = confirmedPassword;
//		}
//		public void setUsername(String username) {
//			this.username = username;
//		}
//		public String getPassword() {
//			return password;
//		}
//		public void setPassword(String password) {
//			this.password = password;
//		}
//		public String getConfirmedPassword() {
//			return confirmedPassword;
//		}
//		public void setConfirmedPassword(String confirmedPassword) {
//			this.confirmedPassword = confirmedPassword;
//		}
//	    
//	    
//	    
//	    
//	}
//	
	//http://localhost:8085/file
	@PostMapping("/file")
    @ResponseBody
    public UserConsomi  uploddimg (@RequestParam("file") @Nullable MultipartFile file, @RequestParam("user") int iduser ) {
        UserConsomi user =userrep.findById(iduser);
        if(file==null) {
            user.setPicture("defaultPic.png");
            userrep.saveUser(user);
        }else {
            try {
                ClassLoader classLoader = getClass().getClassLoader();
                String path =  classLoader.getResource(".").getFile();
               
                File f = new File("C:\\upload\\" +"image" + iduser+file.getOriginalFilename());
                file.transferTo(f);
               user.setPicture("image"+iduser+file.getOriginalFilename());
               userrep.saveUser(user);
            } catch (IllegalStateException e) {
           
                e.printStackTrace();
            } catch (IOException e) {
            
                e.printStackTrace();
            }
        }

        return(user);
    }
	
	
	//http://localhost:8085/ajouterContrat
	@PostMapping("/ajouterContrat")
	@ResponseBody
	public int ajouterContrat(@RequestBody Contrat contrat) {
		use.ajouterContrat(contrat);
		return contrat.getIdcontrat();
	}
	
	// http://localhost:8085/affecterContratAEmploye/6/1
   @PutMapping(value = "/affecterContratAEmploye/{idcontrat}/{iduser}") 
	public void affecterContratAEmploye(@PathVariable("idcontrat")int contratId, @PathVariable("iduser")int employeId)
	{
		use.affecterContratAEmploye(contratId, employeId);
	}
	
   // http://localhost:8085/getNombreEmployeJPQL
   @GetMapping(value = "getNombreEmployeJPQL")
   @ResponseBody
	public int getNombreEmployeJPQL() {
		
		return use.getNombreEmployeJPQL();
	}
   // http://localhost:8085/getSalaire/{idemp}
   @GetMapping(value = "getSalaire/{idemp}")
   @ResponseBody
	public float getSalaireByEmployeIdJPQL(@PathVariable("idemp")int employeId) {
		return use.getSalaireByEmployeIdJPQL(employeId);
	}
   
   
   // http://localhost:8085/getSalaireMoyen
   @GetMapping(value = "getSalaireMoyen")
   @ResponseBody
	public Double getSalaireMoyen() {
		return use.getSalaires();
	}
	
   // http://localhost:8085/getCarburant
   @GetMapping(value = "getCarburant")
   @ResponseBody
	public Double getCarburant() {
		return use.getCarburant();
	}
   
   // http://localhost:8085//Forum/Send/{idSender}/{idRecipient}
   @PostMapping("/Forum/Send/{idSender}/{idRecipient}")
	public String SendMsg(@RequestBody Chat chat,@PathVariable("idSender") int idSender,@PathVariable("idRecipient") int idRecipient)
	{
		
		return userrep.sendMsg(chat, idSender, idRecipient);
	}
   // http://localhost:8085//Forum/Receive/{idSender}/{idRecipient}
	@GetMapping("/Forum/Receive/{idSender}/{idRecipient}")
	public List<String> getMessages(@PathVariable("idSender") int idSender,@PathVariable("idRecipient") int idRecipient) {

	return userrep.getMsg(idSender, idRecipient);
	}

	

}
