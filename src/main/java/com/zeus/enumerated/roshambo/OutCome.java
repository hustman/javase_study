package com.zeus.enumerated.roshambo;

/**
 * @author xuxingbo
 * @Date 2018/1/23
 * 剪刀石头布中的 结果枚举
 */
public enum OutCome {
    WIN("赢"),  //赢
    LOSE("输"), //输
    DRAW("平局"); //平局
    
    private String value;
    
    OutCome(String value) {
        this.value = value;
    }
    
    
    @Override
    public String toString() {
        return value;
    }
}
