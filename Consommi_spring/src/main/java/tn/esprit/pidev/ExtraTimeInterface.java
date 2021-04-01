package tn.esprit.pidev.serviceInterface;

import java.util.List;

import tn.esprit.pidev.entities.ExtraTime;


public interface ExtraTimeInterface {
	
	public void saveExtraTime(ExtraTime extraTime);
	public void updateExtraTime(int id,  int nbrHour);
	public void deleteExtraTime(int id);
	public List<ExtraTime> getAllExtraTime();

}
