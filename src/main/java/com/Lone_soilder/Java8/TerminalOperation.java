package com.Lone_soilder.Java8;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class TerminalOperation {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);

        //collect
        list.stream().skip(1).collect(Collectors.toList());
        list.stream().skip(1).toList();

        //2 . forEach
        list.stream().forEach(System.out::println);

        //3. reduce : combine s Elements  to produce to single result
        Optional<Integer> optionalInteger= list.stream().reduce((x, y) -> x+y);
        System.out.println(optionalInteger.get());

        // 4. count

        // 5. anymatch , allmatch , nonematch

        System.out.println(list.stream().anyMatch(x -> x%2 ==0)); //true
        System.out.println(list.stream().allMatch(x -> x<10)); //true
        System.out.println(list.stream().noneMatch(x -> x<0)); //true

        // 6. findFirst , findAny
        System.out.println(list.stream().findFirst().get());
        System.out.println(list.stream().findAny().get());

        //example : filtering and collecting names
        List<String> names = Arrays.asList("Anna" , "Bob" , "Charlie" , "David");
        System.out.println(names.stream().filter(x -> x.length()>3).toList());

        //example : squaring and sorting numbers
        List<Integer> numbers = Arrays.asList(5,2,9,1,6);
        System.out.println(numbers.stream().map(x -> x*x).sorted().toList());

        //example : summing values
        System.out.println(numbers.stream().reduce(Integer::sum).get());

        //example ::counting occurrence of a character
        System.out.println("l occurs"+"hello world".chars().filter(x -> x=='l').count());
        countOccurence("hello world");








    }

    public static void countOccurence(String sentence){

        Map<Character , Integer> map = new HashMap<>();

        String[] words = sentence.split(" ");
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    map.put(c, 1);
                }
            }
        }

        for (char c: map.keySet()){
            System.out.println(c +" -> "+map.get(c));
        }
    }
}
