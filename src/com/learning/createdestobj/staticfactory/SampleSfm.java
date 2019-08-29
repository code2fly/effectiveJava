package com.learning.createdestobj.staticfactory;

import java.io.IOException;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.util.Date;

public class SampleSfm {

    public static Boolean valueOf(boolean b) {
        return b ? Boolean.TRUE : Boolean.FALSE;
    }


    public static void main(String[] args) {

        // since there is no clear way to understand
        Date from = Date.from(Instant.now());

        BigInteger.valueOf(Integer.MAX_VALUE);
        Array.newInstance(String.class, 2);

        StackWalker.getInstance();
        try {
            Files.getFileStore(Path.of(""));
        } catch (IOException e) {
            e.printStackTrace();
        }



    }



}
