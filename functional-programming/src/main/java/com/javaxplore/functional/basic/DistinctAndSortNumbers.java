package com.javaxplore.functional.basic;

import java.util.Comparator;
import java.util.List;

public class DistinctAndSortNumbers {
	public static void main(String[] args) {
		List<Integer> nos = List.of(1,4,6,8,5,2,6,8,9);
		
		//Print distinct values in list
		
		nos.stream().distinct().forEach(System.out::println);
		
		
		//Print sorted numbers
		System.out.println("Sorted numbers are: ");
		nos.stream().sorted().forEach(System.out::println);
		
		//Sorting numbers using comparator in sorted function.
		System.out.println("Sorted numbers using comparator:");
		nos.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);
		
		//Print distinct sorted numbers
		System.out.println("Distinct Sorted numbers are: ");
		nos.stream().distinct().sorted().forEach(System.out::println);
		
		//Sorting numbers in descending order using comparator in sorted function.
		System.out.println("Sorted numbers in descending order using comparator:");
		nos.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
		
	}

}
