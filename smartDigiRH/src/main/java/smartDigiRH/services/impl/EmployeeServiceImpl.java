package smartDigiRH.services.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import smartDigiRH.entities.Employee;
import smartDigiRH.entities.User;
import smartDigiRH.repositories.AppRoleRepository;
import smartDigiRH.repositories.EmployeeRepository;
import smartDigiRH.services.AppService;

@Service
@Transactional
public class EmployeeServiceImpl implements AppService <Employee> {
	
  
	@Autowired
	private PasswordEncoder passwordEncoder;

    @Autowired 
    private AppRoleRepository roleRepo;
  
	
	@Autowired
	private EmployeeRepository EmployeeRepository;
	
	@Override
	public void save(Employee Employee) {
		String password = Employee.getPassword();
		Employee.setPassword(passwordEncoder.encode(password));
		EmployeeRepository.save(Employee);		
	}
	
	@Override
	public void update(Employee Employee) {
		EmployeeRepository.save(Employee);		
	}


	@Override
	public void delete(Long id) {
		EmployeeRepository.deleteById(id);	
	}
 
	@Override
	public Employee findById(Long id) {
		return EmployeeRepository.findById(id).get();
	}
	
	

	@Override
	public List<Employee> getAll() {
		return (List<Employee>)EmployeeRepository.findAll();
	}
	

	public User loadEmployeeByUserName(String username) {
		return EmployeeRepository.findByUsername(username);
	}

	@Override
	public User loadUserByUserName(String username) {
		return EmployeeRepository.findByUsername(username);
	}

	
public Employee registerDefaultEmployee(Employee Employee) {
	String password = Employee.getPassword();
	Employee.setPassword(passwordEncoder.encode(password));
    	
        Employee.setAppRoles(Arrays.asList(roleRepo.findByRoleName("EMPLOYEE")));
        return EmployeeRepository.save(Employee);
    }


	
	

}

