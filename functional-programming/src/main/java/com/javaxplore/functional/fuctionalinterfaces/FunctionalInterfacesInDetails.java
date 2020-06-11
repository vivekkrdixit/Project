package com.javaxplore.functional.fuctionalinterfaces;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionalInterfacesInDetails {

    public static void main(String[] args) {
        List<Integer> nos = List.of(12, 1, 3, 4, 5, 7, 3, 20, 10);
        // Printing squares of all the even numbers in list using steams and lambda.
        System.out.println("***********************************************************************");
        System.out.println("Squares using streams and lambda");
        nos.stream().filter(n -> n % 2 == 0).map(x -> x * x).forEach(System.out::println);

        // How actually code in filter, map and forEach works is they uses functional
        // Interfaces. Refer below code for better understanding

        Predicate<? super Integer> isEvenPredicate = n -> n % 2 == 0;
        Function<? super Integer, ? extends Integer> squareFunction = x -> x * x;
        Consumer<Integer> printConsumer = System.out::println;

        System.out.println("***********************************************************************");
        System.out.println("Squares using variable of  of functional interfaces");
        nos.stream()
                .filter(isEvenPredicate)
                .map(squareFunction)
                .forEach(printConsumer);

        // Logic behind the functional Interface code is as below.

		Predicate<? super Integer> isEvenPredicate1 = new Predicate<Integer>() {

			@Override
			public boolean test(Integer n) {
				return n % 2 == 0;
			}
		};

		Function<? super Integer, ? extends Integer> squareFunction1 = new Function<Integer, Integer>() {

            @Override
            public Integer apply(Integer x) {
                return x * x;
            }
        };
        Consumer<Integer> printConsumer1 = new Consumer<Integer>() {

            @Override
            public void accept(Integer x) {
                System.out.println(x);
            }
        };

        System.out.println("***********************************************************************");
        System.out.println("Squares using inmpementation of interfaces");
        nos.stream()
                .filter(isEvenPredicate1)
                .map(squareFunction1)
                .forEach(printConsumer1);


        Integer sum = nos.stream()
                .filter(isEvenPredicate)
                .reduce(0, Integer::sum);

        System.out.println("Sum using steams and lambda is : " + sum);

        BinaryOperator<Integer> sumBinaryOperator = Integer::sum;

        sum = nos.stream()
                .filter(isEvenPredicate)
                .reduce(0, sumBinaryOperator);

        System.out.println(sum);
        //Implementation of BinaryOperator functional interface;

        sumBinaryOperator = new BinaryOperator<Integer>() {

            @Override
            public Integer apply(Integer a, Integer b) {
                return a + b;
            }
        };

        sum = nos.stream()
                .filter(isEvenPredicate)
                .reduce(0, sumBinaryOperator);

        System.out.println("Sum using implementation of BinaryOperator which is used in reduce: " + sum);
    }

}
