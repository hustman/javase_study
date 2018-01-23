package com.zeus.enumerated.roshambo;

/**
 * @author xuxingbo
 * @Date 2018/1/23
 * 剪刀石头布 中的 剪刀
 */
public class Scissors implements Item {
    public OutCome compute(Item it) {
        return it.eval(this);
    }
    
    public OutCome eval(Paper p) {
        return OutCome.LOSE;
    }
    
    public OutCome eval(Scissors s) {
        return OutCome.DRAW;
    }
    
    public OutCome eval(Rock r) {
        return OutCome.WIN;
    }
    
    
    @Override
    public String toString() {
        return "剪刀";
    }
}
