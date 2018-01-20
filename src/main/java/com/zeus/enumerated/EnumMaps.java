package com.zeus.enumerated;

import java.util.EnumMap;
import java.util.Map;

/**
 * @author xuxingbo
 * @Date 2018/1/20
 */
public class EnumMaps {
    public static void main(String[] args) {
        EnumMap<AlarmPoints, Command> em = new EnumMap<AlarmPoints, Command>(AlarmPoints.class);
        em.put(AlarmPoints.KITCHEN, new Command() {
            public void action() {
                System.out.println("kitchen fire!");
            }
        });
        em.put(AlarmPoints.BATHROOM, new Command() {
            public void action() {
                System.out.println("Bathroom fire!");
            }
        });
    
        for (Map.Entry<AlarmPoints, Command> e : em.entrySet()) {
            System.out.print(e.getKey() + ": ");
            e.getValue().action();
        }
    
        try {
            em.get(AlarmPoints.UTILITY).action();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

interface Command{
    void action();
}
