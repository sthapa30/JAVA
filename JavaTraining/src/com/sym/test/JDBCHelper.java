package com.sym.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCHelper {

	public Connection getConnection() throws Exception {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe\", \"hr\", \"hr");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return con;
	}

	public void addEmployeeUsingPrepareStmt(Connection con, String empID, String name, String email) throws Exception {
		PreparedStatement pstmt;
		try {
			String sql = "Insert into employee(EMP_ID, NAME, EMAIL) values(?,?,?)";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, empID);
			pstmt.setString(2, name);
			pstmt.setString(3, email);

			int result = pstmt.executeUpdate();

			if (result == 1) {
				con.commit();
			} else {
				con.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public void addEmployeeUsingCallableStmt(Connection con, String empID, String name, String email) throws Exception {
		CallableStatement cstmt;
		try {
			String sql = "{call ADD_EMPLOYEES (?,?,?)}";
			cstmt = con.prepareCall(sql);

			cstmt.setString(1, empID);
			cstmt.setString(2, name);
			cstmt.setString(3, email);
			cstmt.registerOutParameter(4, java.sql.Types.VARCHAR);

			int result = cstmt.executeUpdate();

			if (result == 1) {
				con.commit();
			} else {
				con.rollback();
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
