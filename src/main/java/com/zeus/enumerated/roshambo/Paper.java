package com.zeus.enumerated.roshambo;

/**
 * @author xuxingbo
 * @Date 2018/1/23
 * 剪刀石头布 中的 布
 */
public class Paper implements Item {
    public OutCome compute(Item it) {
        return it.eval(this);
    }
    
    public OutCome eval(Paper p) {
        return OutCome.DRAW;
    }
    
    public OutCome eval(Scissors s) {
        return OutCome.WIN;
    }
    
    public OutCome eval(Rock r) {
        return OutCome.LOSE;
    }
    
    
    @Override
    public String toString() {
        return "布";
    }
}
