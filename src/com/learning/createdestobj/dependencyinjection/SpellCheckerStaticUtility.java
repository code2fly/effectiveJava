package com.learning.createdestobj.dependencyinjection;

/**
 * SpellChecker depends on dictionary, it is not uncommon to see such classes implemented as static utility,
 * but this usage is inflexible and untestable  // TODO check why untestable(just because it cannot be replaced by a mock??)
 */
public class SpellCheckerStaticUtility {

    private static final Lexicon dictionary = new Lexicon();
    private SpellCheckerStaticUtility(){}

    public static boolean isValid(String word) {
        // use dictionary to check if it is a valid word in it
        return dictionary.isValid(word);
    }
    // and few other static methods that use dictionary

}

class Lexicon {

    public boolean isValid(String word ) {
        return false;
    }

}
