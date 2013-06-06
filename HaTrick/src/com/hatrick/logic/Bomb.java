package com.hatrick.logic;
import java.io.Serializable;
public class Bomb extends LogicObject implements Serializable {
    static final int WAITING = 0;
    static final int BANG = 1;

    int power;
    // delay is ms value
    public Bomb(int p_x, int p_y, int power, int actionDely, int deleteDely) {
        super(p_x, p_y, 0, 0, 0, 0);
        this.power = power;
        status = WAITING;
    }

    public void doAction() {
        mapInstance.damage(p_x, p_y, power);
        status = BANG;
    }
}
