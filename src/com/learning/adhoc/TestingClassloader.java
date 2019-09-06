package com.learning.adhoc;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * mainly 3 types of classloaders , Bootstrap(displayed as null because written in native code so no java class present to display hence they can perform different on different JVM's),
 * Extension classloader (loads extension classes that are not part of core java classes),(from $JAVA_HOME/lib/ext)
 * Application loader (this loads our files found in classpath env variable or -cp or -classpath cmd line option)
 * All Java classes are loaded by instances of java.lang.Classloader
 */
public class TestingClassloader {

    public static void main(String[] args) {

        System.out.println("classloader for TestingClassloader is : " + TestingClassloader.class.getClassLoader() );

        System.out.println("classloader for Logger is : " + Logger.class.getClassLoader() );

        // bootstrap is responsible for loading internal classes, typically rt.jar and other classes present $JAVA_HOME/jre/lib
        System.out.println("classloader for ArrayList is : " + ArrayList.class.getClassLoader() );

        // testing my custom classloader
        ClassLoader classLoader = new MyCustomClassLoader();

        try {
            classLoader.loadClass("Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Class.forName("SampleClass");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

}
