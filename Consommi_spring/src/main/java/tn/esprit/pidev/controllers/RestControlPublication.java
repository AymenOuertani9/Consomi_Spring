package tn.esprit.pidev.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.pidev.entities.Publication;
import tn.esprit.pidev.entities.Rating;
import tn.esprit.pidev.services.IPublicationService;
import tn.esprit.pidev.services.PostDto;
import tn.esprit.pidev.services.PublicationServiceImpl;
//import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;




@RestController
public class RestControlPublication {
	
	@Autowired
	IPublicationService Pub;
	@Autowired
	PublicationServiceImpl postService;

//	
//	//http://localhost:8085/ajouterPublication
//		@PostMapping("/ajouterPublication")
//		@ResponseBody()
//		public Publication ajouterEmploye(@RequestBody() Publication publication)
//		{
////	        Optional<tn.esprit.pidev.entities.User> User = userrep1.findByUserName((user.getUserName()));
////	        if (User != null) throw new RuntimeException("this Client already exists");
//
//			Pub.ajouterPublication(publication);
//			return publication;
//		}
	//http://localhost:8085/Forum/AddPublication/{idUser
	@PostMapping("/Forum/AddPublication/{idUser}")
	public String addPublication(@RequestBody Publication pub,@PathVariable int idUser) {
        	
		return Pub.addPublication(pub,idUser);
	}

		
		//http://localhost:8085/ajouterPublication/{idpub}
		@DeleteMapping("/user/deletePublicationById/{idpub}") 
		@ResponseBody 
		public void deletePublicationById(@PathVariable("idpub")int idpub) {
			Pub.deletePublicationById(idpub);
			
		}
//		
//		//http://localhost:8085/updatePublicationById/{idpub}
//		@PutMapping("/user/updatePublicationById/{idpub}") 
//		@ResponseBody 
//		public void updatePublicationById(@PathVariable("idpub")int pubup) {
//				Pub.mettreAjourPublicationById(pubup);
//					
//				}
		//http://localhost:8085/user/updatePublicationById/{id}/{newtopic}
		@PutMapping(value = "user/updatePublicationById/{id}/{newtopic}") 
	 	@ResponseBody
		public void mettreAjourEmailByEmployeIdJPQL(@PathVariable("newtopic") String topic, @PathVariable("id") int idpub) {	
		Pub.mettreAjourPublicationById(topic, idpub);;
			
		}
				
//		//http://localhost:8085/		
//	@GetMapping(value ="user/getAllPublicationJPQL")
//	@ResponseBody
//	public List<String> getAllPublicationJPQL() {
//					
//	return Pub.getAllPublicationJPQL();
//				}	
		//http://localhost:8085/Forum/Publications/{idUser}
		@GetMapping("/Forum/Publications/{idUser}")
		public List<Publication> getAllPublicationsByUserId(@PathVariable int idUser){
			return Pub.findPublicationsByIdUser(idUser);
		}
		
		//http://localhost:8085/Forum/Publication/{idPub}/{idUser}
		@GetMapping("/Forum/Publication/{idPub}/{idUser}")
		public Publication getPublicationByPubId(@PathVariable("idPub") int idPub,@PathVariable("idUser") int idUser){
			return Pub.getPublicationById(idPub, idUser);
		}

	
	
//	//http://localhost:8085/{id}/rate
//	 @PutMapping("/{id}/rate")
//	    public ResponseEntity<PostDto> ratePost(@PathVariable final Integer idpub, @RequestBody final Integer buttonState) {
//	        this.postService.rate(idpub, buttonState);
//	        return new ResponseEntity<>(HttpStatus.OK);
//	    }
	//http://localhost:8085/Listpardate
	 @GetMapping("/Listpardate")
	  @ResponseBody
    public List<Publication> Subjectnew(){ 
   	 List<Publication> list =  Pub.Subjectnew(); 
   	 return list; }
	 
	//http://localhost:8085/searchtopic/{topic}
	 @GetMapping("/searchtopic/{topic}")
	  
	  @ResponseBody 
	  public  List<Publication> search(@PathVariable(value = "topic") String topic) {
		  List<Publication> list =  Pub.search(topic); 
		  return list; 
	 }
	 
		//http://localhost:8085/bestevaluation
		@GetMapping("/bestevaluation")
		@ResponseBody
		public List<Publication> getbestsubjects() {
			List<Publication> list = Pub.searchbest();
			return list;
		}
		//http://localhost:8085//evaluate/{idpub}
		@PostMapping("/evaluate/{idpub}")
		@ResponseBody
		public Response addevaluation(@RequestBody Rating u,@PathVariable("idpub") Integer idpub) {
			
			Pub.addEv(u, idpub);
		return Response.status(Status.OK).entity("add successful").build();

		    }
		
		
		@PostMapping("Forum/file")
	    public String  uplodimg (@RequestParam("file") @Nullable MultipartFile file, @RequestParam("idPub") int idPub , @RequestParam("idUser") int idUser ) throws IllegalStateException, IOException {
			Publication pub =Pub.getPublicationById(idPub,idUser);
			if(pub!=null) {
				if(file!=null) {
					File f1=new File("C:\\upload\\"+"image"+idPub+"_"+file.getOriginalFilename());
		             // File f1 = new File("C:\\upload\\" +"image" + idPub+file.getOriginalFilename());

					file.transferTo(f1);
					Path path = Paths.get("C:\\upload\\"+"image"+idPub+"_"+file.getOriginalFilename());
	              //  File f = new File("C:\\upload\\" +"image" + idPub+file.getOriginalFilename());

					if(file.getOriginalFilename().length()>9) return "the Title's lenght of the image must be under 9 characters ";
					if(Pub.getFileSize(path)/1024>255) return "the image's size has to be under or equal 255kb";
					pub.setImageUrl(f1.getName());
				}else pub.setImageUrl("defaultImage.jpg");
				Pub.updatePublication(pub);
				return "successful uploading";
			}else 
				return "You need to verify the form";
				


	       
	    }


}
