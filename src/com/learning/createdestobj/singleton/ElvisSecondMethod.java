package com.learning.createdestobj.singleton;

/**
 * benefit here is that first if we want to change the internal impl like object per thread then this can be done without changing api doc
 * also this can be used as method reference for Supplier functional interface
 * */
public class ElvisSecondMethod {

    private  static final ElvisSecondMethod INSTANCE = new ElvisSecondMethod();

    private ElvisSecondMethod(){}

    public static final ElvisSecondMethod getInstance() {
        return INSTANCE;
    }

}
