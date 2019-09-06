package com.learning.commonmethods.equals;

import java.util.Objects;

public class ColorPoint extends Point {

    private final String color ;

    public ColorPoint(int x, int y, String color) {
        super(x, y);
        this.color = color;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || (obj.getClass() != Point.class || obj.getClass() != ColorPoint.class )) return false;
        if (obj.getClass() == Point.class) return super.equals(obj);
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color);
    }
}
