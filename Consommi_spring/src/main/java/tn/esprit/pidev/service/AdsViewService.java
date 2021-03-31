package tn.esprit.pidev.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import tn.esprit.pidev.entities.Ads;
import tn.esprit.pidev.entities.AdsView;
import tn.esprit.pidev.entities.User;
import tn.esprit.pidev.repository.IAdsRepository;
import tn.esprit.pidev.repository.IAdsViewRepository;
import tn.esprit.pidev.repository.IProductRepository;
import tn.esprit.pidev.repository.IUserRepository;

@Service
public class AdsViewService implements IAdsViewService {
	
	@Autowired
	IAdsViewRepository adsviewrepository;
	
	@Autowired
	IProductRepository productrepository;
	
	@Autowired
	IUserRepository userrepository;
	
	@Autowired
	IAdsRepository adsrepository;

	@Override
	public int AddAdsView(AdsView adsview) {
		// TODO Auto-generated method stub
		adsviewrepository.save(adsview);
		return adsview.getIdAdsView();
	}

	@Override
	public List<AdsView> getAllAdsView() {
		// TODO Auto-generated method stub
		return (List<AdsView>)adsviewrepository.findAll();
	}

	@Override
	@Scheduled(cron="0 0 * * * ?")
	public void AdsViewToday() {
		adsviewrepository.findAll();		
	}

	@Override
	public void Addview(int AdId, int userId) {
		// TODO Auto-generated method stub
		Ads ad=adsrepository.findById(AdId).orElse(null);
		if(ad!=null){
			AdsView adview=(AdsView) adsviewrepository.getAdsViewByAds(ad);
			adview.setTotal_Num(adview.getTotal_Num()+1);
			if(adview!=null){	
				User user=userrepository.findById(userId).orElse(null);
				List<Integer> ageList=adview.getAge();
				ageList.add(user.getAge());;
				adview.setAge(ageList);
				if(user.getGendre()=="homme"){		
					adview.setTotal_man(adview.getTotal_man()+1);
					}
				else{
					adview.setTotal_man(adview.getTotal_Woman()+1);
					}
				}
			adsviewrepository.save(adview);
			}
		}
	
	@Scheduled(cron="0 0 * * * ?")
	@Override
	public void finalStats(int AdsId) {	
		Ads ad=adsrepository.findById(AdsId).orElse(null);
		if(ad.getFinishDate()==new Date()){
		AdsView adview=(AdsView) adsviewrepository.getAdsViewByAds(ad);
		if((ad!=null)&&(adview !=null)){
			
			int tar=ad.getTargetView_tot();
			float real= adview.getTotal_Num();
			List<Integer> ages=adview.getAge();
			double avg=ages.stream().mapToInt(val -> val).average().orElse(0.0);
			ArrayList eval=new ArrayList();
			eval.add(tar);
			eval.add(real);
			eval.add(avg);
			float per=(real/tar)*100;
			eval.add(per);
			if(per>=80){
				eval.add("Successful Ad");
			} else {
				eval.add("The ad has failed");
			}
		}
		}
	}
	}
