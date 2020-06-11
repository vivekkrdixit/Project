package com.javaxplore.functional.fuctionalinterfaces;

import java.util.List;
import java.util.Random;
import java.util.function.*;

public class FunctionalInterfaceExample {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        final List<Integer> integers = List.of(4, 5, 9, 14, 2, 5, 15, 12);

        Predicate<Integer> isEvenPredicate = x -> x % 2 == 0;

        Function<Integer, Integer> squareFunction = x -> x * x;

        Consumer<Integer> sysOutConsumer = System.out::println;

        BinaryOperator<Integer> addBinaryOperator1 = (Integer x, Integer y) -> x + y;

        //In above statement we have type of arguments mentioned in round brackets. I do not have to mention this as this id inferred
        // from the type of Object of BinaryOperator. This is called as <b>Type Inference<b>.
        BinaryOperator<Integer> addBinaryOperator = Integer::sum;

        //More types of Functional Interfaces
        /* Supplier interface doesn't take any argument in it. Hence we used empty round braces*/
        Supplier<Integer> integerSupplier = () -> 2;

        Supplier<Integer> randomIntegerSupplier = () -> {
            Random random = new Random();
            return random.nextInt(1000);
        };

        //UnaryOperator
        UnaryOperator<Integer> unaryOperator = (x) -> 3 * x;

        System.out.println(unaryOperator.apply(10));

        //BiPredicate: We have two predicates and it returns boolean value.
        BiPredicate<Integer, String> equalityBiPredicate = (number, str) -> true;

        System.out.println(equalityBiPredicate.test(5, "5"));

        BiPredicate<Integer, String> biPredicate = (number, str) -> number < 10 && str.length() < 10;

        System.out.println("BiPredicate Example:");
        System.out.println(biPredicate.test(5, "Pranit"));

        //BiFunction: This takes two parameter which can return third type of object type.

        BiFunction<Integer,String,String> integerStringBiFunction = (number, str) -> number + " " + str;
        System.out.println(integerStringBiFunction.apply(Integer.valueOf(5),"String Value"));


        //BiConsumer

        BiConsumer<Integer, String> integerStringBiConsumer = (x,y) ->{
            System.out.println(x);
            System.out.println(y);
        };

        integerStringBiConsumer.accept(Integer.valueOf(1), "Test String");


    }


}
