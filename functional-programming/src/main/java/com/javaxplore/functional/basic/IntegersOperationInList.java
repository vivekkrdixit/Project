package com.javaxplore.functional.basic;

import java.util.List;

public class IntegersOperationInList {
	public static void main(String[] args) {
		List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		int sum = addNumbersInList(numbers);
		System.out.println("Addition of all numbers is: " + sum);
		
		int min = findMin(numbers);
		System.out.println("Minimum value present is : " + min);
		
		int max = findMax(numbers);
		System.out.println("Maximum value present is : " + max);
	}

	private static int findMax(List<Integer> numbers) {
		return numbers.stream().reduce(Integer.MIN_VALUE, (a , b) -> a > b ? a : b );
				}

	private static int sum(int aggregate, int nextNumber) {
		// This is how the reduce works. It aggregates the result to one.
		// 0 1
		// 1 2
		// 3 3
		// 6 4
		// 10 5
		// 15 6
		// 21 7
		// 28 8
		// 36 9
		// 45 10
		// 55
		return aggregate + nextNumber;
	}

	private static int addNumbersInList(List<Integer> numbers) {
		/* This is the way if we use above method. */
		//return numbers.stream().reduce(0, AddingIntegersInList::sum); 

		/* We can use lambda function instead of using sum method. */
		//return numbers.stream().reduce(0, (a, b) -> a + b);
		
		/* This is the way by which we can use the method reference of Integer class sum method. */
		return numbers.stream().reduce(0, Integer::sum);
	}
	
	private static int findMin(List<Integer> numbers) {
		return numbers.stream().reduce(Integer.MAX_VALUE, (a , b) -> a > b ? b : a);
	}

}
