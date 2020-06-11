package com.javaxplore.functional.basic;

import java.util.List;

public class IterateListOfNumbers {
	public static void main(String[] args) {
		List<Integer> numbers = List.of(10,15,8,5,2,1,20,17,5,2,1,22);
		printAllNumbersInList(numbers);
		System.out.println("Even numbers are:");
		printEvenNumbersInList(numbers);
		System.out.println("Odd numbers are:");
		printOddNumbersInList(numbers);
		
		System.out.println("Square of numbers are:");
		printSquaresOFNumbers(numbers);
		System.out.println("Cubes of odd numbers are:");
		printCubesOFOddNumbers(numbers);
	}

	private static void printEvenNumbersInList(List<Integer> numbers) {
		numbers.stream().filter(n-> n%2==0).forEach(System.out::println);
		
	}
	
	private static void printOddNumbersInList(List<Integer> numbers) {
		numbers.stream().filter(n-> n%2==1).forEach(System.out::println);
		
	}

	private static void printAllNumbersInList(List<Integer> integers) {
		integers.stream()  //Stream gives a stream of integers. Hence we get one by one integer from the stream.
		.forEach(System.out::println); //Syntax for method reference.		
	}
	
	private static void printSquaresOFNumbers(List<Integer> integers) {
		integers.stream()  //Stream gives a stream of integers. Hence we get one by one integer from the stream.
		.map(number -> number * number)
		.forEach(System.out::println); //Syntax for method reference.		
	}
	
	private static void printCubesOFOddNumbers(List<Integer> integers) {
		integers.stream()  //Stream gives a stream of integers. Hence we get one by one integer from the stream.
		.filter(n -> n%2 == 1)  // Filter each number using the condition given.
		.map(number -> "Cube of " + number +" is " + number * number * number)
		.forEach(System.out::println); //Syntax for method reference.		
	}
	
	

}
