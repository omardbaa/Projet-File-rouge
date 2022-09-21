package smartDigiRH.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import smartDigiRH.entities.Admin;


@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

	
	Admin findByUsername(String username);

	


}
