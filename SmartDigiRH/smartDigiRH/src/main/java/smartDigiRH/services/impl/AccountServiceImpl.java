package smartDigiRH.services.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import smartDigiRH.entities.AppRole;
import smartDigiRH.entities.Employee;
import smartDigiRH.entities.User;
import smartDigiRH.repositories.AppRoleRepository;
import smartDigiRH.repositories.EmployeeRepository;
import smartDigiRH.repositories.ProjectRepository;
import smartDigiRH.repositories.TrainingRepository;
import smartDigiRH.repositories.UserRepository;
import smartDigiRH.services.AppService;

@Service
@Transactional
public class AccountServiceImpl<ProjectEmployee> implements AppService<User> {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AppRoleRepository roleRepo;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private TrainingRepository trainingRepository;

	@Override
	public void save(User user) {
		String password = user.getPassword();
		user.setPassword(passwordEncoder.encode(password));
		userRepository.save(user);
	}

	@Override
	public void update(User user) {
		userRepository.save(user);
	}

	@Override
	public void delete(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public User findById(Long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public List<User> getAll() {
		return (List<User>) userRepository.findAll();
	}

	public User loadUserByUserName(String username) {
		return userRepository.findByUsername(username);
	}

	public void addRoleToUser(String username, String roleName) {
		User user = userRepository.findByUsername(username);
		if (user == null)
			throw new RuntimeException("User not found");
		AppRole appRole = roleRepo.findByRoleName(roleName);
		if (appRole == null)
			throw new RuntimeException("Role not found");
		user.getAppRoles().add(appRole);
		userRepository.save(user);

	}

	public void removeRoleToUser(String username, String roleName) {
		User user = userRepository.findByUsername(username);
		if (user == null)
			throw new RuntimeException("User not found");
		AppRole appRole = roleRepo.findByRoleName(roleName);
		if (appRole == null)
			throw new RuntimeException("Role not found");
		user.getAppRoles().remove(appRole);

	}

	public void save(AppRole appRole) {
		roleRepo.save(appRole);

	}

	public User registerDefaultUser(User user) {
		String password = user.getPassword();
	user.setPassword(passwordEncoder.encode(password));

		user.setAppRoles(Arrays.asList(roleRepo.findByRoleName("EMPLOYEE")));
		return userRepository.save(user);
	}


	

	
}