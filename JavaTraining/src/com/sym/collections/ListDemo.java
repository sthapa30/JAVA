package com.sym.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ListDemo {

	public static void main(String[] args) {

		List<String> strList = Arrays.asList("apple", "ball", "aaa", "bbb", "cat");
		Map<Character, List<String>> strMap = groupBy(strList);
		System.out.println(strMap);

	}

	public static Map<Character, List<String>> groupBy(List<String> strList) {
		return null;
		//

	}

}
