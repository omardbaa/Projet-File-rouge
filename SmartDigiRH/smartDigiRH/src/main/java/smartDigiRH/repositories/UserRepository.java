package smartDigiRH.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import smartDigiRH.entities.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	
	User findByUsername(String username);

	


}
