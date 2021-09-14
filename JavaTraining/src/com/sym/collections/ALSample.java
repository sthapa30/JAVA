package com.sym.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;


public class ALSample {

	public static void main(String[] args) {
		
		List<String> animals = new ArrayList<String>();
		animals.add("Dog");
		animals.add("Cat");
		animals.add("Kangaroo");
		animals.add(3, "Fish");
		
		List<String> otherAnimals = new ArrayList<String>();
		
		otherAnimals.add("Lion");
		otherAnimals.add("Tiger");
		otherAnimals.add("Dog");
		otherAnimals.add("Cat");
		otherAnimals.add("Fish");
		
		Set<String> set = new LinkedHashSet<String>(animals);
		set.addAll(otherAnimals);
		List<String> mergeList = new ArrayList<String>(set);
		//System.out.println(mergeList);
		Collections.sort(mergeList);
		//System.out.println(mergeList);
		
		List<String> friends = new LinkedList<String>();
		friends.add("Himal");
		friends.add("Bishal");
		friends.add("Rajan");
		friends.add("Sashank");
		System.out.println(friends);
		//Collections.reverse(friends);
		System.out.println(friends);
		//Collections.sort(friends);
		System.out.println(friends);
		LinkedList<String> friendList = new LinkedList<String>(friends);
		//Stack<String> newFriend = new Stack<String>(friendList);
		System.out.println(friendList.peek());
		System.out.println(friendList);
		//System.out.println(friendList.poll());
		System.out.println(friendList);
		Collections.reverse(friendList);
		System.out.println(friendList);
		
		HashSet<String> words = new HashSet<String>();
		words.add("hello");
		words.add("worlds");
		words.add("coding");
		words.add("book");
		
		System.out.println(words);
		
		LinkedHashSet<String> newWord = new LinkedHashSet<String>();
		newWord.add("tree");
		newWord.add("plant");
		newWord.add("baby");
		newWord.add("school");
		System.out.println(newWord);
		
		PriorityQueue<Person> queue = new PriorityQueue<Person>();
		Person p1 = new Person(10,"Kushal");
		Person p2 = new Person(13,"Prakriti");
		Person p3 = new Person(3,"Pranav");
		
		queue.add(p1);
		queue.add(p2);
		queue.add(p3);
		
		
		for(Person p: queue)
		{
			System.out.println(p.getAge() +" " + p.getName());
		}

		
		

	}

}
