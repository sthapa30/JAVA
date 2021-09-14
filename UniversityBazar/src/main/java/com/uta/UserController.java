package com.uta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uta.dto.ResponseUserClub;
import com.uta.dto.UserDTO;
import com.uta.service.UserServiceImpl;

@RestController
@RequestMapping(value = "UserController")
public class UserController {

	@Autowired
	private UserServiceImpl userService;

	@RequestMapping(value = "/getAllUserInfo", method = RequestMethod.GET, produces = { "application/json" })
	public List<UserDTO> getAllUserInfo() {

		System.out.println("hello");
		return userService.getAllUserService();

	}

	@RequestMapping(value = "/getUserById/{userId}", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseUserClub getUserById(@PathVariable("userId") String userId) throws Exception {

		// userService.getUserByIdService(userId);

		// return null;
		try {
			return userService.getUserByIdService(userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw(e);
		}
	}

	@PostMapping(value = "/addUser", consumes = { "application/json" }, produces = { "application/json" })
	public String addUser(@RequestBody UserDTO userDto) {

		// logger.debug("EmployeeInfoMicroServiceController.addEmployee - start: ");
		// System.out.println(empDto.getEmpID());
		String result = userService.addUserService(userDto);

		// logger.debug("EmployeeInfoMicroServiceController.addEmployee - end: ");

		return result;

	}

	@PutMapping(value = "/updateUser/{id}")
	public void updateUser(@RequestBody UserDTO userDto, @PathVariable String userID) {
		// returns ResponseEntity
		// https://www.springboottutorial.com/spring-boot-crud-rest-service-with-jpa-hibernate
	}

	
	@RequestMapping(value = "/deleteUserService/{userId}", method = RequestMethod.DELETE, produces = {
			"application/json" })
	public String deleteUserService(@PathVariable("userId") String userId) throws Exception {

		try {
			userService.deleteUserService(userId);
		} catch (Exception e) {
			throw(e);
		}
		return "Delete Sucessful";
	}

}
