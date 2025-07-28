package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StreamsPractice {

    List<Integer> list;

    public StreamsPractice(){
        list = new ArrayList<>();
        Random random = new Random();
        for(int i=0;i<100;i++){
            list.add(random.nextInt(100));
        }
    }

    public void streamOperations(){

        /* calculating average */
        double avg = list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
        System.out.println("Average: "+avg);

        /* even sum */
        int evenSum = list.stream()
                .mapToInt(Integer::intValue)
                .filter(num -> num%2 == 0)
                .sum();
        System.out.println("Even sum: "+evenSum);

        /* odd sum */
        int oddSum = list.stream()
                .mapToInt(Integer::intValue)
                .filter(num -> num%2 != 0)
                .sum();
        System.out.println("Odd sum: "+oddSum);


    }

}
