package smartDigiRH.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "app_roles")

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

@JsonIdentityInfo(scope = AppRole.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "role_id")

public class AppRole {

	@Id
	private Long role_id;
	private String roleName;
	

}