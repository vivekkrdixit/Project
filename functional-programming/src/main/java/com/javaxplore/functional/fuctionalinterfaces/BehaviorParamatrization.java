package com.javaxplore.functional.fuctionalinterfaces;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BehaviorParamatrization {

    public static void main(String[] args) {
        List<Integer> nos = List.of(12, 1, 3, 4, 5, 7, 3, 20, 10);

        nos.stream()
                .filter(x -> x % 2 == 0)
                .forEach(System.out::println);
        System.out.println("*****************************************************");
        nos.stream()
                .filter(x -> x % 2 != 0)
                .forEach(System.out::println);

        filterAndPrint(nos, x -> x % 2 == 0); // Filter is for Even number

        System.out.println("Printing values of numbers who are multiple of 3");
        filterAndPrint(nos, x -> x % 3 == 0); // Filter is for multiples of 3


        //Example of Behaviour Parametrization
        Function<Integer, Integer> squareFunction = x -> x * x;
        final List<Integer> squares = getListOfNumberToPower(nos, squareFunction);

        squares.stream().forEach(System.out::println);

        Function<Integer, Integer> cubeFunction = integer -> integer * integer * integer;
        final List<Integer> cubes = getListOfNumberToPower(nos, cubeFunction);

        cubes.stream().forEach(System.out::println);
    }

    private static List<Integer> getListOfNumberToPower(List<Integer> nos, Function<Integer, Integer> squareFunction) {
        return nos.stream()
                .map(squareFunction)
                .collect(Collectors.toList());
    }

    /**
     * This method demonstrates how we can pass a method logic as an parameter to a method/function. This is called as
     * Behavioural Paramerization/
     *
     * @param numbers   List which will be iterated.
     * @param predicate This is the filter condition we are passing as argument.
     */
    private static void filterAndPrint(List<Integer> numbers, Predicate<? super Integer> predicate) {
        numbers.stream()
                .filter(predicate)
                .forEach(System.out::println);
    }

}
