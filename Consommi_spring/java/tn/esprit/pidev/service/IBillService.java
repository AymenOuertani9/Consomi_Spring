package tn.esprit.pidev.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;

import tn.esprit.pidev.entities.Bill;
import tn.esprit.pidev.entities.TypeFacture;
import tn.esprit.pidev.entities.User;

public interface IBillService {
	public List<Bill>getBillByIduser(int iduser);
	public Bill getBillByuser(int iduser  ,int idb);
	public List<Bill> getBillBydatereglement(Date datereglmt);
	public List<Bill> getBillBydatebill(Date datebill);
	public List<Bill> getBillBytotalfinalsup();
	public Bill getBillById(int billId);
	public List<Bill>getBillByIdorder(int idorder);
	public String AddBill(Bill bill);
	public double getBillTotalById(int billId );
	public String deleteBillById(int billId);
	public List<Bill> getAllBill();
	public String assignUserABill(int billId, int userId);
	public String assignOrderABill(int billId, int orderId);
	public String addOrUpdateBill(Bill bill);
	public String addandassignOrderABill(Bill bill, int orderId);
	public String addandassignUserABill(Bill bill, int userId);
	public Bill find(int numero);
	//les prix d'achats
	public Double PricesPurchasesProducts();
	//nbr de factures
	public long count();
	public List<Bill> findBYtype(TypeFacture typeofbill);
	//la moyenne de facture par jour 
	public List<Object[]> getMoyenBillJour( int idcommand,Integer a, Integer m, Integer j);
	//recupérer les factures entre d1 et d2 
	public List<Bill> getallbillbetwendate( Date d1,Date d2);
	//la moyenne de facture par mois 
	public List<Object[]> getMoyenBillMonth(int idcommand,Integer a,Integer m);
	//la moyenne de facture par annee
	public List<Object[]> getMoyenBillyear(int idcommand,Integer a);
	public Double prixAchatsProduitsbetwend1andd2(Date d1,Date d2);
	public double gettotalbill(int idu,int idc,int idb ,int deliveryid);
	
}
