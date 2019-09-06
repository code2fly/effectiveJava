package com.learning.commonmethods.equals;

public final class CaseInsensitiveStringRefactored {

    private final String str;

    public CaseInsensitiveStringRefactored(String str) {
        this.str = str;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof CaseInsensitiveStringRefactored && ((CaseInsensitiveStringRefactored)obj).str.equalsIgnoreCase(str);
    }
}
