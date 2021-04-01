package tn.esprit.pidev.service;

import java.util.List;

import tn.esprit.pidev.entities.User;

public interface IUserService {
	public User getUserById(int userId);

	public List<User> getAll();
}
