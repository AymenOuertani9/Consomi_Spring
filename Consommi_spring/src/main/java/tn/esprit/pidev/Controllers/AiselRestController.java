package tn.esprit.pidev.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import tn.esprit.pidev.entities.Ads;
import tn.esprit.pidev.entities.Aisel;
import tn.esprit.pidev.service.AiselService;

@RestController
public class AiselRestController {
	
	@Autowired
	AiselService aiselservice;

	@PostMapping("/AddAisel")
	@ResponseBody
	public Aisel AddAisel(@RequestBody Aisel aisel){
		
		return aiselservice.AddAisel(aisel);
	}
	
	@PutMapping("/ModAisel/{aiselId}")
	@ResponseBody
	public void Mod_Aisel(@PathVariable("aiselId")int aiselId,@RequestBody Aisel aisel){
		
		aiselservice.Mod_Aisel(aiselId, aisel);
	}
	
	@DeleteMapping("/DeleteAisel/{aiselId}")
	@ResponseBody
	public void Del_Aisel(@PathVariable("aiselId")int aiselId){
		
		aiselservice.Del_Aisel(aiselId);
		
	}
	
	@GetMapping("/AllAisel")
	@ResponseBody
	public List<Aisel> getAds(){
		List<Aisel> list = aiselservice.GetAllAisel();
		return list;
	}
	
	@PutMapping("/ProdToaisel/{cat}/{aiselId}")
	@ResponseBody
	public Aisel AffectProdctToAisel(@PathVariable("cat")int Cate,@PathVariable("aiselId")int aiselId) {
		
		return aiselservice.AffectProdctToAisel(Cate, aiselId);
		
	}
	
	@PutMapping("/SpecProdToaisel/{aiselId}/{prodId}")
	@ResponseBody
	public String AffecterSpecificProduct(@PathVariable("aiselId")int aiselId, @PathVariable("prodId")int prodId) {
		
		return aiselservice.AffecterSpecificProduct(aiselId, prodId);
		
	}
	
	@DeleteMapping("/SpecProdToaisel/{prodId}")
	@ResponseBody
	public String DeleteSpecificProduct(@PathVariable("prodId") int prodId) {
		return aiselservice.DeleteSpecificProduct(prodId);		
	}
}
