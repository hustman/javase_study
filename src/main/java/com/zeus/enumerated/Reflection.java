package com.zeus.enumerated;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author xuxingbo
 * @Date 2018/1/20
 */
public class Reflection {
    public static Set<String> analyze(Class<?> enumClass){
        System.out.println("----Analyzing-----" + enumClass + "------");
        System.out.println("Interfaces");
        for (Type type : enumClass.getGenericInterfaces()) {
            System.out.println(type);
        }
        System.out.println("Base: " + enumClass.getSuperclass());
        System.out.println("Methods: ");
        Set<String> methods = new TreeSet<String>();
        for (Method method : enumClass.getMethods()) {
            methods.add(method.getName());
        }
        System.out.println(methods);
        return methods;
    }
    
    public static void main(String[] args) throws IOException, InterruptedException {
        Set<String> exploreMethods = analyze(Explore.class);
        Set<String> enumMethods = analyze(Enum.class);
        System.out.println("Explore.containAll(Enum) " + exploreMethods.containsAll(enumMethods));
        System.out.println("Explore.removeAll(Enum)");
        exploreMethods.removeAll(enumMethods);
        System.out.println(exploreMethods);
        Process process = Runtime.getRuntime().exec("javap Explore");
        int ret = process.waitFor();
        System.out.println("return = " + ret);
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while((line = reader.readLine()) != null){
            System.out.println(line);
        }
        reader.close();
    }
}

enum Explore{
    HERE, THERE
}
