package com.sym.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;

import com.sym.jdbc.JDBCHelper;

public class FileHandler {

	public void writeToFile(String fileName, String str) throws Exception {
		FileWriter fr = null;
		BufferedWriter br = null;
		try {
			File file = new File(fileName);
			fr = new FileWriter(file, true);
			br = new BufferedWriter(fr);
			br.newLine();
			br.write(str);
			br.flush();

		} catch (IOException ex) {
			ex.printStackTrace();
			throw ex;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		} finally {
			fr.close();
			br.close();
			System.out.println("File writing completed");
		}
	}

	public void readingFile(String fileName) throws Exception {
		Connection con = null;
		FileReader fr = null;
		BufferedReader br = null;
		try {
			File file = new File(fileName);
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String line = null;
			JDBCHelper jdbc = new JDBCHelper();

			con = jdbc.getConnection();

			while ((line = br.readLine()) != null) {
				if (line.trim().length() > 0) {
					String[] strArray = line.split(":");
					if (strArray.length == 4) {
						jdbc.addEmployeeInfoUsingPreparedStmt(con, strArray[0], strArray[1], strArray[2], strArray[3]);
					} else {
						System.out.println("Failed loading the record for employee id : " + strArray[0]);
					}

				}

				// writeToFile("C:\\files\\test_new.txt", line);
			}

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
			throw ex;
		} catch (IOException ex) {
			ex.printStackTrace();
			throw ex;

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			fr.close();
			br.close();
			con.close();
		}
	}
}
