package com.learning.createdestobj.builder;

public class BuilderDemo {

    public static void main(String[] args) {

        NutritionalFacts nutritionalFacts = new NutritionalFacts.NutritionalFactsBuilder(20,100)
                                            .clories(200)
                                            .totalCalories(10000)
                                            .build();

    }

}
