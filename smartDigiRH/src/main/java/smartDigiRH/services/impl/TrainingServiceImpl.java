package smartDigiRH.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import smartDigiRH.entities.Training;
import smartDigiRH.entities.User;
import smartDigiRH.repositories.TrainingRepository;
import smartDigiRH.services.AppService;



@Service
@Transactional
public class TrainingServiceImpl implements AppService<Training>{

	
	
	@Autowired
	TrainingRepository repository;
	
	@Override
	public void save(Training training) {
repository.save(training);		
	}
	
	@Override
	public void update(Training training) {
		repository.save(training);		
	}


	@Override
	public void delete(Long id) {
repository.deleteById(id);	
	}
 
	@Override
	public Training findById(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public List<Training> getAll() {
		return (List<Training>)repository.findAll();
	}

	@Override
	public User loadUserByUserName(String username) {
	
		return null;
	}

}
