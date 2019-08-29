package com.learning.createdestobj.builder;

public class NYPizza extends Pizza {

    public enum SIZE { SMALL, MEDIUM , LARGE};

    private final SIZE size;

    public static class NYPizzaBuilder extends PizzaBuilder {

        private final SIZE size;

        public NYPizzaBuilder(SIZE size) {
            this.size = size;
        }

        @Override
        NYPizza build() {
            return new NYPizza(this);
        }

        @Override
        protected NYPizzaBuilder self() {
            return this;
        }
    }

    public NYPizza(NYPizzaBuilder builder) {
        super(builder);
        this.size = builder.size;
    }
}
