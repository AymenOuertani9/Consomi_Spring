package tn.esprit.pidev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.pidev.entities.Bill;
import tn.esprit.pidev.entities.User;
import tn.esprit.pidev.repository.IBillRepository;
import tn.esprit.pidev.repository.IUserRepository;

@Service
public class BillService implements IBillService{
@Autowired
IBillRepository facrep;
@Autowired
IUserRepository userep;

	@Override
	public List<Bill> getBillByIduser(int iduser) {
		
		return facrep.getbillByIduser(iduser);
	}

	@Override
	public Bill getBillById(int billId) {
		
		return facrep.findById(billId).get();
	}

	@Override
	public Bill AjouterFacture(Bill bill) {
		
		return facrep.save(bill);
	}

	@Override
	public double getBillTotalById(int billId) {
	Bill b =facrep.findById(billId).get();
		return b.getTotalfinal();
	}

	@Override
	public void deleteBillById(int billId) {
		
		facrep.deleteById( billId);
		
	}

	@Override
	public List<Bill> getAllBill() {
	
		return facrep.findAll();
	}

	@Override
	public int addOrUpdateBill(Bill bill) {
		facrep.save(bill);
		return bill.getIdBill();
	}

	@Override
	public void ajouteretaffecterUserABill(Bill bill, int userId) {
	User user = userep.findById(userId).get();	
	bill.setUser(user);
	facrep.save(bill);
		
	}

}
