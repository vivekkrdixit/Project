package com.javaxplore.functional.stream.custom;

import java.util.List;
import java.util.function.Predicate;

public class AllNoneAnyMatchExample {
    public static void main(String[] args) {
        List<Course> courses = List.of(
                new Course("Java", "Language", 99, 20000),
                new Course("Spring", "Framework", 97, 1200),
                new Course("Spring Boot", "Framework", 92, 5000),
                new Course("Python", "Language", 95, 12000),
                new Course("API", "MicroServices", 96, 1100),
                new Course("Microservices", "MicroServices", 93, 6000),
                new Course("Docker", "Cloud", 98, 200),
                new Course("Kubernetes", "DevOps", 91, 2000),
                new Course("Jenkins", "DevOps", 94, 8000),
                new Course("AWS", "Cloud", 91, 10000)
        );

        //allMatch, noneMatch, anyMatch

        Predicate<Course> reviewScoreGreaterThan95Predicate = course -> course.getReviewScore() > 95;
        Predicate<Course> reviewScoreGreaterThan90Predicate = course -> course.getReviewScore() > 90;
        Predicate<Course> reviewScoreLessThan90Predicate = course -> course.getReviewScore() < 90;

        System.out.println(courses.stream().allMatch(reviewScoreGreaterThan95Predicate));

        System.out.println(courses.stream().noneMatch(reviewScoreLessThan90Predicate));

        System.out.println(courses.stream().anyMatch(reviewScoreLessThan90Predicate));

        System.out.println(courses.stream().anyMatch(reviewScoreGreaterThan90Predicate));





    }
}
