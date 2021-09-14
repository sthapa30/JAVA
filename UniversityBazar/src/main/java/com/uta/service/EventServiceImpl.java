package com.uta.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uta.dto.EventDTO;
import com.uta.repo.EventRepo;

@Service
public class EventServiceImpl implements EventServiceInterface {
	
	@Autowired
	EventRepo eventRepo;
	
	@Override
	public List<EventDTO> getAllEventService() {
		
		return eventRepo.findAll();
	}

	@Override
	public EventDTO getEventByIdService(String Id) {
		

		EventDTO result = null;
		try {

			//logger.debug("EmployeeInfoServiceImpl.getEmployeeInfo - start: " + empId);

			Optional<EventDTO> eventDto = eventRepo.findById(Id);
			result = eventDto.get();

			//logger.debug("EmployeeInfoServiceImpl.getEmployeeInfo - end: " + empId);

		} catch (Exception e) {

			//logger.error(e.getStackTrace());
		}

		return result;
	}

	@Override
	public List<EventDTO> getClubEventById(String clubId) {
		
		return eventRepo.findAllClubEvent(clubId);
		
	}

	@Override
	public String createEventService(EventDTO eventDto) {
		
		String message = null;
		EventDTO result = null;
		try {

			result = eventRepo.save(eventDto);
			if (result != null) {
				message = "Added Sucessfully!";
			}

		} catch (Exception e) {
			message = "Failed to Add";
			//logger.error(e.getStackTrace());
		}
		return message;

	}

	@Override
	public void deleteEventService(String eventId) throws Exception {
		try {
			
			eventRepo.deleteById(eventId);

			
		}catch (Exception e) {
			throw new Exception("Event not found");
		}
		
	}

	@Override
	public void deleteEventOfClub(String clubId) throws Exception {
		try {
			eventRepo.deleteEventOfClub(clubId);

			
		}catch (Exception e) {
			
			throw new Exception("Club not found");
		}
		
	}

}
