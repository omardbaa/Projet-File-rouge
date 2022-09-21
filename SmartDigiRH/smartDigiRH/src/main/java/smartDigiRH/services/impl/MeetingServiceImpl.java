package smartDigiRH.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import smartDigiRH.entities.Meeting;
import smartDigiRH.entities.User;
import smartDigiRH.repositories.MeetingRepository;
import smartDigiRH.services.AppService;



@Service
@Transactional
public class MeetingServiceImpl implements AppService<Meeting> {
	
	
	@Autowired
	MeetingRepository repository;
	
	@Override
	public void save(Meeting Meeting) {
repository.save(Meeting);		
	}
	
	@Override
	public void update(Meeting Meeting) {
		repository.save(Meeting);		
	}


	@Override
	public void delete(Long id) {
repository.deleteById(id);	
	}
 
	@Override
	public Meeting findById(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public List<Meeting> getAll() {
		return (List<Meeting>)repository.findAll();
	}

	@Override
	public User loadUserByUserName(String username) {
	
		return null;
	}
	

}


