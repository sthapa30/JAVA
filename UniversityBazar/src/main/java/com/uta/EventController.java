package com.uta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uta.dto.EventDTO;
import com.uta.service.EventServiceImpl;

@RestController
@RequestMapping(value = "EventController")
public class EventController {

	@Autowired
	private EventServiceImpl eventService;

	@RequestMapping(value = "/getAllEventInfo", method = RequestMethod.GET, produces = { "application/json" })
	public List<EventDTO> getAllEventInfo() {

		return eventService.getAllEventService();

	}

	@RequestMapping(value = "/getEventById/{eventId}", method = RequestMethod.GET, produces = { "application/json" })
	public EventDTO getEventById(@PathVariable("eventId") String eventId) {

		return eventService.getEventByIdService(eventId);
	}

	@RequestMapping(value = "/getClubEventById/{clubId}", method = RequestMethod.GET, produces = { "application/json" })
	public List<EventDTO> getClubEventById(@PathVariable("clubId") String clubId) {

		return eventService.getClubEventById(clubId);
	}

	@PostMapping(value = "/createEvent", consumes = { "application/json" }, produces = { "application/json" })
	public String createEvent(@RequestBody EventDTO eventDTO) {

		// logger.debug("EmployeeInfoMicroServiceController.addEmployee - start: ");
		// System.out.println(empDto.getEmpID());
		String result = eventService.createEventService(eventDTO);

		// logger.debug("EmployeeInfoMicroServiceController.addEmployee - end: ");

		return result;

	}

	@RequestMapping(value = "/deleteEventService/{eventId}", method = RequestMethod.DELETE, produces = {
			"application/json" })
	public String deleteEventService(@PathVariable("eventId") String eventId) throws Exception {

		try {
			eventService.deleteEventService(eventId);
		} catch (Exception e) {
			throw(e);
		}
		return "Delete Sucessful";
	}

	@RequestMapping(value = "/deleteEventOfClubService/{clubId}", method = RequestMethod.DELETE, produces = {
			"application/json" })
	public String deleteEventOfClubService(@PathVariable("clubId") String clubId) throws Exception {

		try {
			eventService.deleteEventOfClub(clubId);
		} catch (Exception e) {
			throw(e);		}
		return "Delete Sucessful";
	}

}
