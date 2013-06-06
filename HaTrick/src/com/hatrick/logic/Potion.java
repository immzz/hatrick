package com.hatrick.logic;

import java.io.Serializable;

public class Potion extends LogicObject implements Serializable{
	private static final long serialVersionUID = 1L;
	
    int amount;

    public void doAction() {
    }

    public Potion(int p_x, int p_y, int amount, int deleteDely) {
        super(p_x, p_y, 0, 0, 0, deleteDely);
        this.amount = amount;
        if (mapInstance.emptyPlace(p_x, p_y)) {
            mapInstance.addNewObj(this);
            System.out.printf("New at %d, %d\n", p_x, p_y);
        }
    }
}
