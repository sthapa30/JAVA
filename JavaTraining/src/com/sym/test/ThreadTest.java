package com.sym.test;

import com.sym.threadexample.ThreadExample;

public class ThreadTest {

	public static void main(String[] args) {
		ThreadExample myThread = new ThreadExample();
		myThread.start();
		System.out.println(myThread.getName());

	}

}
