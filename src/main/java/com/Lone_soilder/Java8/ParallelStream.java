package com.Lone_soilder.Java8;

import java.util.List;
import java.util.stream.Stream;

public class ParallelStream {
    // allow multiple threads to process parts of the stream simultaneously
    // This can significantly use to improve of large dataset
    // workload is distributed across multiple threads

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        List<Integer> list = Stream.iterate(1, x -> x + 1).limit(20000).toList();
        List<Long> factorialList = list.stream().map(ParallelStream::factorial).toList();
        long endTime = System.currentTimeMillis();
        System.out.println( "total time taken for sequential : " + (endTime - startTime) + " ms" );

        startTime = System.currentTimeMillis();
        factorialList = list.parallelStream().map(ParallelStream::factorial).toList();
        endTime = System.currentTimeMillis();
        System.out.println( "total time taken for parallel : " + (endTime - startTime) + " ms" );






    }

    public static long factorial(int n){
        long factorialNum = 1;
        for (int i = 2; i <= n ; i++){
            factorialNum *= i;
        }

        return factorialNum;
    }
}
