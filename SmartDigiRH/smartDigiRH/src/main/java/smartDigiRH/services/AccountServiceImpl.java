package smartDigiRH.services;

import org.springframework.beans.factory.annotation.Autowired;

import smartDigiRH.entities.User;
import smartDigiRH.repositories.AppRoleRepository;
import smartDigiRH.repositories.UserRepository;


public class AccountServiceImpl implements AccountService {
	
	@Autowired
	 UserRepository userRepository;
	
	@Autowired
	 AppRoleRepository repositroy;

	@Override
	public User loadUserByUserName(String username) {
		return userRepository.findByUsername(username);
	}

	
	
	



	
	

}
