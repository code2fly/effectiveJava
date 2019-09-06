package com.learning.commonmethods.equals;

public class PointTransitiveDemo {

    public static void main(String[] args) {

        Point p1 = new Point(2,3);
        Point p2 = new Point(2,3);
        Point p3 = new Point(2,2);

        System.out.println(p1.equals(p2));
        System.out.println(p1.equals(p3));
    }
}
