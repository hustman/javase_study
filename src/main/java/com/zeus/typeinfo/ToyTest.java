package com.zeus.typeinfo;

/**
 * @author xuxingbo
 * @Date 2018/1/24
 */
public class ToyTest {
    static void printInfo(Class cc){
        System.out.println("========== INFO ================");
        System.out.println("Class name " + cc.getName()
                + " is interface? [" + cc.isInterface() + "]");
        System.out.println("Simple Name: " + cc.getSimpleName());
        System.out.println("Canonical name " + cc.getCanonicalName());
    }
    
    public static void main(String[] args){
        Class c = null;
        try {
            c = Class.forName("com.zeus.typeinfo.FancyToy");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        printInfo(c);
    
        for (Class face : c.getInterfaces()) {
            printInfo(face);
        }
        Class up = c.getSuperclass();
        Object obj = null;
        try {
            obj = up.newInstance();
            printInfo(obj.getClass());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

interface HasBatteries{}
interface WaterProof{}
interface Shoots{}

class Toy{
    Toy() {}
    Toy(int i){}
}

class FancyToy extends Toy implements HasBatteries, WaterProof, Shoots{
    public FancyToy() {
        super(1);
    }
}