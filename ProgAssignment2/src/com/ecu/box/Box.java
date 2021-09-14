package com.ecu.box;

public class Box {

	private int length;
	private int width;
	private int height;
	private int weight;

	public Box() {

		this.length = 0;
		this.width = 0;
		this.height = 0;
		this.weight = 0;
	}

	public Box(int length, int width, int height, int weight) {

		this.length = length;
		this.width = width;
		this.height = height;
		this.weight = weight;
	}

	public int calculateVolume() {

		return length * width * height;
	}

	public double calculateDensity() throws Exception {

		double density = 0.0;
		int volume = calculateVolume();

		try {
			density = this.weight / (double) volume;
		} catch (ArithmeticException ex) {
			ex.printStackTrace();
			throw ex;

		}
		return density;
	}

	public String toString() {

		double density;
		String densityString = null;

		try {
			density = calculateDensity();
			densityString = String.format("%1.2f", density);
		} catch (Exception e) {
			System.out.println("Divide by zero");
		}
		String result = "This Box has:\nLength = " + this.length + ", Width = " + this.width + ", Height = "
				+ this.height + ", Weight = " + this.weight + "\nVolume = " + calculateVolume() + "\nDensity = "
				+ densityString;
		return result;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

}
