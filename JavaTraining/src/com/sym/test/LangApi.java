package com.sym.test;

import java.util.Scanner;

public class LangApi {

	public static void main(String[] args) {

		/********** weight conversion program *******************/

		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter your weight(e.g 120 lb): ");
		String weight[] = sc.nextLine().split(" ");
		sc.close();

		double inputWeight = Double.parseDouble(weight[0]);
		String unit = weight[1];

		if (unit.equalsIgnoreCase("lb")) {
			// 1kg = 2.20462 pounds
			inputWeight /= 2.20462;
			System.out.println("Your weight in kg is: " + String.format("%.2f", inputWeight));
		} else if (unit.equalsIgnoreCase("kg")) {
			inputWeight *= 2.20462;
			System.out.println("Your weight in lb is: " + String.format("%.2f", inputWeight));
		} else {
			System.out.println("Invalid input\n");
		}

		/****************************************************************/

	}

}
