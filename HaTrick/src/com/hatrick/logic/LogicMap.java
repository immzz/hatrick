package com.hatrick.logic;

import java.util.ArrayList;

public class LogicMap {
    static final int WALK_THROUGH = 32;
    int height, width;
    int[][] groundMap;
    LogicObject[][] objMap;
    ArrayList<LogicObject> objList;
    ArrayList<LogicObject> actionList;
    ArrayList<LogicObject> deleteList;

    public LogicMap(int height, int width, int[][] groundMap) {
        LogicObject.mapInstance = this;
        this.height = height;
        this.width = width;
        this.groundMap = groundMap;
        objMap = new LogicObject[height][width];
        for (int i = 0; i < height; i ++)
            for (int j = 0; j < width; j ++)
                objMap[i][j] = null;
        objList =    new ArrayList<LogicObject>();
        actionList = new ArrayList<LogicObject>();
        deleteList = new ArrayList<LogicObject>();
    }

    public void addNewObj(LogicObject obj) {
        objList.add(obj);
        insertObj(obj);
        if (obj.actionTime != 0) {
            addActionList(obj);
        }
        if (obj.deleteTime != 0) {
            addDeleteList(obj);
        }
    }

    private void addActionList(LogicObject obj) {
        actionList.add(obj);
    }

    private void addDeleteList(LogicObject obj) {
        deleteList.add(obj);
    }

    public void delActionList(LogicObject obj) {
        actionList.remove(obj);
    }

    public void delObjList(LogicObject obj) {
        objList.remove(obj);
    }

    public void delDelList(LogicObject obj) {
        deleteList.remove(obj);
    }

    private void insertObj(LogicObject obj) {
        obj.mapNext = objMap[obj.p_y][obj.p_x];
        objMap[obj.p_y][obj.p_x] = obj;
    }

    private void deleteObj(LogicObject obj) {
        int x = obj.p_x;
        int y = obj.p_y;
        
        LogicObject iter = objMap[y][x];
        if (iter == obj) {
            objMap[y][x] = obj.mapNext;
        }
        else {
            while (iter.mapNext != obj)
                iter = iter.mapNext;
            iter.mapNext = iter.mapNext.mapNext;
        }
    }

    public boolean reachable(int x, int y) {
        if (x < 0 || x >= height || y < 0 || y >= width)
            return false;
        if (objMap[y][x] != null &&
            (objMap[y][x] instanceof Bomb))
            return false;
        else
            return true;
    }

    public void damage(double pos_x, double pos_y, double range, double power) {
        /*
        double left = pos_y - range;
        double right = pos_y + range;
        double up = pos_x - range;
        double down = pos_x + range;
        if (left < 0)
            left = 0;
        if (right > size_y)
            right = size_y;
        if (up < 0)
            up = 0;
        if (down > size_x)
            down = size_x;

        for (int i = Math.floor(up / ratio); i <= Math.ceil(down / ratio); i ++)
            for (int j = Math.floor(left / ratio); j <= Math.ceil(right / ratio); j++) {
                LogicObject iter = objMap[i][j];
                while (iter != null) {
                    if ((iter.pos_x - pos_x) * (iter.pos_x - pos_x)
                            + (iter.pos_y - pos_y) * (iter.pos_y - pos_y)
                            < range * range)
                        iter.doDamage(power);
                }
            }
                        */
        
    }

    public void objMove(LogicObject obj, int off_x, int off_y) {
        int new_x = obj.p_x + off_x;
        int new_y = obj.p_y + off_y;
        if (reachable(new_x, new_y)) {
            actionList.add(obj);
            deleteObj(obj);
            insertObj(obj);
        }
        else {
            obj.actionTime = 0;
        }
    }
}

