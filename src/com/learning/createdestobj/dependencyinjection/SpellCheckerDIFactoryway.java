package com.learning.createdestobj.dependencyinjection;

import java.util.function.Supplier;

public class SpellCheckerDIFactoryway {

    private final Lexicon dictionary;

    // TODO how is Supplier best for factory methods if there is no argument to decide which factory object to return from the factory.
    public SpellCheckerDIFactoryway(Supplier<? extends Lexicon> dictionaryFactory) {
        this.dictionary = dictionaryFactory.get();
    }


}
