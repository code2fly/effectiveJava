package com.learning.createdestobj.singleton;

/**
 *  A single element enum type is often the best way to implement Singleton
 *   this is similar to public field approach. but this is more concise,
 * provides the serialization machinery for free (TODO check how serialization works with enums??)
 * plus provides a guarantee against multiple instantiation
 */
public enum ElvisThirdPreferred {


    INSTANCE;

    public void leaveTheBuilding() {

    }
}
