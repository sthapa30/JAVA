package com.sym.jdbc;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sym.file.FileHandler;
import com.sym.singleton.AppConstants;
import com.sym.singleton.PropertiesHelper;

public class JDBCHelper {

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

	public void getEmployeeInfo(Connection con, String empID) throws Exception {
		ResultSet rs = null;
		try {
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery("select * from employees where employee_id = '" + empID + "'");

			while (rs.next()) {
				String employeeID = rs.getString("EMPLOYEE_ID");
				String lastName = rs.getString("LAST_NAME");
				String firstName = rs.getString("FIRST_NAME");
				System.out.println(employeeID + ":" + lastName + ":" + firstName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			rs.close();
		}

	}

	public void addEmployeeInfo(Connection con, String empID, String lastName, String firstName, String email,
			String hireDate, String jobID) throws Exception {

		try {
			Statement stmt = con.createStatement();
			String sql = "insert into employees(EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,HIRE_DATE,JOB_ID) values("
					+ empID + ",'" + firstName + "'" + ",'" + lastName + "','" + email + "','" + hireDate + "','"
					+ jobID + "')";
			stmt.executeQuery(sql);
			con.commit();
			System.out.println("Employee added sucessfully!");
		} catch (SQLException e) {
			con.rollback();
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public void addEmployeeInfoUsingPreparedStmt(Connection con, String empID, String lastName, String firstName,
			String email) throws Exception {
		// validate arguments. check for null values
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(
					"insert into employees_new(EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL) values(?,?,?,?)");
			pstmt.setString(1, empID);
			pstmt.setString(2, lastName);
			pstmt.setString(3, firstName);
			pstmt.setString(4, email);
			// pstmt.setString(5, hireDate);
			// pstmt.setString(6, jobID);

			int result = pstmt.executeUpdate();
			if (result == 1) {
				con.commit();
				System.out.println("Employee added sucessfully!");
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
		}

	}

	public void addEmployeeInfoUsingCallableStmt(Connection con, String empID, String lastName, String firstName,
			String email, String hireDate, String jobID) throws Exception {

		CallableStatement cstmt;
		try {

			cstmt = con.prepareCall("{call ADD_EMPLOYEES (?,?,?,?,?,?,?)}");
			cstmt.setString(1, empID);
			cstmt.setString(2, lastName);
			cstmt.setString(3, firstName);
			cstmt.setString(4, email);
			cstmt.setString(5, hireDate);
			cstmt.setString(6, jobID);

			cstmt.registerOutParameter(7, java.sql.Types.VARCHAR);

			int result = cstmt.executeUpdate();
			if (result == 1) {
				System.out.println(cstmt.getString(7));
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
		}

	}

	public void updateEmployeeInfoUsingPreparedStmt(Connection con, String empID, String email) throws Exception {

		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement("update employees set email=? where employee_id=?");
			pstmt.setString(1, email);
			pstmt.setString(2, empID);

			int result = pstmt.executeUpdate();
			if (result == 1) {
				con.commit();
				System.out.println("Update Sucessful!");
			} else {
				con.rollback();
				System.out.println("Update Failed!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public void deleteEmployeeInfoUsingPreparedStmt(Connection con, String empID) throws Exception {

		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement("delete from employees where employee_id=?");
			pstmt.setString(1, empID);

			int result = pstmt.executeUpdate();
			if (result == 1) {
				con.commit();
				System.out.println("Delete Sucessful!");
			} else {
				con.rollback();
				System.out.println("Delete Failed!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public void writeEmployeeDetailToFile(Connection con, String filename) throws Exception {
		ResultSet rs = null;
		try {
			System.out.println("JDBCHelper.writeEmployeeDetailToFile  - begin");
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery("select * from employees");

			FileHandler fileHandler = new FileHandler();

			while (rs.next()) {
				String employeeID = rs.getString("EMPLOYEE_ID");
				String lastName = rs.getString("LAST_NAME");
				String firstName = rs.getString("FIRST_NAME");
				String email = rs.getString("EMAIL");
				String line = employeeID + ":" + lastName + ":" + firstName + ":" + email;

				fileHandler.writeToFile(filename, line);

			}
			System.out.println("JDBCHelper.writeEmployeeDetailToFile  - end");
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			rs.close();
		}

	}

}
