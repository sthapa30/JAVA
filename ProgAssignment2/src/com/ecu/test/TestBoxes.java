package com.ecu.test;

import com.ecu.box.Box;

public class TestBoxes {

	public static void main(String[] args) {

		Box b1 = new Box(10, 5, 5, 2600);
		Box b2 = new Box(15, 22, 16, 1360);
		Box b3 = new Box();

		b3.setLength(12);
		b3.setHeight(8);
		b3.setWidth(14);
		b3.setWeight(564243);

		b2.setLength(40);
		b2.setWidth(11);
		b2.setHeight(18);
		b2.setWeight(224321);
		
		System.out.println(b1.toString());
		System.out.println("\n");
		System.out.println(b2.toString());
		System.out.println("\n");
		System.out.println(b3.toString());
		
	}

}
