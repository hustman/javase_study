package com.zeus.enumerated.roshambo;

/**
 * @author xuxingbo
 * @Date 2018/1/23
 * 剪刀石头布 中的 石头
 */
public class Rock implements Item {
    
    public OutCome compute(Item it) {
        return it.eval(this);
    }
    
    public OutCome eval(Paper p) {
        return OutCome.WIN;
    }
    
    public OutCome eval(Scissors s) {
        return OutCome.LOSE;
    }
    
    public OutCome eval(Rock r) {
        return OutCome.DRAW;
    }
    
    
    @Override
    public String toString() {
        return "石头";
    }
}
