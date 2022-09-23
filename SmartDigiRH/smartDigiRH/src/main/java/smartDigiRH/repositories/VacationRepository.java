package smartDigiRH.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import smartDigiRH.entities.Vacation;


@Repository
public interface VacationRepository extends JpaRepository<Vacation, Long> {

	Vacation findByVacationId(Long vacationId);

	

	


}
