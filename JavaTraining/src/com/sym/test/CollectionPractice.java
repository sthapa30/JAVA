package com.sym.test;

import java.util.LinkedList;
import java.util.ListIterator;

public class CollectionPractice {

	public static void main(String[] args) {

		LinkedList<Integer> myLinkedList = new LinkedList<>();
		myLinkedList.add(10);
		myLinkedList.add(15);
		myLinkedList.add(25);
		myLinkedList.add(35);
		myLinkedList.add(45);

		System.out.println("Java 8 approach:");
		myLinkedList.forEach(System.out::println);

		System.out.println("\nRemoving last element in the list");
		myLinkedList.remove(myLinkedList.removeLast());

		System.out.println("\nListIterator approach:");
		ListIterator<Integer> myListIterator = myLinkedList.listIterator();
		while (myListIterator.hasNext()) {
			System.out.println(myListIterator.next());
		}

		System.out.println("\n Adding element at index 3");
		myLinkedList.add(3, 18);
		System.out.println("\nJava 8 approach:");
		myLinkedList.forEach(System.out::println);
		
		myLinkedList.pop();
		System.out.println("\nJava 8 approach:");
		myLinkedList.forEach(System.out::println);
		
		myLinkedList.push(10);
		System.out.println("\nJava 8 approach:");
		myLinkedList.forEach(System.out::println);
		
		System.out.println("\nConverting linked list to array");
		Integer[] myArray = myLinkedList.toArray(new Integer[0]);
		for(int i = 0; i < myArray.length; i++) {
			System.out.println(myArray[i]);
		}
		
		
	}

}
