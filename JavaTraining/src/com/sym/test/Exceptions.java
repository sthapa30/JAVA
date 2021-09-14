package com.sym.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import com.sym.MyExceptions.CustomException;

public class Exceptions {

	public static void processFile(String file) throws CustomException {
		InputStream fs = null;
		try {
			fs = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			throw new CustomException(e.getMessage(), "FILE_NOT_FOUND_EXCEPTION");
		} finally {
			try {
				if (fs != null) {
					fs.close();
				}
			} catch (IOException e) {
				throw new CustomException(e.getMessage(), "FILE_CLOSE_EXCEPTION");
			}
		}
	}

	public static void processErrorCode(CustomException ex) throws CustomException {
		switch (ex.getErrorCode()) {
		case "FILE_NOT_FOUND":
			System.out.println("File not found");
			throw ex;
		case "FILE_CLOSE_EXCEPTION":
			System.out.println("File is not closed");
			throw ex;
		default:
			System.out.println("Unknown exception occured: " + ex.getMessage());
			ex.printStackTrace();
		}

	}

	public static void main(String[] args) throws CustomException {
		try {
			processFile("file.txt");
		} catch (CustomException ex) {
			processErrorCode(ex);
		}

		int a = 10;
		int b = 01;

		int[] intArray = new int[5];

		String str = "New String";
		String nullValue = null;
		try {
			int result = a / b;
			System.out.println("Div result: " + result);

			intArray[intArray.length - 1] = 10;
			System.out.println("Element at " + intArray.length + " is :" + intArray[intArray.length - 1]);

			char ch = str.charAt(str.length() - 1);
			System.out.println("Last character in str is: " + ch);

			@SuppressWarnings("null")
			int nullValueLength = nullValue.length();
			System.out.println("Length is : " + nullValueLength);
		} catch (ArithmeticException e) {
			System.out.println("******** exception occured: " + e.getMessage());
			e.printStackTrace();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("******** exception occured: " + e.getMessage());
			e.printStackTrace();
			// e.getCause();
		} catch (IndexOutOfBoundsException e) {
			System.out.println("******** exception occured: " + e.getMessage());
			e.printStackTrace();
		} catch (NullPointerException e) {
			System.out.println("******** exception occured: " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("******** exception occured: " + e.getMessage());
			e.printStackTrace();

		}

	}
}