package tn.esprit.pidev.service;

import java.util.List;

import tn.esprit.pidev.entities.Aisel;

public interface IAiselService {
	
	Aisel AddAisel(Aisel aisel);
	String Mod_Aisel(int aiselId, Aisel aisel);
	String Del_Aisel(int aiselId);
	List<Aisel> GetAllAisel();
	Aisel AffectProdctToAisel(int cat,int aiselId);
	String AffecterSpecificProduct(int AiselId,int ProdId);
	String DeleteSpecificProduct(int ProdId);

}
