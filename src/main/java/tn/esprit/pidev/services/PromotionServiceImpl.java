package tn.esprit.pidev.services;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.pidev.entities.Product;
import tn.esprit.pidev.entities.Promotion;
import tn.esprit.pidev.repositories.IProductRepository;
import tn.esprit.pidev.repositories.IPromotionRepository;

@Service
public class PromotionServiceImpl implements IPromotionService{
	@Autowired
	IPromotionRepository iPromotionRepository;
    @Autowired
    IProductRepository iProductRepository;
    /******************Creating add method that insert Promotion into database*************/
	@Override
	public int addPromos(Promotion p) {
		iPromotionRepository.save(p);
		return p.getIdPromotion();
	}
	
	/******************Creating update method that upgrade promotion from database*************/
	
	@Override
	public void updatePromos(Promotion p, int idPromotion) {
		Promotion promos = iPromotionRepository.findById(idPromotion).get();
		promos.setLibelle(p.getLibelle());
		promos.setDescription(p.getDescription());
		promos.setStartDate(p.getStartDate());
		promos.setEndDate(p.getEndDate());
		promos.setPercentage(p.getPercentage());
		iPromotionRepository.save(promos);
		
	}
	/******************Creating deleting method that remove promotion by id from database*************/

	@Override
	public int deletePromos(int idPromotion) {
		Promotion promos = iPromotionRepository.findById(idPromotion).get();
		iPromotionRepository.delete(promos);
		return idPromotion;
	}
	
	/***************Creating getByid method that retrieve promotions detail from database***********/
    @Override
	public Promotion getPromosById(int idPromotion) {
		return iPromotionRepository.findById(idPromotion).get();
	}
  /*******************creating getAll method that retrieve all promotions  from database*************/
	@Override
	public List<Promotion> getAllPromos() {
		List<Promotion>promotions = new ArrayList<>();
		iPromotionRepository.findAll().forEach(p -> promotions.add(p));
		return promotions;
	}
	/***************Creating getByDate method that retrieve promotions detail from database***********/
    @Override
	public List<Promotion> getPromosByDate() {
		List<Promotion> promotions = iPromotionRepository.getCurrentPromotions();
		List<Promotion>currentPromotions = new ArrayList<>();
	    for(Promotion p : promotions){
			
			currentPromotions.add(p);
		}
		return currentPromotions;
	}
    /***************Affected ProductPromotion ***********/
	@Override
	public void affecterProductPromotion(int idproduct,int idpromotion) {
		Product product = iProductRepository.findById(idproduct).get();
		Promotion promotion = iPromotionRepository.findById(idpromotion).get();
		promotion.setProduct(product);
		iPromotionRepository.save(promotion);

	}

}
