package com.sym.services;

import com.sym.bo.EmployeeInfoBO;
import com.sym.dto.EmployeeDTO;

public class EmployeeInfoService {

	public EmployeeDTO getEmployeeInfo(String empId) {

		EmployeeDTO empDto = null;
		EmployeeInfoBO empBo = new EmployeeInfoBO();
		System.out.println("EmployeeInfoService - start");
		empDto = empBo.getEmployeeInfo(empId);
		System.out.println("EmployeeInfoService - end");
		return empDto;
	}

	public String addEmployee(String empId, String firstName, String lastName, String email, String hireDate,
			String jobID) {

		String response = null;
		EmployeeInfoBO empBao = new EmployeeInfoBO();

		int result = empBao.addEmployee(empId, firstName, lastName, email, hireDate, jobID);

		if (result == 1) {
			response = "Added Successfully!";
		} else {
			response = "Failed to add";
		}

		return response;
	}

	public String updateEmployeeInfo(String empId, String firstName, String lastName, String email, String hireDate,
			String jobID) {

		String response = null;
		EmployeeInfoBO empBao = new EmployeeInfoBO();

		int result = empBao.updateEmployeeInfo(empId, firstName, lastName, email, hireDate, jobID);

		if (result == 1) {
			response = "Updated Successfully!";
		} else {
			response = "Failed to update";
		}

		return response;
	}

	public String deleteEmployee(String empId) {

		String response = null;
		EmployeeInfoBO empBao = new EmployeeInfoBO();

		int result = empBao.deleteEmployee(empId);

		if (result == 1) {
			response = "Deleted Successfully!";
		} else {
			response = "Failed to delete";
		}

		return response;

	}

}
