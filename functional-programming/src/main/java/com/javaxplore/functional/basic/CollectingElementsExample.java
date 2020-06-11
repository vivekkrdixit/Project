package com.javaxplore.functional.basic;

import java.util.List;
import java.util.stream.Collectors;

public class CollectingElementsExample {
	
	public static void main(String[] args) {
		List<Integer> nos = List.of(1,2,3,4,5,6,7,8,9,10);
		
		List<Integer> doubledNumbers = doubleNumbers(nos);
		
		doubledNumbers.forEach(System.out::println);

		System.out.println("All even numbers collected are: ");
		List<Integer> evenNumbersOnly = nos.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
		evenNumbersOnly.forEach(System.out::println);
	}

	private static List<Integer> doubleNumbers(List<Integer> nos) {
		
		return nos.stream().map(n -> n * 2).collect(Collectors.toList());
		
	}

}
