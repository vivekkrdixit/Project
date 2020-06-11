package com.javaxplore.functional.stream.custom;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortingExampleUsingStreams {
    public static void main(String[] args) {
        List<Course> courses = List.of(
                new Course("Java", "Language", 99, 20000),
                new Course("Spring", "Framework", 97, 12000),
                new Course("Spring Boot", "Framework", 92, 12000),
                new Course("Python", "Language", 95, 12000),
                new Course("API", "MicroServices", 93, 1200),
                new Course("Microservices", "MicroServices", 96, 12300),
                new Course("Docker", "Cloud", 98, 2000),
                new Course("Kubernetes", "DevOps", 91, 200),
                new Course("Jenkins", "DevOps", 94, 8000),
                new Course("AWS", "Cloud", 91, 10000)
        );

        Comparator<Course> compareByNumberOfStudentsIncreasing = Comparator.comparing(Course::getNoOfStudents);

        List<Course> assendinglySortedCourses = courses.stream().sorted(compareByNumberOfStudentsIncreasing).collect(Collectors.toList());
        System.out.println(assendinglySortedCourses);
        //[Docker:Cloud:98:200, Spring:Framework:97:1200, Kubernetes:DevOps:91:2000, Spring Boot:Framework:92:5000, API:MicroServices:96:6000, Microservices:MicroServices:93:6000, Jenkins:DevOps:94:8000, AWS:Cloud:91:10000, Python:Language:95:12000, Java:Language:99:20000]

        System.out.println("*******************************************************************");
        Comparator<Course> compareByNumberOfStudentsDecreasing = Comparator.comparing(Course::getNoOfStudents).reversed();
        List<Course> decreasingSortedCourses = courses.stream().sorted(compareByNumberOfStudentsDecreasing).collect(Collectors.toList());
        System.out.println(decreasingSortedCourses);
        //[Java:Language:99:20000, Python:Language:95:12000, AWS:Cloud:91:10000, Jenkins:DevOps:94:8000, API:MicroServices:96:6000, Microservices:MicroServices:93:6000, Spring Boot:Framework:92:5000, Kubernetes:DevOps:91:2000, Spring:Framework:97:1200, Docker:Cloud:98:200]

        System.out.println("*******************************************************************");
        Comparator<Course> compareByNumberOfStudentsAndReviewScoreDecreasing =
                Comparator.comparing(Course::getNoOfStudents)
                        .thenComparing(Course::getReviewScore)
                        .reversed();
        List<Course> courseList = courses.stream().sorted(compareByNumberOfStudentsAndReviewScoreDecreasing).collect(Collectors.toList());

        System.out.println(courseList);
        //[Java:Language:20000:99, Microservices:MicroServices:12300:96, Spring:Framework:12000:97, Python:Language:12000:95, Spring Boot:Framework:12000:92, AWS:Cloud:10000:91, Jenkins:DevOps:8000:94, Docker:Cloud:2000:98, API:MicroServices:1200:93, Kubernetes:DevOps:200:91]



        //In above code we are passing primitive arguments in Comparator. This has additional effort of auto-boxing and unboxing
        //To avoid this extra task we have methods which are more efficient like comparingInt as used below.

        Comparator<Course> compareByNumberOfStudentsIncreasing1 = Comparator.comparingInt(Course::getNoOfStudents);

        System.out.println(courses.stream().sorted(compareByNumberOfStudentsIncreasing1).collect(Collectors.toList()));
        System.out.println("*******************************************************************");
        Comparator<Course> compareByNumberOfStudentsDecreasing1 = Comparator.comparingInt(Course::getNoOfStudents).reversed();
        System.out.println(courses.stream().sorted(compareByNumberOfStudentsDecreasing1).collect(Collectors.toList()));
        System.out.println("*******************************************************************");
        Comparator<Course> compareByNumberOfStudentsAndReviewScoreDecreasing1 =
                Comparator.comparingInt(Course::getNoOfStudents)
                        .thenComparingInt(Course::getReviewScore)
                        .reversed();
        System.out.println(courses.stream().sorted(compareByNumberOfStudentsAndReviewScoreDecreasing1).collect(Collectors.toList()));

        System.out.println("*******************************************************************");
        Comparator<Course> compareByTitleLength = Comparator.comparing(course -> course.getName().length());

        System.out.println(courses.stream().sorted(compareByTitleLength).collect(Collectors.toList()));
        //[API:MicroServices:1200:93, AWS:Cloud:10000:91, Java:Language:20000:99, Spring:Framework:12000:97, Python:Language:12000:95, Docker:Cloud:2000:98, Jenkins:DevOps:8000:94, Kubernetes:DevOps:200:91, Spring Boot:Framework:12000:92, Microservices:MicroServices:12300:96]



    }
}
