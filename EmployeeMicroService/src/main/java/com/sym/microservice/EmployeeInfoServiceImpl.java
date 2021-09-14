package com.sym.microservice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class EmployeeInfoServiceImpl implements EmployeeInfoService {

	Logger logger = Logger.getLogger(EmployeeInfoServiceImpl.class);

	@Autowired
	EmpoyeeInfoRepo employeeInfoRepo;

	@Override
	public EmployeeDTO getEmployeeInfo(String empId) {

		EmployeeDTO result = null;
		try {

			logger.debug("EmployeeInfoServiceImpl.getEmployeeInfo - start: " + empId);

			Optional<EmployeeDTO> empDto = employeeInfoRepo.findById(Integer.parseInt(empId));
			result = empDto.get();

			logger.debug("EmployeeInfoServiceImpl.getEmployeeInfo - end: " + empId);

		} catch (Exception e) {

			logger.error(e.getStackTrace());
		}

		return result;
	}

	@Override
	public List<EmployeeDTO> getAllEmployeeInfo() {

		List<EmployeeDTO> empDtoList = new ArrayList<EmployeeDTO>();
		try {

			logger.debug("EmployeeInfoServiceImpl.getAllEmployeeInfo - start: ");
			Iterable<EmployeeDTO> empDto = employeeInfoRepo.findAll(Sort.by(Sort.Direction.ASC, "empID"));
			Iterator<EmployeeDTO> empDtoItr = empDto.iterator();

			while (empDtoItr.hasNext()) {
				empDtoList.add(empDtoItr.next());
			}

			logger.debug("EmployeeInfoServiceImpl.getAllEmployeeInfo - end: ");

		} catch (Exception e) {

			logger.error(e.getStackTrace());
		}

		return empDtoList;
	}

	@Override
	public String addEmployee(EmployeeDTO empDto) {

		String message = null;
		EmployeeDTO result = null;
		try {

			result = employeeInfoRepo.save(empDto);
			if (result != null) {
				message = "Added Sucessfully!";
			}

		} catch (Exception e) {
			message = "Failed to Add";
			logger.error(e.getStackTrace());
		}
		return message;
	}

}
