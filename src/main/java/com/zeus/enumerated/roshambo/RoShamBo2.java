package com.zeus.enumerated.roshambo;

import static com.zeus.enumerated.roshambo.OutCome.DRAW;
import static com.zeus.enumerated.roshambo.OutCome.LOSE;
import static com.zeus.enumerated.roshambo.OutCome.WIN;

/**
 * @author xuxingbo
 * @Date 2018/1/23
 */
public enum RoShamBo2 implements Competitor<RoShamBo2> {
    PAPER(DRAW, LOSE, WIN),
    SCISSORS(WIN, DRAW, LOSE),
    ROCK(LOSE, WIN, DRAW);
    
    private OutCome vPAPER, vSCISSORS, vROCK;
    
    RoShamBo2(OutCome vPAPER, OutCome vSCISSORS, OutCome vROCK) {
        this.vPAPER = vPAPER;
        this.vSCISSORS = vSCISSORS;
        this.vROCK = vROCK;
    }
    
    public OutCome compete(RoShamBo2 it) {
        switch (it){
            default:
            case PAPER:
                return vPAPER;
            case ROCK:
                return vROCK;
            case SCISSORS:
                return vSCISSORS;
        }
    }
    
    public static void main(String[] args) {
        RoShamBo.play(RoShamBo2.class, 20);
    }
}
