package com.sym.test;

import java.sql.Connection;
import java.sql.SQLException;
import com.sym.jdbc.JDBCHelper;
//import com.sym.file.FileHandler;

public class JDBCTester {

	public static void main(String[] args) {
		Connection con = null;
		JDBCHelper jdbc = new JDBCHelper();
//		FileHandler fileHandler = new FileHandler();
		try {
			con = jdbc.getConnection();
//			jdbc.addEmployeeInfo(con, "1020", "Sailesh", "Thapa", "sailesh@example.com", "17-JUN-03", "AD_VP");
//			jdbc.addEmployeeInfoUsingPreparedStmt(con, "1021", "Himal", "Basnet", "himal@example.com", "17-JUN-03",
//					"AD_VP");
//			jdbc.addEmployeeInfoUsingCallableStmt(con, "1022", "Nischa;", "Basnet", "nischal@example.com", "17-JUN-03",
//					"AD_VP");
//			jdbc.updateEmployeeInfoUsingPreparedStmt(con, "1020", "saileshthapa53@gmail.com");
//			jdbc.deleteEmployeeInfoUsingPreparedStmt(con, "1021");
			jdbc.getEmployeeInfo(con, "1021");
			System.out.println("********** Data access completed ******");
//			jdbc.writeEmployeeDetailToFile(con, "test.txt");
//			fileHandler.readingFile("test.txt");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
