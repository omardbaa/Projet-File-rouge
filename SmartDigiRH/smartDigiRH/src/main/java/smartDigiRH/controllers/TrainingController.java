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
import smartDigiRH.entities.Training;
import smartDigiRH.services.impl.EmployeeServiceImpl;
import smartDigiRH.services.impl.TrainingServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/training")

public class TrainingController {


	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;


	@Autowired
	private TrainingServiceImpl service;
	
	
	
	
	@GetMapping ("/")
	
	public String Home () {
		return ("<h1>Welcom<h1>");
	}
	
	
	
//	Create New Training
//	@PreAuthorize("ADMIN")
	@PostMapping
public Training save(@RequestBody Training training  ) {
		service.save(training);
		return training;
	}
	
	//Update Training
	@PutMapping("/{id}")
public ResponseEntity<Training> update(@PathVariable Long id, @RequestBody Training training  ) {
		
		Training newTraining = service.findById(id);
		
		newTraining.setTitle(training.getTitle());
		newTraining.setDescription(training.getDescription());
		newTraining.setStartDate(training.getStartDate());
		newTraining.setEndDate(training.getEndDate());
		newTraining.setType(training.getType());
		newTraining.setActive(training.getActive());
		service.save(newTraining);
		return new ResponseEntity<>(newTraining, HttpStatus.OK);
	}
	
	
//	Get All Trainings
//	@PostAuthorize("hasAuthority('ADMIN')")
	@GetMapping
	public ResponseEntity<List<Training>> getAll(){
		List<Training> trainings = service.getAll();
		return new ResponseEntity<>(trainings, HttpStatus.OK);
		
	}
	
	
	
	@GetMapping("/{id}/employees")
	public List<Employee> getAllEmployeeOfTraining(@PathVariable("id") Long trainingId) {

		return this.employeeServiceImpl.getAllEmployeeOfTraining(trainingId);

	}


	//Get Training by ID 
	@GetMapping("/{id}")
	public ResponseEntity <Training> findById(@PathVariable ("id") Long id) {
		Training training = service.findById(id);
		return new ResponseEntity<>(training, HttpStatus.OK);
		
	}
//Delet Training
	@DeleteMapping("/{id}")
	public ResponseEntity< Map <String, Boolean>> delete(@PathVariable  Long id) {
		service.delete(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
}
