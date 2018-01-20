package com.zeus.enumerated;

/**
 * @author xuxingbo
 * @Date 2018/1/20
 */
public enum OverrideConstantSpecific {
    NUT, BOLT,
    WASHER{
        @Override
        void f() {
            System.out.println("override behavior");
        }
    };
    void f(){
        System.out.println("default behavior");
    }
    
    public static void main(String[] args) {
        for (OverrideConstantSpecific ocs : values()) {
            System.out.print(ocs + ": ");
            ocs.f();
        }
    }
}
