package smartDigiRH.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import smartDigiRH.entities.Meeting;


@Repository
public interface MeetingRepository extends JpaRepository<Meeting, Long> {

	Meeting findByMeetingId(Long meetingId);

	


	


}
