package smartDigiRH.controllers;


import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import smartDigiRH.entities.Employee;
import smartDigiRH.entities.Meeting;
import smartDigiRH.entities.Training;
import smartDigiRH.services.impl.EmployeeServiceImpl;
import smartDigiRH.services.impl.MeetingServiceImpl;
import smartDigiRH.services.impl.TrainingServiceImpl;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/user/employee")


public class EmployeeController {
	
	
	
	@Autowired 
	TrainingServiceImpl trainingServiceImpl;
	@Autowired
	private EmployeeServiceImpl service;

public EmployeeController(EmployeeServiceImpl service){
	this.service = service;
}
	
	@GetMapping ("/")
	
	public String Home () {
		return ("<h1>Welcom to Smart Digital RH<h1>");
	}
	
	

	@PostMapping
	@CrossOrigin(origins = "http://localhost:4200")
	public String register(@RequestBody Employee employee) {
		System.out.println(employee);
		service.registerDefaultEmployee(employee);
		return "register success";
	}


	@PutMapping("/{id}")
	public ResponseEntity<Employee> update(@PathVariable Long id , @RequestBody Employee employee ) {
		
		Employee newEmployee = service.findById(id);
		
		newEmployee.setFirstName(employee.getFirstName());
		newEmployee.setLastName(employee.getLastName());
		newEmployee.setUsername(employee.getUsername());
		newEmployee.setEmail(employee.getEmail());
		newEmployee.setPassword(employee.getPassword());
		newEmployee.setPhone(employee.getPhone());
		newEmployee.setType(employee.getType());
		newEmployee.setPhoto(employee.getPhoto());
		newEmployee.setAddress(employee.getAddress());
		newEmployee.setBirthday(employee.getBirthday());
		newEmployee.setCountry(employee.getCountry());
		newEmployee.setCity(employee.getCity());
		newEmployee.setActive(employee.getActive());
		newEmployee.setPost(employee.getPost());
		newEmployee.setContrat(employee.getContrat());
		newEmployee.setSalary(employee.getSalary());
		
		service.save(newEmployee);
		return new ResponseEntity<>(newEmployee, HttpStatus.OK);
	}
	
	//Get All Employees
	@GetMapping
//	@CrossOrigin(origins = "http://localhost:4200")
//	@PostAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity <List<Employee>> getAll(){
		List<Employee> Employees = service.getAll();
		return new ResponseEntity<>(Employees, HttpStatus.OK);
		
	}
	
	
	@GetMapping("/{id}")
	
	public ResponseEntity <Employee> findById(@PathVariable ("id") Long id) {
		Employee Employee = service.findById(id);
		return new ResponseEntity<>(Employee, HttpStatus.OK);
		
	}

	
	@DeleteMapping("/{id}")
	public ResponseEntity< Map <String, Boolean>> delete(@PathVariable  Long id) {
		Employee Employees = service.findById(id);
		service.delete(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
	
	
	
	
	// Assing Meeting To Employee
	@PostMapping(path = "/consult")
	public Collection<Training> AssingMeetingToEmployee(@RequestBody ConsultTraining cTraining) {

		Employee employee = (Employee) service.findById(cTraining.getUserId());
		Training training = trainingServiceImpl.findById(cTraining.getTrainingId());
		
		Collection<Training> trainings = employee.getTrainings();
		trainings.add(training);
		employee.setTrainings(trainings);
		service.save(employee);

		return employee.getTrainings();
	}

	
	

}

@Data
class ConsultTraining{
	private Long userId;
	private Long trainingId;
}