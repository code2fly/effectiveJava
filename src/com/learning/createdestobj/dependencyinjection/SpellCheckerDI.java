package com.learning.createdestobj.dependencyinjection;

import java.util.Objects;

/**
 * spellchecker using Constructor DI, now every client while creating object of SpellChecker and specify the type
 * of dictionary it wants.
 */
public class SpellCheckerDI {

    private final Lexicon dictionary ;

    // Dependency dictionary is injected to SpellChecker
    public SpellCheckerDI(Lexicon dictionary) {
        this.dictionary = Objects.requireNonNull(dictionary);
    }

    public boolean isValid(String word) {
        return dictionary.isValid(word);
    }

}
