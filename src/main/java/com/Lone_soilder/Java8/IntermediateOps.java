package com.Lone_soilder.Java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntermediateOps {

    public static void main(String[] args) {
        //Intermediate operations transform a stream into another stream , so reatur type is again Stream<>
        // They are lazy , meaning they don't execute until a terminal operation is invoked. ex - forEach() , count() , collect()

        // 1. filter
        List<String> students = Arrays.asList("Ram" , "Amar" , "Sam" , "Amar");
        students.stream().filter(x -> x.endsWith("m")).forEach(System.out::println);

        // 2. map
        Stream<String> addtitle = students.stream().map(x-> "Dr."+x);  // return a stream
        addtitle.forEach(System.out::println);

        //sorted
        Stream<String> sortedStream = students.stream().sorted();
        Stream<String> sortedStreamUsingComparator = students.stream().sorted( (a,b) -> a.length() - b.length());

        sortedStream.forEach(System.out::println);
        sortedStreamUsingComparator.forEach(System.out::println);


        // 4. distinct
        System.out.println("distinct element");
         students.stream().filter(x -> x.startsWith("A")).distinct().forEach(System.out::println);

         //5. limit
        System.out.println(Stream.iterate(1, x->x+2).limit(100).count());

        //6. skip
        System.out.println(Stream.iterate(1, x->x+2 ).limit(20).skip(10).count());

    }
}
