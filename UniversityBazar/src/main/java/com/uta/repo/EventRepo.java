package com.uta.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uta.dto.EventDTO;

@Repository
public interface EventRepo extends JpaRepository<EventDTO, String> {
	
	@Query("SELECT E FROM EventDTO E WHERE CLUB_ID = ?1")
	public List<EventDTO> findAllClubEvent(String clubId);
	
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value="DELETE FROM Event WHERE CLUB_ID = ?1")
	public void deleteEventOfClub(String clubId);
	
}
