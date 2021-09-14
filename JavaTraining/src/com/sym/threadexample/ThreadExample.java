package com.sym.threadexample;

public class ThreadExample extends Thread {
	public ThreadExample() {
		super("New thread");
	}

	public void run() {
		for (int i = 1; i <= 20; i++) {
			System.out.println(i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}

		}
	}
}
