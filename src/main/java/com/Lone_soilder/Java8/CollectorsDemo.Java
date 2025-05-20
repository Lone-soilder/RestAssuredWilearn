package com.Lone_soilder.Java8;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorsDemo {
 public static void main(String[] args) {

 // collectors is a utility class
 // provides a set of methods to create common collectors

 List<String> names = Arrays.asList("ram", "sam", "papun", "teju");
 List<String> result = names.stream().filter(x -> x.endsWith("m")).collect(Collectors.toList());
 System.out.println(result);

 // collecting to a set
 List<Integer> nums = Arrays.asList(1,2,2,2,3,3,4,4,6,5,6,7,8,9,10);
 Set<Integer> set = nums.stream().collect(Collectors.toSet());
 System.out.println(set);

 // collecting to a specific collection
 ArrayDeque<String> collect = names.stream().collect(Collectors.toCollection(() -> new ArrayDeque<>()));
 //or
 ArrayDeque<String> collect1 = new ArrayDeque<>(names);

 // joining String - concatenate stream element into single string
 String allName = names.stream().map(String::toUpperCase).collect(Collectors.joining());
 System.out.println("names are joined " + allName); //names are joined RAMSAMPAPUNTEJU

 // summarizing data
 //generates statistical summary (count , sum , min , average, max)

 List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 6, 11);
 IntSummaryStatistics stats = numbers.stream().collect(Collectors.summarizingInt(x -> x + 1)); // return as (3,4,5,6,12)
 System.out.println("count "+ stats.getCount() );
 System.out.println("sum " + stats.getSum());
 System.out.println("min " + stats.getMin());
 System.out.println("average " + stats.getAverage() );
 System.out.println("Max "+ stats.getMax());


 //calculating averages
 Double average = numbers.stream().collect(Collectors.averagingInt(x -> x));
 System.out.println("average - " + average);

 //counting elements
 Long count = numbers.stream().collect(Collectors.counting());
 System.out.println(count); //6

 // grouping elements
 List<String> words = Arrays.asList("hello", "java", "stream", "collecting", "world");
 Map<Integer, List<String>> wordGroup = words.stream().collect(Collectors.groupingBy(String::length));
 System.out.println(wordGroup); //{4=[java], 5=[hello, world], 6=[stream], 10=[collecting]}

 System.out.println(
 words.stream().collect(Collectors.groupingBy(String::length, Collectors.joining(" , "))));
 //{4=java, 5=hello , world, 6=stream, 10=collecting}

 System.out.println(words.stream().collect(Collectors.groupingBy(String::length , Collectors.counting())));
 //{4=1, 5=2, 6=1, 10=1}

 TreeMap<Integer, Long> treeMap = words.stream().collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.counting()));
 System.out.println(treeMap);
 //{4=1, 5=2, 6=1, 10=1}

  System.out.println(treeMap);

 // Partitioning Elements
 // Partitions elements into two groups (true and false) based on predicate

 Map<Boolean, List<String>> wordsOfLengthFive = words.stream().collect(Collectors.partitioningBy(x -> x.length() < 6));
 System.out.println(wordsOfLengthFive); //{false=[stream, collecting], true=[hello, java, world]}

 //Mapping and Collecting
 //map something before you collect
 System.out.println(words.stream().collect(Collectors.mapping(String::toUpperCase , Collectors.toList()))); //[HELLO, JAVA, STREAM, COLLECTING, WORLD]


 //collecting by length
 words.stream().collect(Collectors.groupingBy(String::length));

 // counting word occurrence
 String sentence = " hello world hello java world "; //trim() to remove space from first and last
 Map<String, Long> wordOccurrence = Arrays.stream(sentence.trim().split(" ")).collect(Collectors.groupingBy(x -> x, Collectors.counting()));
 System.out.println(wordOccurrence); //{java=1, world=2, hello=2}

 //partitioning by even and odd
 List<Integer> list = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9);
 System.out.println(list.stream().collect(Collectors.groupingBy(x -> x%2 == 0 ))); //{false=[3, 5, 7, 9], true=[2, 4, 6, 8]}

 //summing values in a map

 Map<String , Integer> items = new HashMap<>();
 items.put("Apple" , 10);
 items.put("Orange", 20);
 items.put("banana" , 30);
 System.out.println(items.values().stream().reduce(Integer::sum));
 System.out.println( items.values().stream().collect(Collectors.summingInt(x -> x)));

 //example - creating a map from stream elements
 List<String> fruits = Arrays.asList("apple", "banana", "kiwi", "pinnacle", "grapes");
 Map<String, Integer> fruitsMap = fruits.stream().collect(Collectors.toMap(x -> x.toUpperCase(), x -> x.length()));
 System.out.println(fruitsMap); //{GRAPES=6, APPLE=5, KIWI=4, PINNACLE=8, BANANA=6}

 // example - if multiple apple in lists
// List<String> fruitList = Arrays.asList("apple" , "banana","apple", "kiwi", "pinnacle","apple");
// Map<String, String> collect2 = fruitList.stream().collect(Collectors.toMap(k -> k, v -> 1, (x, y) -> x + y));
// System.out.println(collect2);




 }
}
