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
import smartDigiRH.entities.Meeting;
import smartDigiRH.services.impl.EmployeeServiceImpl;
import smartDigiRH.services.impl.MeetingServiceImpl;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/meeting")
@CrossOrigin(origins = "http://localhost:4200")
public class MeetingController {



	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;


	@Autowired
	private MeetingServiceImpl service;
	
	
	
	
	@GetMapping ("/")
	
	public String Home () {
		return ("<h1>Welcom<h1>");
	}
	
	
	
//	Create New Meeting
//	@PreAuthorize("ADMIN")
	@PostMapping
public Meeting save(@RequestBody Meeting meeting  ) {
		service.save(meeting);
		return meeting;
	}
	
	//Update Meeting
	@PutMapping("/{id}")
public ResponseEntity<Meeting> update(@PathVariable Long id, @RequestBody Meeting meeting  ) {
		
		Meeting newMeeting = service.findById(id);
		
		newMeeting.setTitle(meeting.getTitle());
		newMeeting.setDescription(meeting.getDescription());
		newMeeting.setMeetingDate(meeting.getMeetingDate());
		newMeeting.setType(meeting.getType());
		service.save(newMeeting);
		return new ResponseEntity<>(newMeeting, HttpStatus.OK);
	}
	
	
//	Get All Meetings
//	@PostAuthorize("hasAuthority('ADMIN')")
	@GetMapping
	public ResponseEntity<List<Meeting>> getAll(){
		List<Meeting> meetings = service.getAll();
		return new ResponseEntity<>(meetings, HttpStatus.OK);
		
	}
	

	@GetMapping("/{id}/employees")
	public List<Employee> getAllEmployeeOfMeeting(@PathVariable("id") Long meetingId) {

		return this.employeeServiceImpl.getAllEmployeeOfMeeting(meetingId);

	}

	//Get Meeting by ID 
	@GetMapping("/{id}")
	public ResponseEntity <Meeting> findById(@PathVariable ("id") Long id) {
		Meeting meeting = service.findById(id);
		return new ResponseEntity<>(meeting, HttpStatus.OK);
		
	}
//Delet Meeting
	@DeleteMapping("/{id}")
	public ResponseEntity< Map <String, Boolean>> delete(@PathVariable  Long id) {
		service.delete(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
}