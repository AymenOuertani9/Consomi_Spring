package tn.esprit.pidev.serviceInterface;

import java.util.List;

import tn.esprit.pidev.entities.RequestLeave;
import tn.esprit.pidev.entities.RequestLeaveEtat;


public interface RequestLeaveInterface {
	
	public void saveRequestLeave(RequestLeave requestLeave);
	public RequestLeave updateRequestLeave(RequestLeave requestLeave);
	public void deleteRequestLeave(int id);
	public List<RequestLeave> getAllRequestLeave();
	public void updateEtat( int id , RequestLeaveEtat etat );


}
