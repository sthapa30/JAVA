package com.sym.microservice;

import java.util.List;

public interface EmployeeInfoService {

	public EmployeeDTO getEmployeeInfo(String empId);

	public List<EmployeeDTO> getAllEmployeeInfo();
	
	public String addEmployee(EmployeeDTO empDto);

}
