package com.hatrick.logic;

import java.io.Serializable;

public class Hero extends LogicObject implements Serializable{
	private static final long serialVersionUID = 1L;
	
    private static final int RECOVERY_INTERVAL = 5000;
	/* moving */
	//double pos_x, pos_y;
	//double width;
	//int direction;		//1 of 4 OK? Will turn cost time? Different time?
	//double speed;
	String name;
    public int occupation;
    public int team;
	int hp;
	

	double change;
	/* using items */
	//Item[] bag = new Item[10];
	int strength = 10;
	private int powerGauge = 3;
    

	boolean justShot;

    class RecoveryPower implements Runnable {
        public void run() {
            try {
				Thread.sleep(RECOVERY_INTERVAL);
	            while (changePower(1)) {
	                Thread.sleep(RECOVERY_INTERVAL);
	            }
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
	
    public Hero(String name, int p_x, int p_y, int direction, double speed, int team, int occupation) {
        super(p_x, p_y, direction, speed);
        this.name = name;
        this.team = team;
        this.occupation = occupation;
        LogicObject.mapInstance.addNewObj(this);
        hp = 100;
    }

    public void setOccupation(int occupation) {
        this.occupation = occupation;
    }

    public synchronized void doAction() {
    	offset++;
    	super.count_pos();
    	if(actionTime <= 1) {
            LogicObject.mapInstance.actionListDel.add(this);
    		//LogicObject.mapInstance.delActionList(this);
    		offset = 0;
    		if(direction == 1) {
        		p_y--;
        	}
        	else if(direction == 2) {
        		p_y++;
        	}
        	else if(direction == 3) {
        		p_x--;
        	}
        	else if(direction == 4) {
        		p_x++;
        	}
    		actionTime = 0;
    	}
    	else 
    		actionTime--;
    }

    public void doDamage(int damage) {
        // naive
        // TODO
        hp -= damage;
        System.out.printf("hp = %d\n", hp);
        if (hp <= 0)
            dead();
    }

    // change servers as
    //   1. if change > 0, it means add powerGage value
    //   2. if change < 0, it is the second before bomb explode
    private synchronized boolean changePower(int value) {
        if (value > 0) {
            if (powerGauge < 3) {
                powerGauge ++;
                return true;
            }
            else
                return false;
        }
        else {
            if (powerGauge > 0) {
                powerGauge --;
                // add bomb to list
                Bomb bomb =
                    new Bomb(this.p_x, this.p_y, strength, -value * 1000 / 50, (-value * 1000 / 50) + 5);
                mapInstance.addNewObj(bomb);
                if (powerGauge == 2) {
                    Thread thread = new Thread(new RecoveryPower());
                    thread.start();
                }
                return true;
            }
            else
                return false;
        }
    }

    public void placeBomb(int delay) {
        changePower(-delay);
    }

    private void dead(){
        //LogicObject.mapInstance.addDeleteList(this);
        serverLogicInstance.teamMemberDead(team);
        mapInstance.deleteObj(this);
        id = LogicObject.globalId ++;
        randomPos();
        mapInstance.insertObj(this);
    }
    
    boolean is_free() {
    	if(this.actionTime == 0) return true;
    	else {
            //System.out.println(actionTime);
            return false;
        }
    }

    synchronized void handle_op(Operation op) {
		if (op.moving == 1) {
			direction = 1;
			actionTime = 4;
			super.moveUp();
		} else if (op.moving == 2) {
			direction = 2;
			actionTime = 4;
			super.moveDown();
		} else if (op.moving == 3) {
			direction = 3;
			actionTime = 4;
			super.moveLeft();
		} else if (op.moving == 4) {
			direction = 4;
			actionTime = 4;
			super.moveRight();
		}

        if (op.shooting) {
            if (!justShot) {
                justShot = true;
                System.out.printf("place bomb\n");
                placeBomb(5);
            }
        }
        else {
            justShot = false;
        }

		use_item(op.usingitem);
	}
	
	void merge_state(Hero h) {
		pos_x = h.pos_x;
		pos_y = h.pos_y;
	}
	
	void use_item(int n) {
		if(n == 0) return;
	}
	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getPowerGauge() {
		return powerGauge;
	}

	public void setPowerGauge(int powerGauge) {
		this.powerGauge = powerGauge;
	}
}
