package com.sym.test;

import com.sym.inheritence.Child;
import com.sym.inheritence.Parent;

public class TestInheritence {

	public static void main(String[] args) {
		Parent parent = new Parent();
		System.out.println(parent.getName());
		
		Child child = new Child();
		System.out.println("My name is " + child.getChildName());
		System.out.println("My parent name is " + child.getName());

	}

}
