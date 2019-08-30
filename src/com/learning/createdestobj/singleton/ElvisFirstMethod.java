package com.learning.createdestobj.singleton;

/**
 * benefit of this method is that it is easy to recognize that this is a singleton from API doc
 */
public class ElvisFirstMethod {

    public static final ElvisFirstMethod INSTANCE = new ElvisFirstMethod();

    private ElvisFirstMethod() {}


}
