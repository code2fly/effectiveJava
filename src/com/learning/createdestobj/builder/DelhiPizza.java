package com.learning.createdestobj.builder;

public class DelhiPizza extends Pizza {

    private boolean isSpicy;

    public DelhiPizza(DelhiPizzaBuilder builder) {
        super(builder);
        this.isSpicy = builder.isSpicy;
    }

    public static class DelhiPizzaBuilder extends PizzaBuilder {
        private boolean isSpicy;

        public DelhiPizzaBuilder(boolean isSpicy) {
            this.isSpicy = isSpicy;
        }

        @Override
        Pizza build() {
            return new DelhiPizza(this);
        }

        @Override
        protected PizzaBuilder self() {
            return this;
        }
    }
}
