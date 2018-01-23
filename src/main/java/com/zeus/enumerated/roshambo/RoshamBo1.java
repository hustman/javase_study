package com.zeus.enumerated.roshambo;

import java.util.Random;

/**
 * @author xuxingbo
 * @Date 2018/1/23
 */
public class RoshamBo1 {
    static final int SIZE = 20;
    private static Random rand = new Random(47);
    
    public static Item newItem(){
        switch(rand.nextInt(3)){
            default:
            case 0:
                return new Scissors();
            case 1:
                return new Paper();
            case 2:
                return new Rock();
        }
    }
    
    static void match(Item a, Item b){
        System.out.println(a + " VS " + b + ": " + a.compute(b));
    }
    
    public static void main(String[] args){
        for (int i = 0; i < SIZE; i++) {
            match(newItem(), newItem());
        }
    }
}
