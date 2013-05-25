package com.hatrick.logic;
public abstract class LogicObject {
    static LogicMap mapInstance;
    static int globalId = 0;

    public int id;
	/* status */
	int status;			//stop

    public double pos_x, pos_y;
    public double width;
    public int direction;
    public double speed;
    public long actionTime;
    public long deleteTime;

    public LogicObject mapNext;
    public LogicObject listNext;
    public LogicObject actionListNext;
    public LogicObject deleteListNext;

    protected LogicObject(double pos_x, double pos_y, double width, int direction, double speed, long actionTime, long deleteTime) {
        this.pos_x = pos_x;
        this.pos_y = pos_y;
        this.width = width;
        this.direction = direction;
        this.speed = speed;
        this.actionTime = actionTime;
        this.deleteTime = deleteTime;
        id = globalId ++;
    }

    protected LogicObject(double pos_x, double pos_y, double width, int direction, double speed) {
        this(pos_x, pos_y, width, direction, speed, 0, 0);
    }

    public abstract void doAction();

    public boolean collide(double x, double y) {
        if (x > pos_x && x < pos_x + width
            && y > pos_y && y < pos_y + width)
            return true;
        else
            return false;
    }

    private boolean collideWith(LogicObject obj) {
        return collide(obj.pos_x, obj.pos_y)
                || collide(obj.pos_x + obj.width, obj.pos_y)
                || collide(obj.pos_x, obj.pos_x + obj.width)
                || collide(obj.pos_x + obj.width, obj.pos_y + obj.width);
    }

    public boolean collide(LogicObject obj) {
        return this.collideWith(obj) || obj.collideWith(this);
    }
    
    // NOTICE!!!!!!!!!!!!!!!!!!!!!!!!!
    // we may assume dis < width
    public void moveUp(double dis) {
        mapInstance.objMoveUp(this, -dis);
    }

    public void moveDown(double dis) {
        mapInstance.objMoveDown(this, dis);
    }

    public void moveLeft(double dis) {
        mapInstance.objMoveLeft(this, -dis);
    }

    public void moveRight(double dis) {
        mapInstance.objMoveRight(this, dis);
    }
}
