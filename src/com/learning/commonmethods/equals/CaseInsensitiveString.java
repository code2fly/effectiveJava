package com.learning.commonmethods.equals;

import java.util.Objects;

public final class CaseInsensitiveString {

    private final String s;

    public CaseInsensitiveString(String str) {
        this.s = Objects.requireNonNull(str);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof CaseInsensitiveString) {
            return s.equalsIgnoreCase(((CaseInsensitiveString)obj).s);
        }
        // One way interoperability!! since when equals method is called from normal string it will use string
        // equals method and this will not be equal
        if(obj instanceof String) {
            return s.equalsIgnoreCase((String)obj);
        }
        return false;
    }


}
