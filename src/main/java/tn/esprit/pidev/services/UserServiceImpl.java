package tn.esprit.pidev.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.pidev.entities.User;
import tn.esprit.pidev.repositories.UserRepository;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	UserRepository userrep;
	
	@Override
	public int ajouterUser(User user) {

		userrep.save(user);
		return user.getIduser();	}
	

}
