package com.uta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uta.dto.ClubDTO;
import com.uta.dto.ResponseClubEvent;
import com.uta.service.ClubServiceImpl;

@RestController
@RequestMapping(value = "ClubController")
public class ClubController {

	@Autowired
	private ClubServiceImpl clubService;

	@RequestMapping(value = "/getAllClubInfo", method = RequestMethod.GET, produces = { "application/json" })
	public List<ClubDTO> getAllClubInfo() {

		// System.out.println("hello");
		return clubService.getAllClubService();

	}

	@RequestMapping(value = "/getClubById/{clubId}", method = RequestMethod.GET, produces = { "application/json" })
	public ClubDTO getClubById(@PathVariable("clubId") String clubId) {

		return clubService.getClubByIdService(clubId);
	}

	@RequestMapping(value = "/getClubEventService/{clubId}", method = RequestMethod.GET, produces = {
			"application/json" })
	public ResponseClubEvent getClubEventService(@PathVariable("clubId") String clubId) {

		return clubService.getClubEventService(clubId);
	}

	@PostMapping(value = "/createClub", consumes = { "application/json" }, produces = { "application/json" })
	public String createClub(@RequestBody ClubDTO clubDto) {

		// logger.debug("EmployeeInfoMicroServiceController.addEmployee - start: ");
		// System.out.println(empDto.getEmpID());
		String result = clubService.createClubService(clubDto);

		// logger.debug("EmployeeInfoMicroServiceController.addEmployee - end: ");

		return result;

	}

	@RequestMapping(value = "/deleteClubService/{clubId}", method = RequestMethod.DELETE, produces = {
			"application/json" })
	public String deleteClubService(@PathVariable("clubId") String clubId) throws Exception {

		try {
			clubService.deleteClubService(clubId);
		} catch (Exception e) {
			throw(e);
		}
		return "Delete Sucessful";
	}

}
