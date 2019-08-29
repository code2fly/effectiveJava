package com.learning.createdestobj.builder;

/**
 * telescoping constructor pattern, initial solution to solve assignment of many optional params
 */
public class NutritionalFactsTelescoping {

    private int servingSize; // required , amount per serving
    private int servings; // required , number of servings
    private int calories ; // optional , calories per serving
    private int totalCalories ; // optional , total calories

    public NutritionalFactsTelescoping(int servingSize, int servings) {
       this(servingSize, servings, 0);
    }

    public NutritionalFactsTelescoping(int servingSize, int servings, int calories) {
        this(servingSize, servings, calories,0);
    }

    public NutritionalFactsTelescoping(int servingSize, int servings, int calories, int totalCalories) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.totalCalories = totalCalories;
    }
}
