package tn.esprit.pidev.service;

import java.util.ArrayList;
import java.util.List;

import tn.esprit.pidev.entities.Stock;
import tn.esprit.pidev.entities.supplying;

public interface ISupplyingService {
	
	String AddSupplying(supplying supplyin);
	String FromSupplyingtoStock();
	List<supplying> suppThisMonth();
	ArrayList Mexpeses();

}
