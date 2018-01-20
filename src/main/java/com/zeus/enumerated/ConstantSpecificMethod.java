package com.zeus.enumerated;

import java.text.DateFormat;
import java.util.Date;

/**
 * @author xuxingbo
 * @Date 2018/1/20
 * enum class can have a constant method
 */
public enum ConstantSpecificMethod {
    DATE_TIME {
        String getInfo(){
            return DateFormat.getDateInstance().format(new Date());
        }
    },
    CLASSPATH {
        String getInfo(){
            return System.getenv("CLASSPATH");
        }
    },
    VERSION {
        String getInfo() {
            return System.getenv("java.version");
        }
    };
    abstract String getInfo();
    
    public static void main(String[] args) {
        for (ConstantSpecificMethod csm : values()) {
            System.out.println(csm.getInfo());
        }
    }
}
