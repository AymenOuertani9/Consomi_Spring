package tn.esprit.pidev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.pidev.entities.ExtraTime;
import tn.esprit.pidev.repsitory.ExtraTimeRepository;
import tn.esprit.pidev.serviceInterface.ExtraTimeInterface;

@Service
public class ExtraTimeService implements ExtraTimeInterface {

	@Autowired
	private ExtraTimeRepository extraTimeRepository;
	
	@Override
	public void saveExtraTime(ExtraTime extraTime) {
		extraTimeRepository.save(extraTime);

		
	}

	@Override
	public void updateExtraTime(int id,  int nbrHour) {
		extraTimeRepository.updateNbHour(id, nbrHour);
	}

	@Override
	public void deleteExtraTime(int id) {
		extraTimeRepository.deleteById(id);
		
	}

	@Override
	public List<ExtraTime> getAllExtraTime() {
		return (List<ExtraTime>) extraTimeRepository.findAll();
	}

}
