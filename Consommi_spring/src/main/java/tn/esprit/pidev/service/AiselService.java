package tn.esprit.pidev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.pidev.entities.Aisel;
import tn.esprit.pidev.repository.IAiselRepository;

@Service
public class AiselService implements IAiselService {
	
	@Autowired
	IAiselRepository aiselrepository;
	

	@Override
	public int AddAisel(Aisel aisel) {
		// TODO Auto-generated method stub
		aiselrepository.save(aisel);
		return aisel.getIdAisel();
		
	}

	@Override
	public String Mod_Aisel(int aiselId, Aisel aisel) {
		// TODO Auto-generated method stub
		Aisel aise=aiselrepository.findById(aiselId).orElse(null);
		aisel = aise;
		aiselrepository.save(aisel);
		return "Aisel Updated";
	}

	@Override
	public String Del_Aisel(int aiselId) {
		// TODO Auto-generated method stub
		Aisel aise=aiselrepository.findById(aiselId).orElse(null);
		aiselrepository.delete(aise);
		return "Aisel Deleted";
	}
	
	

}
