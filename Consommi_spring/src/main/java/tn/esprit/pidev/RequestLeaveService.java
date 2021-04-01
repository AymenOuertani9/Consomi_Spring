package tn.esprit.pidev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.pidev.entities.RequestLeave;
import tn.esprit.pidev.entities.RequestLeaveEtat;
import tn.esprit.pidev.repsitory.RequestLeaveRepository;
import tn.esprit.pidev.serviceInterface.RequestLeaveInterface;



@Service
public class RequestLeaveService implements RequestLeaveInterface {

	@Autowired
	private RequestLeaveRepository requestLeaveRepository;
	
	/***********************************************************************************************************************/
	@Override
	public void saveRequestLeave(RequestLeave requestLeave ) {
	
		requestLeaveRepository.save(requestLeave);
		
	}

	/***********************************************************************************************************************/

	@Override
	public RequestLeave updateRequestLeave(RequestLeave requestLeave) {
		
		return requestLeaveRepository.save(requestLeave);
	}
	
	/***********************************************************************************************************************/
	
	@Override
	public void deleteRequestLeave(int id) {
		
		requestLeaveRepository.deleteById(id);
		
	}
	
	/***********************************************************************************************************************/

	@Override
	public List<RequestLeave> getAllRequestLeave() {
		
		return (List<RequestLeave>) requestLeaveRepository.findAll();
	}

	/***********************************************************************************************************************/

	public void updateEtat( int id , RequestLeaveEtat etat ){
		
		requestLeaveRepository.updateEtat(id, etat);
		
	}

}
