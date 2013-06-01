package com.hatrick.logic;
import java.io.Serializable;
public class Bomb extends LogicObject implements Serializable {
    static final int WAITING = 0;
    static final int BANG = 1;

    double distance;
    double range;
    double power;
    // delay is ms value
    public Bomb(int pos_x, int pos_y, double width, double distance, double range, double power, int actionDely, int deleteDely) {
        super(pos_x, pos_y, width, 0, 0, 0, 0);
        this.distance = distance;
        this.range = range;
        this.power = power;
        status = WAITING;
    }

    public void doAction() {
        mapInstance.damage(pos_x, pos_y, range, power);
        status = BANG;
    }
}
