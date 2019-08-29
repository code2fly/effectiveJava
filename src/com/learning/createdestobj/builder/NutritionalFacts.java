package com.learning.createdestobj.builder;

/**
 * solution using Builder pattern, which has advantages of telescoping pattern of consistent state
 * and clean creation of JavaBean pattern
 * NutritionalFacts is a immutable class
 */
public class NutritionalFacts {

    private final int servingSize; // required , amount per serving
    private final int servings; // required , number of servings
    private final int calories ; // optional , calories per serving
    private final int totalCalories ; // optional , total calories

    // protected as we do not want someone from outside to call this.
    protected NutritionalFacts(NutritionalFactsBuilder builder) {
        this.servingSize = builder.servingSize;
        this.servings = builder.servings;
        this.calories = builder.calories;
        this.totalCalories = builder.totalCalories;
    }


     static class NutritionalFactsBuilder {

         private final int servingSize;
         private final int servings;

         // assigning default values to optional fields
         private int calories = 0 ; // optional , calories per serving
         private int totalCalories = 0; // optional , total calories

         public NutritionalFactsBuilder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public NutritionalFactsBuilder clories(int cal) {
             this.calories = cal;
             return this;
        }

        public NutritionalFactsBuilder totalCalories(int totalCal) {
             this.totalCalories = totalCal;
             return this;
        }

        public NutritionalFacts build() {
            return new NutritionalFacts(this);
        }
    }

}
