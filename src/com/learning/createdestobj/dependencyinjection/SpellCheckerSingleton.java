package com.learning.createdestobj.dependencyinjection;

/**
 * like static utility it is also not uncommon to see such classes which depend on other class
 * to see them implemented as singleton
 * but again this approach is inflexible and untestable
 */
public class SpellCheckerSingleton {

    private final Lexicon dictionary = new Lexicon();

    public static final SpellCheckerSingleton INSTANCE = new SpellCheckerSingleton();

    private SpellCheckerSingleton() {}

    public boolean isValid(String word) {
        return dictionary.isValid(word);
    }



}


