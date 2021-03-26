package tn.esprit.pidev.services;

import java.util.List;

import tn.esprit.pidev.entities.Chat;
import tn.esprit.pidev.entities.Role;
import tn.esprit.pidev.entities.UserConsomi;

public interface IUserService {
	// public UserConsomi saveUser(UserConsomi user);
	// public User ajouterUser(String userName ,String password, String confirmedPassword);
	 public Role save(Role role);
	 public UserConsomi loadUserByUsername(String username);
	 public void addRoleToUser(String userName,String role);
	 public UserConsomi findById(int User_id);
	 public String saveUser(UserConsomi user);
	 public String sendMsg(Chat chat, int idSender, int idRecipient);
	 public List<String> getMsg(int idSender, int idRecipient);
	 public void notifyFrontend(final String message);
	 //public String confirmToken(String token) ;



}
