package com.javaxplore.functional.stream.custom;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUtilityMethods {
    public static void main(String[] args) {
        List<Course> courses = List.of(
                new Course("Java", "Language", 99, 20000),
                new Course("Spring", "Framework", 97, 12000),
                new Course("Python", "Language", 95, 12000),
                new Course("Docker", "Cloud", 98, 2000),
                new Course("Spring Boot", "Framework", 92, 12000),
                new Course("API", "MicroServices", 93, 1200),
                new Course("Microservices", "MicroServices", 96, 12300),
                new Course("Kubernetes", "DevOps", 91, 200),
                new Course("Jenkins", "DevOps", 94, 8000),
                new Course("AWS", "Cloud", 91, 10000)
        );
        System.out.println("Original list: " + courses);

        //skipAndLimitAndTakeWhileAndDropWhileExecution(courses);

        minAndMaxAndFindFirstAndFindAnyExecution(courses);




    }

    private static void minAndMaxAndFindFirstAndFindAnyExecution(List<Course> courses) {
        System.out.println("*************************************************************");
        
    }

    /**
     * This method show example of skip(), Limit(), takeWhile() and dropWhile() methods of stream.
     * @param courses
     */
    private static void skipAndLimitAndTakeWhileAndDropWhileExecution(List<Course> courses) {
        Comparator<Course> compareByTitleLength = Comparator.comparing(course -> course.getName().length());

        System.out.println("Original list of courses sorted by title: ");
        System.out.println(courses.stream().sorted(compareByTitleLength).collect(Collectors.toList()));

        System.out.println("*************************************************************");

        //Limit method gets max given value of object from the stream.
        List<Course> newCourses = courses.stream().sorted(compareByTitleLength)
                .limit(5)
                .collect(Collectors.toList());
        System.out.println(newCourses);
        System.out.println("*************************************************************");

        newCourses = courses.stream()
                .sorted(compareByTitleLength)
                .skip(2)
                .collect(Collectors.toList());
        System.out.println(newCourses);
        System.out.println("*************************************************************");

        //[Java:Language:20000:99, Spring:Framework:12000:97, Python:Language:12000:95, Docker:Cloud:2000:98, Spring Boot:Framework:12000:92, API:MicroServices:1200:93, Microservices:MicroServices:12300:96, Kubernetes:DevOps:200:91, Jenkins:DevOps:8000:94, AWS:Cloud:10000:91]
        newCourses = courses.stream()
                .takeWhile(course -> course.getReviewScore()>=95)
                .collect(Collectors.toList());


        System.out.println(newCourses);
        System.out.println("*************************************************************");

        //[Java:Language:20000:99, Spring:Framework:12000:97, Python:Language:12000:95, Docker:Cloud:2000:98, Spring Boot:Framework:12000:92, API:MicroServices:1200:93, Microservices:MicroServices:12300:96, Kubernetes:DevOps:200:91, Jenkins:DevOps:8000:94, AWS:Cloud:10000:91]
        newCourses = courses.stream()
                .dropWhile(course -> course.getReviewScore()>=95)
                .collect(Collectors.toList());


        System.out.println(newCourses);
    }
}
