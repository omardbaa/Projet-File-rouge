package smartDigiRH.services.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import smartDigiRH.entities.Employee;
import smartDigiRH.entities.Meeting;
import smartDigiRH.entities.Project;
import smartDigiRH.entities.Training;
import smartDigiRH.entities.User;
import smartDigiRH.entities.Vacation;
import smartDigiRH.repositories.AppRoleRepository;
import smartDigiRH.repositories.EmployeeRepository;
import smartDigiRH.repositories.MeetingRepository;
import smartDigiRH.repositories.ProjectRepository;
import smartDigiRH.repositories.TrainingRepository;
import smartDigiRH.repositories.VacationRepository;
import smartDigiRH.services.AppService;

@Service
@Transactional
public class EmployeeServiceImpl implements AppService<Employee> {

	@Autowired
	private ProjectRepository repository;
	@Autowired
	private VacationRepository vacationRepository;
	
	@Autowired
	private TrainingRepository trainingRepository;
	
	@Autowired
	private MeetingRepository meetingRepository;
	
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
		return (List<Employee>) EmployeeRepository.findAll();
	}

	public User loadEmployeeByUserName(String username) {
		return EmployeeRepository.findByUsername(username);
	}

	@Override
	public User loadUserByUserName(String username) {
		return EmployeeRepository.findByUsername(username);
	}
	
	
	
	
	
	

	public Employee registerDefaultEmployee(Employee Employee) {

		String username = Employee.getUsername();
		User user = EmployeeRepository.findByUsername(username);
		if (user == null) {

			String password = Employee.getPassword();
			Employee.setPassword(passwordEncoder.encode(password));

			Employee.setAppRoles(Arrays.asList(roleRepo.findByRoleName("EMPLOYEE")));
			return EmployeeRepository.save(Employee);
		} else {

			throw new RuntimeException("Username invalid");
		}
	}

	//getAllEmployeeOfProject
	public List <Employee> getAllEmployeeOfProject(Long projectId){
		
		Project project = this.repository.findByProjectId(projectId);
		
		List <Employee> employees = (List <Employee>)project.getEmployees();
		return employees;
		
	}
	
	
	
	//getAllEmployeeOfVacation
	public List <Employee> getAllEmployeeOfVacation(Long vacationId){
		
		Vacation vacation = this.vacationRepository.findByVacationId(vacationId);
		
		List <Employee> employees = (List <Employee>)vacation.getEmployees();
		return employees;
		
	}
	
	
	
	//getAllEmployeeOfTraining
	public List <Employee> getAllEmployeeOfTraining(Long trainingId){
		
		Training training = this.trainingRepository.findByTrainingId(trainingId);
		
		List <Employee> employees = (List <Employee>)training.getEmployees();
		return employees;
		
	}
	
	
	
	//getAllEmployeeOfMeeting
	public List <Employee> getAllEmployeeOfMeeting(Long meetingId){
		
		Meeting meeting = this.meetingRepository.findByMeetingId(meetingId);
		
		List <Employee> employees = (List <Employee>)meeting.getEmployees();
		return employees;
		
	}


}