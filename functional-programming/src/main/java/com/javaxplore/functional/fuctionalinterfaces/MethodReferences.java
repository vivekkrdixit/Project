package com.javaxplore.functional.fuctionalinterfaces;

import java.util.List;
import java.util.function.Supplier;

public class MethodReferences {



    public static void main(String[] args) {
        List<String> technologies = List.of("Java", "DevOps", "MicroServices", "Python", "Lambda", "Java8");

        technologies.stream()
                //.map(str -> str.toUpperCase())   //This is a valid syntax
                .map(String::toUpperCase) //This is method referencing for Instance Method.
                .forEach(str -> System.out.println(str)); //This is method referencing for Static methods

        //Below is the example of Constructor referencing.

        Supplier<String>supplier = () -> new String();
        //Above statement can be replaced by constructor referencing as given below.
        Supplier<String> supplier1 = String::new;

    }
}
