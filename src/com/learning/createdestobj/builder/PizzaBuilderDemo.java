package com.learning.createdestobj.builder;

import java.lang.reflect.AccessibleObject;

public class PizzaBuilderDemo {

    public static void main(String[] args) {

        // lets start by building new york pizza
        Pizza nypizza = new NYPizza.NYPizzaBuilder(NYPizza.SIZE.MEDIUM)
                .addTopping(Pizza.TOPPINGS.HAM)
                .addTopping(Pizza.TOPPINGS.CHEESE)
                .build();

        // lets now build delhi pizza
        Pizza delhiPizza = new DelhiPizza.DelhiPizzaBuilder(Boolean.TRUE)
                .addTopping(Pizza.TOPPINGS.CHEESE)
                .addTopping(Pizza.TOPPINGS.ONION)
                .addTopping(Pizza.TOPPINGS.MUSHROOM)
                .build();



    }
}
