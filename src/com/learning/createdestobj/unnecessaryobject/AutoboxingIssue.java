package com.learning.createdestobj.unnecessaryobject;

public class AutoboxingIssue {

    public static void main(String[] args) {
        System.out.println(calcSum());
        System.out.println(calcSum_Performance());
    }

    public static long calcSum() {
        Long sum = 0L;
        long starttime = System.currentTimeMillis();
        for (int i= 0; i <= 40_000; i++){
            // below statement is a performance bottleneck if sum is a boxed long
            sum += i;
        }
        long stoptime = System.currentTimeMillis();
        System.out.println("Total exec time calcSum : " + (stoptime - starttime ));
        return sum;
    }


    public static long calcSum_Performance() {
        long sum = 0L;
        long starttime = System.currentTimeMillis();
        for (int i= 0; i <= 40_000; i++){
            // below statement is a performance bottleneck if sum is a boxed long
            sum += i;
        }
        long stoptime = System.currentTimeMillis();
        System.out.println("Total exec time calcSum_Performance : " + (stoptime - starttime ));
        return sum;
    }
}
