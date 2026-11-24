package com.pluralsight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamNumberApp {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(
                42, 17, 89, 5, 63, 28, 94, 11, 76, 35,
                52, 8, 71, 46, 23, 99, 14, 67, 31, 85,
                3, 58, 92, 19, 74, 40, 6, 81, 27, 55,
                96, 12, 69, 33, 87, 21, 60, 48, 9, 78,
                36, 91, 15, 64, 2, 83, 50, 25, 72, 44
        ));

        //print the numbers
//        numbers.stream().forEach(System.out::println);

        //print only the number greater than 40
        numbers.stream()
                .filter(number -> number > 40)
                .forEach(System.out::println);

          //for loop of the above stream
//        for (Integer number : numbers) {
//            if(number < 40 ) continue;
//            System.out.println(number);
//        }

        //add all the numbers together
//       int total = numbers.stream()
//                .filter(number -> number > 40)
//                .mapToInt(number -> number.intValue())
//                .sum();

        //using reduce to do the above with .sum()
        int total = numbers.stream()
                .filter(number -> number > 40)
                .mapToInt(number -> number.intValue())
                .reduce(0, Integer::sum);

       System.out.println(total);

       //create a new list of only numnbes over 70
       List<Integer> numsOver70 = numbers.stream()
               .filter(number -> number > 70)
               .toList();

        System.out.println("========== numbers over 70 ==========");
       numsOver70.stream()
               .sorted()
               .forEach(System.out::println);

       //average all the numbers over 70
        double average = numsOver70.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);

        System.out.println("average is for numbers over 70: " + average);


        //find the largest number
        System.out.println("biggest number: " +
                numbers.stream().mapToInt(Integer::intValue).max().orElse(0)
        );

        System.out.println("biggest number: " +
                numbers.stream().mapToInt(Integer::intValue).min().orElse(0)
        );


    }


}
