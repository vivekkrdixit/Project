package com.javaxplore.functional.fuctionalinterfaces;

import java.util.function.IntBinaryOperator;
import java.util.function.IntToLongFunction;

public class IntFunctionalInterface {

    /*Int functional interfaces are the interfaces which work on primitive type.
     * Using regular functional interfaces while working with primitive types have an
     * additional step of autoboxing and unboxing. To remove this specific functional
     * interfaces are very useful.
     */

    public static void main(String[] args) {

        IntBinaryOperator intBinaryOperator = (x, y) -> x + y;

        System.out.println(intBinaryOperator.applyAsInt(5,9));

        IntToLongFunction intToLongFunction = x -> x*x*x;
        long cubeValue = intToLongFunction.applyAsLong(5);
        System.out.println(cubeValue);
    }


}
