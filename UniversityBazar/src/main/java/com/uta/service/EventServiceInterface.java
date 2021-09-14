package com.uta.service;

import java.util.List;

import com.uta.dto.EventDTO;

public interface EventServiceInterface {
	
	public List<EventDTO> getAllEventService();
	public EventDTO getEventByIdService(String Id);
	public List<EventDTO> getClubEventById(String clubId);
	public String createEventService(EventDTO eventDto);
	public void deleteEventService(String eventId) throws Exception;
	public void deleteEventOfClub(String clubId) throws Exception;


	


}
