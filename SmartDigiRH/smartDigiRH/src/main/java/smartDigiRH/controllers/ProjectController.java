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
import smartDigiRH.entities.Project;
import smartDigiRH.services.impl.EmployeeServiceImpl;
import smartDigiRH.services.impl.ProjectServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/project")

public class ProjectController {

	@Autowired
	EmployeeServiceImpl employeeServiceImpl;

	@Autowired
	ProjectServiceImpl service;

	@GetMapping("/")

	public String Home() {
		return ("<h1>Welcom<h1>");
	}

//	Create New Project
//	@PreAuthorize("ADMIN")
	@PostMapping
	public Project save(@RequestBody Project Project) {
		service.save(Project);
		return Project;
	}

	// Update Project
	@PutMapping("/{id}")
	public ResponseEntity<Project> update(@PathVariable Long id, @RequestBody Project project) {

		Project newProject = service.findById(id);

		newProject.setTitle(project.getTitle());
		newProject.setDescription(project.getDescription());
		newProject.setStartDate(project.getStartDate());
		newProject.setEndDate(project.getEndDate());
		newProject.setStatus(project.getStatus());
		service.save(newProject);
		return new ResponseEntity<>(newProject, HttpStatus.OK);
	}

//	Get All Projects
//	@PostAuthorize("hasAuthority('ADMIN')")
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping
	public ResponseEntity<List<Project>> getAll() {
		List<Project> projects = service.getAll();
		return new ResponseEntity<>(projects, HttpStatus.OK);

	}

	// getAllEmployeeOfProject

	@GetMapping("/{id}/employees")
	public List<Employee> getAllEmployeeOfProject(@PathVariable("id") Long projectId) {

		return this.employeeServiceImpl.getAllEmployeeOfProject(projectId);

	}

//	 Get Project by ID
	@GetMapping("/{id}")
	public ResponseEntity<Project> findById(@PathVariable("id") Long id) {
		Project project = service.findById(id);
		return new ResponseEntity<>(project, HttpStatus.OK);

	}

//Delet Project
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> delete(@PathVariable Long id) {
		service.delete(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}