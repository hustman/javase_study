package com.zeus.enumerated;

import java.util.EnumSet;

/**
 * @author xuxingbo
 * @Date 2018/1/20
 * enumset method test
 */
public class EnumSets {
    public static void main(String[] args) {
        EnumSet<AlarmPoints> points = EnumSet.noneOf(AlarmPoints.class);
        points.add(AlarmPoints.BATHROOM);
        System.out.println(points);
        points.addAll(EnumSet.of(AlarmPoints.START1, AlarmPoints.START2, AlarmPoints.START3));
        System.out.println(points);
        points = EnumSet.allOf(AlarmPoints.class);
        System.out.println(points);
        points.removeAll(EnumSet.of(AlarmPoints.START1, AlarmPoints.START2, AlarmPoints.KITCHEN));
        System.out.println(points);
        points = EnumSet.complementOf(points);
        System.out.println(points);
    }
}
