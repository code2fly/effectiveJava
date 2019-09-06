package com.learning.commonmethods.equals;

public class EquivalenceSymmetryDemo {

    public static void main(String[] args) {

        CaseInsensitiveString cis = new CaseInsensitiveString("POLICY");
        String str = "policy";
        // below symmetry is voilated as cis.equals(str) is true but the reverse is not
        System.out.println(cis.equals(str));
//        System.out.println(str.equalsIgnoreCase(cis));


    }

}
