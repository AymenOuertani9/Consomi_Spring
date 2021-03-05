package tn.esprit.pidev.service;

import tn.esprit.pidev.entities.Aisel;

public interface IAiselService {
	
	int AddAisel(Aisel aisel);
	String Mod_Aisel(int aiselId, Aisel aisel);
	String Del_Aisel(int aiselId);

}
