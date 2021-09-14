package com.uta.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.uta.dto.ClubDTO;
import com.uta.dto.EventDTO;
import com.uta.dto.ResponseClubEvent;
import com.uta.repo.ClubRepo;

@Service
public class ClubServiceImpl implements ClubServiceInterface {

	@Autowired
	private ClubRepo clubRepo;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List<ClubDTO> getAllClubService() {

		return clubRepo.findAll();
	}

	@Override
	public ClubDTO getClubByIdService(String Id) {

		ClubDTO result = null;
		try {

			// logger.debug("EmployeeInfoServiceImpl.getEmployeeInfo - start: " + empId);

			Optional<ClubDTO> clubDto = clubRepo.findById(Id);
			result = clubDto.get();

			// logger.debug("EmployeeInfoServiceImpl.getEmployeeInfo - end: " + empId);

		} catch (Exception e) {

			// logger.error(e.getStackTrace());
		}

		return result;
	}

	@Override
	public ResponseClubEvent getClubEventService(String Id) {

		ResponseClubEvent responseClubEvent = new ResponseClubEvent();
		ClubDTO resultClubDto = null;
		try {

			// logger.debug("EmployeeInfoServiceImpl.getEmployeeInfo - start: " + empId);

			Optional<ClubDTO> clubDto = clubRepo.findById(Id);
			resultClubDto = clubDto.get();

			// logger.debug("EmployeeInfoServiceImpl.getEmployeeInfo - end: " + empId);

		} catch (Exception e) {

			// logger.error(e.getStackTrace());
		}

		ResponseEntity<EventDTO[]> response = restTemplate.getForEntity(
				"http://localhost:8080/EventController/getClubEventById/" + resultClubDto.getClubID(),
				EventDTO[].class);
		responseClubEvent.setClubDto(resultClubDto);
		List<EventDTO> eventDto = Arrays.asList(response.getBody());
		responseClubEvent.setEventDto(eventDto);
		return responseClubEvent;

	}

	@Override
	public String createClubService(ClubDTO clubDto) {
		String message = null;
		ClubDTO result = null;
		try {

			result = clubRepo.save(clubDto);
			if (result != null) {
				message = "Added Sucessfully!";
			}

		} catch (Exception e) {
			message = "Failed to Add";
			// logger.error(e.getStackTrace());
		}
		return message;
	}

	@Override
	public void deleteClubService(String clubId) throws Exception {
		// need to delete all the events in this club
		try {
			restTemplate.delete("http://localhost:8080/EventController/deleteEventOfClubService/" + clubId);
			clubRepo.deleteById(clubId);
		} catch (Exception e) {
			throw new Exception(" Club not found");
		}

	}

}
