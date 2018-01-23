package com.zeus.enumerated.roshambo;

/**
 * @author xuxingbo
 * @Date 2018/1/23
 */
public interface Item {
    OutCome compute(Item it);
    
    /**
     * eval方法中，都是入参 和 对象本身(this) 进行比较
     */
    OutCome eval(Paper p);
    
    /**
     * eval方法中，都是入参 和 对象本身(this) 进行比较
     */
    OutCome eval(Scissors s);
    
    /**
     * eval方法中，都是入参 和 对象本身(this) 进行比较
     */
    OutCome eval(Rock r);
}
