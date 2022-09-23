package smartDigiRH.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import smartDigiRH.entities.Training;


@Repository
public interface TrainingRepository extends JpaRepository<Training, Long> {

	Training findByTrainingId(Long trainingId);

	

}
