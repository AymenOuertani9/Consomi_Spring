package tn.esprit.pidev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.pidev.entities.UserConsomi;
import tn.esprit.pidev.repsitory.UserRepository;
import tn.esprit.pidev.serviceInterface.UserInterface;

@Service
public class UserService implements UserInterface {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void saveUser(UserConsomi user) {
		userRepository.save(user);	
	}
	
	@Override
	public UserConsomi getUser(int id) {
	return userRepository.findById(id).get();
	}
	
	@Override
	public UserConsomi updateUser(UserConsomi user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public void deleteUser(int id) {
		userRepository.deleteById(id);
		
	}

	@Override
	public List<UserConsomi> getAllUser() {
		return (List<UserConsomi>) userRepository.findAll();
	}
	
	
	

}
