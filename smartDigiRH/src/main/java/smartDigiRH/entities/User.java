package smartDigiRH.entities;


import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@NoArgsConstructor @AllArgsConstructor @ToString
@Data
@JsonIdentityInfo(scope = User.class, generator = ObjectIdGenerators.PropertyGenerator.class,
 
		 property = "userId")
@Inheritance(strategy = InheritanceType.JOINED)
@Table (name="users")
public class User {
	@Id  @GeneratedValue(strategy = GenerationType.TABLE)
	
	
private Long userId;
	
	
private String firstName;


private String lastName;


private String username;

 
@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
private String password; 


private String photo;


private String email;


private String phone;

@Temporal(TemporalType.DATE)
@DateTimeFormat (pattern = "yyyy-MM-dd")
private Date birthday;


private String country;


private String city;


private String address;


private Boolean active;


private String type;


@ManyToMany(fetch = FetchType.EAGER)
private Collection<AppRole> appRoles ;

  public void save(AppRole role) {
        this.appRoles.add(role);
}
}
