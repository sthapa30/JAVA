package com.sym.bo;

import com.sym.dao.EmployeeInfoDAO;
import com.sym.dto.EmployeeDTO;

public class EmployeeInfoBO {

	public EmployeeDTO getEmployeeInfo(String empId) {

		EmployeeDTO empDto = null;
		System.out.println("    EmployeeInfoBO - start");
		if (empId != null && empId.trim().length() > 0) {
			EmployeeInfoDAO empDao = new EmployeeInfoDAO();
			try {
				empDto = empDao.getEmployeeInfo(empId);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Invalid empID");
		}
		System.out.println("    EmployeeInfoBO - end");
		return empDto;
	}

	public boolean checkNull(String input) {

		if (input != null && input.trim().length() > 0) {
			return true;
		}
		return false;
	}

	public int addEmployee(String empId, String firstName, String lastName, String email, String hireDate,
			String jobID) {

		int result = 0;
		if (checkNull(empId) && checkNull(firstName) && checkNull(lastName) && checkNull(email) && checkNull(jobID)
				&& checkNull(hireDate)) {
			EmployeeInfoDAO empDao = new EmployeeInfoDAO();
			try {
				result = empDao.addEmployee(empId, firstName, lastName, email, hireDate, jobID);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return result;
	}

}
