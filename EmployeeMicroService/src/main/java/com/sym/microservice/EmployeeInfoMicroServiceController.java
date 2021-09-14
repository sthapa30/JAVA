package com.sym.microservice;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "EmployeeMicroService")
public class EmployeeInfoMicroServiceController {

	Logger logger = Logger.getLogger(EmployeeInfoMicroServiceController.class);

	@Autowired
	EmployeeInfoService employeeInfoService;

	@RequestMapping(value = "/getEmployeeInfo/{empId}", method = RequestMethod.GET, produces = { "application/json" })
	public EmployeeDTO getEmployeeInfo(@PathVariable("empId") String empId) {

		logger.debug("EmployeeInfoMicroServiceController.getEmployeeInfo - start: " + empId);

		EmployeeDTO empDto = employeeInfoService.getEmployeeInfo(empId);

		logger.debug("EmployeeInfoMicroServiceController.getEmployeeInfo - end: " + empId);
		return empDto;
	}

	@RequestMapping(value = "/getAllEmployeeInfo", method = RequestMethod.GET, produces = { "application/json" })
	public List<EmployeeDTO> getAllEmployeeInfo() {

		logger.debug("EmployeeInfoMicroServiceController.getAllEmployeeInfo - start: ");
		
		List<EmployeeDTO> empDtoList = employeeInfoService.getAllEmployeeInfo();
		
		logger.debug("EmployeeInfoMicroServiceController.getAllEmployeeInfo - end: ");

		return empDtoList;
	}

	@PostMapping(value = "/addEmployee", consumes = { "application/json" }, produces = { "application/json" })
	public String addEmployee(@RequestBody EmployeeDTO empDto) {
		
		logger.debug("EmployeeInfoMicroServiceController.addEmployee - start: ");
		//System.out.println(empDto.getEmpID());
		String result = employeeInfoService.addEmployee(empDto);
		
		logger.debug("EmployeeInfoMicroServiceController.addEmployee - end: ");

		return result;

	}

}
