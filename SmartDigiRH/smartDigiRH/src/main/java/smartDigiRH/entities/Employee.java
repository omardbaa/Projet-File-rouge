package smartDigiRH.entities;




import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@NoArgsConstructor @AllArgsConstructor @ToString
@Data
@JsonIdentityInfo(scope = Employee.class, generator = ObjectIdGenerators.PropertyGenerator.class,
 
		 property = "userId")

@Table (name="employees")
public class Employee extends User {
	
	
	private String post;
	

	private String contrat;
	
	

	private Double salary;
	
	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
	targetEntity = Project.class, fetch = FetchType.LAZY)
	@JoinTable(name = "employee_project", 
	joinColumns = @JoinColumn(name ="userId"),
	inverseJoinColumns = @JoinColumn(name ="projectId")
	)
	
	@JsonIgnore
	private Collection<Project> projects;
	
//	  public void save(Project projects) {
//	        this.projects.add(projects);
//	}
//	
	
	
	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
	targetEntity = Meeting.class, fetch = FetchType.LAZY)
	@JoinTable(name = "employee_meeting", 
	joinColumns = @JoinColumn(name ="userId"),
	inverseJoinColumns = @JoinColumn(name ="meetingId")
	)
	//	@JsonIgnore
	private Collection<Meeting> meetings;

	
	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
	targetEntity = Training.class, fetch = FetchType.LAZY)
	@JoinTable(name = "employee_training", 
	joinColumns = @JoinColumn(name ="userId"),
	inverseJoinColumns = @JoinColumn(name ="trainingId")
	)
	//	@JsonIgnore
	private Collection<Training> trainings;

	
	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
	targetEntity = Vacation.class, fetch = FetchType.LAZY)
	@JoinTable(name = "employee_vacation", 
	joinColumns = @JoinColumn(name ="userId"),
	inverseJoinColumns = @JoinColumn(name ="vacationId")
	)
	//	@JsonIgnore
	private Collection<Vacation> vacations;



	public void setEmployees(Collection<Employee> employees) {
		// TODO Auto-generated method stub
		
	}


	
}
