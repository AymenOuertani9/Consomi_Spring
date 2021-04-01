package tn.esprit.pidev.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import tn.esprit.pidev.entities.Bill;
import tn.esprit.pidev.entities.Command;
import tn.esprit.pidev.entities.Delivery;
import tn.esprit.pidev.entities.TypeFacture;
import tn.esprit.pidev.entities.User;
import tn.esprit.pidev.repository.IBillRepository;
import tn.esprit.pidev.repository.ICommandRepository;
import tn.esprit.pidev.repository.IDeliveryRepository;
import tn.esprit.pidev.repository.IUserRepository;

@Service
public class BillService implements IBillService{
@Autowired
IBillRepository facrep;
@Autowired
IUserRepository userep;
@Autowired
ICommandRepository comrep;
@Autowired
IDeliveryRepository delivrep;
//recover bill by iduser
	@Override
	public List<Bill> getBillByIduser(int iduser) {
		
		return facrep.getbillByIduser(iduser);
	}

	@Override
	public Bill getBillById(int billId) {
		
		return facrep.findById(billId).get();
	}

	@Override
	public String AddBill(Bill bill) {
		facrep.save(bill);
		return "the Bill is added successfully";
	}

	@Override
	public double getBillTotalById(int billId) {
	Bill b =facrep.findById(billId).get();
		return b.getTotalfinal();
	}

	@Override
	public String deleteBillById(int billId) {
		
		facrep.deleteById( billId);
		return "the Bill is deleted successfully";
		
	}

	@Override
	public List<Bill> getAllBill() {
	
		return facrep.findAll();
	}

	@Override
	public String addOrUpdateBill(Bill bill) {
		facrep.save(bill);
		return "the Bill is added or updated successfully";
	}

	@Override
	public String addandassignUserABill(Bill bill, int userId) {
	User user = userep.findById(userId).get();	
	bill.setUser(user);
	facrep.save(bill);
	return "the Bill is added and the user is assigned successfully";
		
	}

	@Override
	public Bill find(int numero) {
		
		return facrep.find(numero);
	}

	@Override
	public Double PricesPurchasesProducts() {
		
		return facrep.prixAchatsProduits();
	}

	@Override
	public String assignUserABill(int billId, int userId) {
		Bill bill =facrep.findById(billId).get();
		User user=userep.findById(userId).get();
		bill.setUser(user);
		facrep.save(bill);
		return " the user is assigned successfully";
	}

	@Override
	public String assignOrderABill(int billId, int orderId) {
		Bill bill =facrep.findById(billId).get();
		Command order =comrep.findById(orderId).get();
		bill.setCommand(order);
		facrep.save(bill);
		return " the order is assigned successfully";
	}

	@Override
	public String addandassignOrderABill(Bill bill, int orderId) {
		Command order =comrep.findById(orderId).get();
		bill.setCommand(order);
		bill.setTotalfinal(order.getAmountCommand());
		facrep.save(bill);
		return "the Bill is added and the order is assigned successfully";
			
	}

	@Override
	public List<Bill> getBillByIdorder(int idorder) {
		
		return facrep.getbillByIdorder(idorder);
	}

	@Override
	public long count() {
		
		return facrep.count();
	}

	public List<Object[]> getMoyenBillJour( int idcommand,Integer a,Integer m,Integer j){
		return facrep.getMoyenBillJour(idcommand, a, m, j);
	}

	@Override
	public List<Bill> findBYtype(TypeFacture typeofbill) {
		
		return facrep.findByTypeofbill(typeofbill);
	}

	@Override
	public List<Bill> getallbillbetwendate(Date d1, Date d2) {
		
		return facrep.getallbillbetwendate(d1, d2);
	}

	@Override
	public List<Object[]> getMoyenBillMonth(int idcommand, Integer a, Integer m) {
		
		return facrep.getMoyenBillMonth(idcommand, a, m);
	}

	@Override
	public List<Object[]> getMoyenBillyear(int idcommand, Integer a) {
		
		return facrep.getMoyenBillyear(idcommand, a);
	}

	@Override
	public List<Bill> getBillBydatereglement(Date datereglmt) {
		
		return facrep.findByDatereglement(datereglmt);
	}

	@Override
	public List<Bill> getBillBydatebill(Date datebill) {
		
		return facrep.findByDatebill(datebill);
	}

	@Override
	public List<Bill> getBillBytotalfinalsup() {
		
		return facrep.getBillBytotalfinalsup();
	}

	@Override
	public Double prixAchatsProduitsbetwend1andd2(Date d1, Date d2) {
		
		return facrep.prixAchatsProduitsbetwend1andd2(d1, d2);
	}

	public Bill findonebill(int idbill) {
		return facrep.getOne(idbill);
	}

	@Override
	public double gettotalbill(int iduser,int idc,int idb,int deliveryid) {
		Command c =  comrep.findById(idc).get();
		Bill b =facrep.findById(idb).get();
		Delivery delivery=delivrep.findById(deliveryid).get();
		List<User>users=new ArrayList<>();
		users.add(c.getUser());
		double HTVA=0;
		double TTC=0;
		for(User u:users) {
	   HTVA=facrep.gettotalbill(iduser)+delivery.getFraislivraison();
	   TTC=((HTVA*c.getTva())/100)+HTVA;
	    b.setTotalfinal(TTC);     
		}
		facrep.save(b);
		return TTC;
	}

	@Override
	public Bill getBillByuser(int iduser,int idb) {
		Bill b =facrep.findById(idb).get();
		List<User>users=new ArrayList<>();
		users.add(b.getUser());
		for(User u:users) {
		b= facrep.getOne(idb);
	}
	
return b;
}}
