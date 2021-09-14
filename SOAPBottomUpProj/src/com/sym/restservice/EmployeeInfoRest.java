package com.sym.restservice;

import com.sym.dto.EmployeeDTO;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/EmployeeRestService")
public class EmployeeInfoRest {
	
	@RequestMapping(value = "/getEmployeeInfo/{empId}",
			        method = RequestMethod.GET,
			        produces = {"application/json"})
	public EmployeeDTO getEmployeeInfo(@PathVariable("empId") String empId) {
		
		System.out.println(empId);

		EmployeeDTO empDto = new EmployeeDTO();
		empDto.setFirstName("test");
		empDto.setLastName("user");
		empDto.setEmail("test@company.com");
		return empDto;
	}

}
