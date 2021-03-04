package tn.esprit.pidev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.pidev.entities.User;
import tn.esprit.pidev.repository.IUserRepository;
@Service
public class UserService implements IUserService{
@Autowired
IUserRepository userep;
	@Override
	public User getUserById(int userId) {
	
		return userep.findById(userId).orElse(null);
	}

}
