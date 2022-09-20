package smartDigiRH.services;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import smartDigiRH.entities.User;



public interface AccountService  {
	
	
	User loadUserByUserName (String username);
	
}
