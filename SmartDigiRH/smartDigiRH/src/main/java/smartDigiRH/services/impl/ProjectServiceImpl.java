package smartDigiRH.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import smartDigiRH.entities.Employee;
import smartDigiRH.entities.Project;
import smartDigiRH.entities.User;
import smartDigiRH.repositories.EmployeeRepository;
import smartDigiRH.repositories.ProjectRepository;
import smartDigiRH.services.AppService;



@Service
@Transactional
public class ProjectServiceImpl implements AppService<Project> {
	
	
	@Autowired
	ProjectRepository repository;
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public void save(Project project) {
repository.save(project);		
	}
	
	@Override
	public void update(Project project) {
		repository.save(project);		
	}


	@Override
	public void delete(Long id) {
repository.deleteById(id);	
	}
 
	@Override
	public Project findById(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public List<Project> getAll() {
		return (List<Project>)repository.findAll();
	}

	@Override
	public User loadUserByUserName(String username) {
		return null;
	}

	public Project findByTitle(String title) {
		return repository.findByTitle(title);
}
	
	

	
}