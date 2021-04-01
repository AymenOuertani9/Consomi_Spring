package tn.esprit.pidev.serviceInterface;

import java.util.List;

import tn.esprit.pidev.entities.UserConsomi;


public interface UserInterface {
	
	public void saveUser(UserConsomi user);
	public UserConsomi updateUser(UserConsomi user);
	public void deleteUser(int id);
	public List<UserConsomi> getAllUser();
	UserConsomi getUser(int id);

}
