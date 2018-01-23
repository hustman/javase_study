package com.zeus.enumerated.roshambo;

/**
 * @author xuxingbo
 * @Date 2018/1/23
 */
public interface Competitor<T extends Competitor<T>> {
    OutCome compete(T competitor);
}
