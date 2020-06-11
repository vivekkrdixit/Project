package com.practise.general;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LoosingSquence {

	public static void main(String[] args) {

		int[] values = {3, 6, 36, 32, 32, 121, 66, 24, 22, 371, 661, 6, 4, 8};// readValues();
		int loss = processArray(values);
		System.out.println(loss);
	}

	private static int processArray(int[] valueArray) {
		
		List<List<Integer>> combinations = new ArrayList<List<Integer>>();
		int loss = 0;
		for (int i = 0; i < valueArray.length; i++) {
			List<Integer> subSet = new ArrayList<Integer>();
			subSet.add(valueArray[i]);
			for (int j = i + 1; j < valueArray.length; j++) {
				if (valueArray[j] < valueArray[i] && valueArray[j] < valueArray[j - 1]) {
					subSet.add(valueArray[j]);
				} else {
					break;
				}
			}
			if (subSet.size() > 1) {
				combinations.add(subSet);
			}
		}

		Map<Integer, List<Integer>> sizeAndLists = new HashMap<Integer, List<Integer>>();
		for (List<Integer> list : combinations) {
			sizeAndLists.put(list.size(), list);
		}
		Integer maxSize = Collections.max(sizeAndLists.keySet());
		List<Integer> list = sizeAndLists.get(maxSize);

		loss = list.get(0) - list.get(list.size() - 1);
		return loss;
	}

	private static List<Integer> readValues() {
		List<Integer> list = new ArrayList<Integer>();
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Provide number and hit Enter. To stop feeding number add any negative number: ");
			int value = -1;
			do {
				value = scanner.nextInt();
				if (value < 0) {
					break;
				}
				list.add(value);
			} while (value >= 0);
		}
		return list;
	}

}