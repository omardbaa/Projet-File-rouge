package smartDigiRH.controllers;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;

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
import smartDigiRH.entities.AppRole;
import smartDigiRH.entities.Employee;
import smartDigiRH.entities.Meeting;
import smartDigiRH.entities.Project;
import smartDigiRH.entities.Training;
import smartDigiRH.entities.User;
import smartDigiRH.security.JWTUtil;
import smartDigiRH.services.impl.AccountServiceImpl;
import smartDigiRH.services.impl.MeetingServiceImpl;
import smartDigiRH.services.impl.ProjectServiceImpl;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/user")
@CrossOrigin(origins = "http://localhost:4200")

public class AccountController {
	@Autowired
	private AccountServiceImpl service;
	@Autowired
	private ProjectServiceImpl projectService;
	
	@Autowired
	private MeetingServiceImpl meetingService;

	public AccountController(AccountServiceImpl service) {
		this.service = service;
	}

	@GetMapping("/")

	public String Home() {
		return ("<h1>Welcom to Smart Digital RH<h1>");
	}

	@PostMapping
	@CrossOrigin(origins = "http://localhost:4200")
	public String register(@RequestBody User user) {
		System.out.println(user);
		service.registerDefaultUser(user);
		return "register success";
	}

	@PutMapping("/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) {

		User newUser = service.findById(id);

		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setUsername(user.getUsername());
		newUser.setEmail(user.getEmail());
		newUser.setPassword(user.getPassword());
		newUser.setPhone(user.getPhone());
		newUser.setType(user.getType());
		newUser.setPhoto(user.getPhoto());
		newUser.setAddress(user.getAddress());
		newUser.setBirthday(user.getBirthday());
		newUser.setCountry(user.getCountry());
		newUser.setCity(user.getCity());
		newUser.setActive(user.getActive());

		service.save(newUser);
		return new ResponseEntity<>(newUser, HttpStatus.OK);
	}

	// Get All Users
	@GetMapping
//	@CrossOrigin(origins = "http://localhost:4200")
//	@PostAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<List<User>> getAll() {
		List<User> users = service.getAll();
		return new ResponseEntity<>(users, HttpStatus.OK);

	}

	@GetMapping("/{id}")

	public ResponseEntity<User> findById(@PathVariable("id") Long id) {
		User user = service.findById(id);
		return new ResponseEntity<>(user, HttpStatus.OK);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> delete(@PathVariable Long id) {
		User users = service.findById(id);
		service.delete(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

	@PostMapping(path = "/role")
//	@PostAuthorize("hasAuthority('ADMIN')")
	public AppRole saveRole(@RequestBody AppRole appRole) {
		service.save(appRole);
		return appRole;
	}

	@PostMapping(path = "/roleToUser")
//	@PostAuthorize("hasAuthority('ADMIN')")
	public void addRoleToUser(@RequestBody RoleUserForm roleUserForm) {

		service.addRoleToUser(roleUserForm.getUsername(), roleUserForm.getRoleName());
	}
	
	



	// Assing Project To Employee
	@PostMapping(path = "/addEmployee")
	public Collection<Project> AssingProjectToEmployee(@RequestBody ProjectToEmployee projectEmployee) {

		Employee employee = (Employee) service.findById(projectEmployee.getUserId());
		Project project = projectService.findById(projectEmployee.getProjectId());
		
		Collection<Project> projects = employee.getProjects();
		projects.add(project);
		employee.setProjects(projects);
		service.save(employee);

		return employee.getProjects();
	}
	
	
	
	
	// Assing Project To Employee
	@PostMapping(path = "/projectEmployee")
	public Collection<Project> AssignProject(@RequestBody ProjectEmployee projectEmployee) {

		Employee employee = (Employee) service.loadUserByUserName(projectEmployee.getUsername());
		Project project = projectService.findByTitle(projectEmployee.getTitle());
		
		Collection<Project> projects = employee.getProjects();
		projects.add(project);
		employee.setProjects(projects);
		service.save(employee);

		return employee.getProjects();
	}
	
	
	
	
	
	
	// Assing Meeting To Employee
		@PostMapping(path = "/meetingToEmployee")
		public Collection<Meeting> AssingMeetingToEmployee(@RequestBody MeetingToEmployee meetingEmployee) {

			Employee employee = (Employee) service.findById(meetingEmployee.getUserId());
			Meeting meeting = meetingService.findById(meetingEmployee.getMeetingId());
			
			Collection<Meeting> meetings = employee.getMeetings();
			meetings.add(meeting);
			employee.setMeetings(meetings);
			service.save(employee);

			return employee.getMeetings();
		}
	
	
	
	
	@GetMapping(path = "/refreshToken")
	public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String authToken = request.getHeader(JWTUtil.HEADER);
		if (authToken != null && authToken.startsWith(JWTUtil.PREFIX)) {

			try {

				String refreshToken = authToken.substring(JWTUtil.PREFIX.length());
				Algorithm algorithm = Algorithm.HMAC256(JWTUtil.SECRET);
				JWTVerifier jwtVerifier = JWT.require(algorithm).build();
				DecodedJWT decodedJWT = jwtVerifier.verify(refreshToken);
				String username = decodedJWT.getSubject();
				User user = service.loadUserByUserName(username);
				String jwtAccessToken = JWT.create().withSubject(user.getUsername())
						.withExpiresAt(new Date(System.currentTimeMillis() + JWTUtil.EXPIRE_ACCESS_TOKEN))
						.withIssuer(request.getRequestURI().toString())
						.withClaim("roles",
								user.getAppRoles().stream().map(r -> r.getRoleName()).collect(Collectors.toList()))
						.sign(algorithm);

				Map<String, String> idToken = new HashMap<>();
				idToken.put("access-token", jwtAccessToken);
				idToken.put("refresh-token", refreshToken);
				response.setContentType("application/json");
				new ObjectMapper().writeValue(response.getOutputStream(), idToken);

			} catch (Exception e) {
//				response.setHeader("error-message", e.getMessage());
//				response.sendError(HttpServletResponse.SC_FORBIDDEN);
				throw e;
			}
		} else {
			throw new RuntimeException("Refresh Token required!!");
		}
	}
}

@Data
class RoleUserForm {
	private String username;
	private String roleName;
}

@Data
class ProjectToEmployee {
	private Long userId;
	private Long projectId;
}


@Data
class MeetingToEmployee{
	private Long userId;
	private Long meetingId;
}




@Data
class ProjectEmployee{
	private String username;
	private String title;
}