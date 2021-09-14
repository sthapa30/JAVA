package com.sym.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sym.dto.EmployeeDTO;
import com.sym.singleton.AppConstants;
import com.sym.singleton.PropertiesHelper;

public class EmployeeInfoDAO {

	public EmployeeDTO getEmployeeInfo(String empId) throws Exception {

		ResultSet rs = null;
		Connection con = null;
		EmployeeDTO empDto = null;
		System.out.println("   EmployeeInfoDAO - start");
		try {
			con = getConnection();
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery("select * from employees where employee_id = '" + empId + "'");

			while (rs.next()) {
				empDto = new EmployeeDTO();
				empDto.setEmpID(rs.getString("EMPLOYEE_ID"));
				empDto.setFirstName(rs.getString("FIRST_NAME"));
				empDto.setLastName(rs.getString("LAST_NAME"));
				empDto.setEmail(rs.getString("EMAIL"));
				// System.out.println(employeeID + ":" + lastName + ":" + firstName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				rs.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("   EmployeeInfoDAO - end");
		return empDto;
	}

	public int addEmployee(String empId, String firstName, String lastName, String email, String hireDate, String jobID)
			throws Exception {
		// System.out.println(empId + firstName + lastName + email);
		PreparedStatement pstmt;
		Connection con = null;
		int response = 0;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(
					"insert into employees(EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,HIRE_DATE,JOB_ID) values(?,?,?,?,?,?)");
			pstmt.setString(1, empId);
			pstmt.setString(2, lastName);
			pstmt.setString(3, firstName);
			pstmt.setString(4, email);
			pstmt.setString(5, hireDate);
			pstmt.setString(6, jobID);

			int result = pstmt.executeUpdate();
			if (result == 1) {
				con.commit();
				System.out.println("Employee added sucessfully!");
				response = 1;
			} else {
				con.rollback();
				System.out.println("Failed to add!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			con.close();
		}
		return response;
	}

	public Connection getConnection() throws Exception {
		Connection con = null;
		PropertiesHelper props = PropertiesHelper.getInstance();
		try {
			Class.forName(props.getString(AppConstants.driver));
			con = DriverManager.getConnection(props.getString(AppConstants.url), props.getString(AppConstants.user),
					props.getString(AppConstants.password));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		return con;
	}

}
