package smartDigiRH.controllers;

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

import smartDigiRH.entities.Employee;
import smartDigiRH.entities.Vacation;
import smartDigiRH.services.impl.EmployeeServiceImpl;
import smartDigiRH.services.impl.VacationServiceImpl;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/vacation")
@CrossOrigin(origins = "http://localhost:4200")
public class VacationController {



@Autowired
private EmployeeServiceImpl employeeServiceImpl;

	@Autowired
	private VacationServiceImpl service;
	
	
	
	
	@GetMapping ("/")
	
	public String Home () {
		return ("<h1>Welcom<h1>");
	}
	
	
	
//	Create New Vacation
//	@PreAuthorize("ADMIN")
	@PostMapping
public Vacation save(@RequestBody Vacation vacation  ) {
		service.save(vacation);
		return vacation;
	}
	
	//Update Vacation
	@PutMapping("/{id}")
public ResponseEntity<Vacation> update(@PathVariable Long id, @RequestBody Vacation vacation  ) {
		
		Vacation newVacation = service.findById(id);
		
	
		newVacation.setType(vacation.getType());
		newVacation.setPeriod(vacation.getPeriod());
		newVacation.setStartDate(vacation.getStartDate());
		newVacation.setEndDate(vacation.getEndDate());

		service.save(newVacation);
		return new ResponseEntity<>(newVacation, HttpStatus.OK);
	}
	
	
//	Get All Vacations
//	@PostAuthorize("hasAuthority('ADMIN')")
	@GetMapping
	public ResponseEntity<List<Vacation>> getAll(){
		List<Vacation> vacations = service.getAll();
		return new ResponseEntity<>(vacations, HttpStatus.OK);
		
	}
	

	
	
	@GetMapping("/{id}/employees")
	public List<Employee> getAllEmployeeOfVacation(@PathVariable("id") Long vacationId) {

		return this.employeeServiceImpl.getAllEmployeeOfVacation(vacationId);

	}

	//Get Vacation by ID 
	@GetMapping("/{id}")
	public ResponseEntity <Vacation> findById(@PathVariable ("id") Long id) {
		Vacation vacation = service.findById(id);
		return new ResponseEntity<>(vacation, HttpStatus.OK);
		
	}
//Delet Vacation
	@DeleteMapping("/{id}")
	public ResponseEntity< Map <String, Boolean>> delete(@PathVariable  Long id) {
		service.delete(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
}