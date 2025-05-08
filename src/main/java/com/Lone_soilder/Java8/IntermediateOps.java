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
        // 7.peek
         //performs an action on each element as it is consumed. same as for each loop
         Stream.iterate(1, x-> x+1).limit(20).skip(5).peek(System.out::println).count();
        
         // 8. flatMap
         // handle streams of collections , lists , or arrays where each element is itself a collection means list of list
         // flatten nested structures (e.g. lists within lists) so that they can be processed as a single sequence of elements
         // transform and flatten elements at the same time
        
         List<List<String>> listOfLists = Arrays.asList(
         Arrays.asList("apple", "banana"),
         Arrays.asList("carrot" , "kiwi"),
         Arrays.asList("pear", "grape")
         );
        
         System.out.println(listOfLists.get(1).get(1)); // kiwi
        
         // make every element into uppercase and should be in flat
         List<String> upperCaseFruits = listOfLists.stream().flatMap(x -> x.stream()).map(String::toUpperCase).toList();
         System.out.println(upperCaseFruits); //[APPLE, BANANA, CARROT, KIWI, PEAR, GRAPE]
        
         //example - turn each word into uppercase from the sentence
         List<String> sentences = Arrays.asList(
         "Hello world",
         "java stream is tough",
         "flatmap is nice"
         );
        
         List<String> upperCaseWords =
         sentences
         .stream()
         .flatMap(sentence -> Arrays.stream(sentence.split(" "))
         .map(String::toUpperCase))
         .toList();
         System.out.println(upperCaseWords); //[HELLO, WORLD, JAVA, STREAM, IS, TOUGH, FLATMAP, IS, NICE]
        
        

Maximize 

    }
}
