package smartDigiRH.entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@NoArgsConstructor @AllArgsConstructor @ToString
@Data
@JsonIdentityInfo(scope = Meeting.class, generator = ObjectIdGenerators.PropertyGenerator.class,
 
		 property = "meetingId")
@Table (name="meetings")
public class Meeting {
	@Id  @GeneratedValue (strategy = GenerationType.IDENTITY)
	
	private Long meetingId;
	
	@NotEmpty
	private String title;
	
	@NotEmpty
	private String description;
	
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat (pattern = "yyyy-MM-dd")
	private Date meetingDate;
	
	@NotEmpty
	private String type;
	
	 
	@ManyToMany(mappedBy = "meetings", targetEntity = Employee.class, fetch = FetchType.LAZY)
	private Collection<Employee> employees;
	
}
