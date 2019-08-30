package com.learning.createdestobj.singleton;

import java.io.Serializable;

/**
 * a singleton if required to be serializable then only adding a 'implements Serializable' is not enough
 * all the fields need to be made transient and also, provide readResolve method so during deserialization of serialized
 * object a new object does not gets created.
 */
public class ElvisSerializable implements Serializable {

    public static final ElvisSerializable INSTANCE = new ElvisSerializable();

    private ElvisSerializable() {}

    private Object readResolve() {
        // return the only true ElvisSerializable and let GC take care of impersonator ElvisSerializable
        return INSTANCE;
    }


}
