package tn.esprit.pidev.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import tn.esprit.pidev.entities.Bill;
import tn.esprit.pidev.entities.User;

public interface IBillService {
	public List<Bill>getBillByIduser(int iduser);
	public Bill getBillById(int billId);
	
	public Bill AjouterFacture(Bill bill);
	public double getBillTotalById(int billId );
	public void deleteBillById(int billId);
	public List<Bill> getAllBill();
	
	public int addOrUpdateBill(Bill bill);
	
	public void ajouteretaffecterUserABill(Bill bill, int userId);
	public Bill find(int numero);
	public Double prixAchatsProduits();

	//ajouter count numfac
	
}
