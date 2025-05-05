package com.Lone_soilder.Java8;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamPractice2 {


    public static void main(String[] args) {
        //creating stream
        //1. from collection
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Stream<Integer> stream = list.stream();

        // 2. from Arrays
        String[] strings = {"a" , "b" , "c"};
        Stream<String> stream1 =  Arrays.stream(strings);

        // 3. Using Stream.of()
        Stream<String> stream2 = Stream.of("abc" , "def");

        // 4. infinite stream
        Stream<Integer> generate = Stream.generate(() -> 1);

        List<Integer> iterator = Stream.iterate(0 , x->x+1).limit(100).collect(Collectors.toList());
        System.out.println(iterator);
    }







}
