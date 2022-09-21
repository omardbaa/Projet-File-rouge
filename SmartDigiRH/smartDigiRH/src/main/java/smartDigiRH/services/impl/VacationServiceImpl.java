package smartDigiRH.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import smartDigiRH.entities.User;
import smartDigiRH.entities.Vacation;
import smartDigiRH.repositories.VacationRepository;
import smartDigiRH.services.AppService;



@Service
@Transactional
public class VacationServiceImpl implements AppService<Vacation> {

	
	
	@Autowired
	VacationRepository repository;
	
	@Override
	public void save(Vacation Vacation) {
repository.save(Vacation);		
	}
	
	@Override
	public void update(Vacation Vacation) {
		repository.save(Vacation);		
	}


	@Override
	public void delete(Long id) {
repository.deleteById(id);	
	}
 
	@Override
	public Vacation findById(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public List<Vacation> getAll() {
		return (List<Vacation>)repository.findAll();
	}

	@Override
	public User loadUserByUserName(String username) {
	
		return null;
	}

}
