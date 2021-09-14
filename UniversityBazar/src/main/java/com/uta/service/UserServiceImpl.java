package com.uta.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.uta.dto.ClubDTO;
import com.uta.dto.ResponseUserClub;
import com.uta.dto.UserDTO;
import com.uta.repo.UserRepo;

@Service
public class UserServiceImpl implements UserServiceInterface {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List<UserDTO> getAllUserService() {

		return userRepo.findAll();
	}

	@Override
	public ResponseUserClub getUserByIdService(String Id) throws Exception {

		ResponseUserClub responseUserClub = new ResponseUserClub();
		UserDTO resultUserDto = null;
		try {

			// logger.debug("EmployeeInfoServiceImpl.getEmployeeInfo - start: " + empId);

			Optional<UserDTO> userDto = userRepo.findById(Id);
			resultUserDto = userDto.get();

			// logger.debug("EmployeeInfoServiceImpl.getEmployeeInfo - end: " + empId);

		} catch (Exception e) {

			throw new Exception(" User not found");

			// logger.error(e.getStackTrace());
		}

		ClubDTO clubDto = restTemplate.getForObject(
				"http://localhost:8080/ClubController/getClubById/" + resultUserDto.getClubID(), ClubDTO.class);

		responseUserClub.setUserDto(resultUserDto);
		responseUserClub.setClubDto(clubDto);
		return responseUserClub;
	}

	@Override
	public String addUserService(UserDTO userDto) {
		String message = null;
		UserDTO result = null;
		try {

			result = userRepo.save(userDto);
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
	public void deleteUserService(String userId) throws Exception {
		try {
			userRepo.deleteById(userId);

		} catch (Exception e) {
			throw new Exception("User not found");
		}

	}

}
