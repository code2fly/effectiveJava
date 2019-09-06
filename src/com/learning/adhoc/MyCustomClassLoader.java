package com.learning.adhoc;

import com.sun.tools.javac.Main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class MyCustomClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] dataAsByteArrayFromFile = getDataAsByteArrayFromFile("test.txt");
        System.out.println("***************** bytes from file were successfully loaded******");
        Class<?> loadedClass = defineClass("Person", dataAsByteArrayFromFile, 0, dataAsByteArrayFromFile.length);
        System.out.println("**** class successfully loaded from my classloader*****");
        return loadedClass;
    }

    private byte[] getDataAsByteArrayFromFile(String fileName) {
//        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(fileName);
//        this.getClass().getClassLoader().getResourceAsStream("");
        byte[] classDataInBytes = null;
        try {
            String javaSourceCode = Files.lines(Paths.get("test.txt")).collect(Collectors.joining());
            // TODO see how to generate bytecode at runtime here or if there is some other way
            classDataInBytes = compileToByteCode(javaSourceCode);
//            classDataInBytes = Files.readAllBytes(Paths.get("test.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return classDataInBytes;
    }

    private byte[] compileToByteCode(String javaSourceCode) {
        return new byte[0];
    }
}
