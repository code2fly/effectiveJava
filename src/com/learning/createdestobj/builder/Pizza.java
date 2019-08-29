package com.learning.createdestobj.builder;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/**
 * this example is to show how to use builder pattern with class hierarchies
 */
public abstract class Pizza {

    public enum TOPPINGS { HAM , MUSHROOM, CHEESE , TOMATO, ONION, PEPPERS }

    final Set<TOPPINGS> toppings ;

    // TODO check if generics can be avoided here ITEM 30 (recursive type param)
    // currently builder is written removing generics but see how can generics help here.
    abstract static class PizzaBuilder {

      EnumSet<TOPPINGS> toppings = EnumSet.noneOf(TOPPINGS.class);

      public PizzaBuilder addTopping(TOPPINGS topping) {
          toppings.add(Objects.requireNonNull(topping));
          return self();
      }

      abstract Pizza build();

      protected abstract PizzaBuilder self();

    }

    Pizza(PizzaBuilder builder) {
        // TODO make sure to check ITEM 50 , to understand defensive copy
        toppings = builder.toppings.clone();
    }

}
