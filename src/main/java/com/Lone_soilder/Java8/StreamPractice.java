package com.Lone_soilder.Java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class StreamPractice {

    public static void main(String[] args) {
        Predicate<Integer> isEven = x -> x % 2 == 0;   // isEven is a variable that hold a condition
        System.out.println(isEven.test(4));

        Predicate<String> isWordStartingWithT = x -> x.startsWith("T");
        Predicate<String> isWordStartingWithi = x -> x.endsWith("i");
        boolean isTrue = isWordStartingWithT.and(isWordStartingWithi).test("Tejaswini");
        System.out.println(isTrue);


        //Function - work something and return
        Function<Integer , Integer>  doubleIt = x -> x*2;
        Function<Integer , Integer> tripleIt = x -> x*3 ;

        doubleIt.apply(20); // return 40

        System.out.println(doubleIt.andThen(tripleIt).apply(20)); //120
        System.out.println(doubleIt.compose(tripleIt).apply(20)); //120
        System.out.println(tripleIt.compose(doubleIt).apply(20));//120

        Function<Integer,Integer> identifyThisNumber =  Function.identity(); // static method so calling with interface Function.identity()
        identifyThisNumber.apply(5); // nothing but will return same value

        //consumer
        Consumer<Integer> consumer = x -> System.out.println("consumer is printing "+ x);
        consumer.accept(100);

        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Consumer<List<Integer>> consumer1 = x -> {
            for(int i : x){
                System.out.println(i+"th value of list is " + i);
            }
        };

        consumer1.accept(list);

        //supplier - takes nothing but return something when you call

        Supplier<String> giveMeHello = () -> "hellooo";  // return hello
        System.out.println(giveMeHello.get());

        //combined example
        Predicate<Integer> isOdd = x -> x % 2 != 0;
        Function<Integer , Integer> add = x -> x+x ;
        Consumer<Integer> print = x -> System.out.println(x);
        Supplier<Integer> supplier = () -> 7;


        if (isOdd.test(supplier.get())){
            print.accept(add.apply(supplier.get()));
        }

        //
        BiPredicate<Integer , Integer > sumIsEven = (x,y) -> (x + y) % 2 == 0;
        BiConsumer<Integer , Integer> printNum = (x,y) -> {
            System.out.println(x);
            System.out.println(y);
        };
        BiFunction<Integer , Integer , Integer > addTwoNum = (x,y) -> x+y;

        if (sumIsEven.test(2,2)){
            printNum.accept(addTwoNum.apply(2,2),addTwoNum.apply(2,3));
        }

        UnaryOperator<Integer> unaryOperator = x -> x * 2 ;
        print.accept(unaryOperator.apply(33));

        BinaryOperator<String> printMyName = (x,y) -> x+ " weds" + y;
        System.out.println(printMyName.apply("kunu" , "guggi"));








    }

}
