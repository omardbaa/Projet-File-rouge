package smartDigiRH.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import smartDigiRH.entities.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	
	Employee findByUsername(String username);

	Employee findByUserId (Long userId);

	


}
