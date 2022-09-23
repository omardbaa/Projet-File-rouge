package smartDigiRH.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import smartDigiRH.entities.Employee;
import smartDigiRH.entities.Project;


@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

	
	Project findByProjectId(Long projectId);

	void save(Employee employee);

	Project findByTitle(String title); 

	


}
