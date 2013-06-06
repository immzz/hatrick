package com.hatrick.logic;

import java.util.*;

public class LogicMap {
    static final int WALK_THROUGH = 32;
    int height, width;
    int[][] groundMap;
    LogicObject[][] objMap;
    List<LogicObject> objList;
    List<LogicObject> actionList;
    List<LogicObject> deleteList;
    List<LogicObject> actionListDel;
    List<LogicObject> deleteListDel;

    public LogicMap(int height, int width, int[][] groundMap) {
        LogicObject.mapInstance = this;
        this.height = height;
        this.width = width;
        this.groundMap = groundMap;
        objMap = new LogicObject[height][width];
        for (int i = 0; i < height; i ++)
            for (int j = 0; j < width; j ++)
                objMap[i][j] = null;
        objList =    Collections.synchronizedList(new ArrayList<LogicObject>());
        actionList = Collections.synchronizedList(new ArrayList<LogicObject>());
        deleteList = Collections.synchronizedList(new ArrayList<LogicObject>());
        actionListDel = new ArrayList<LogicObject>();
        deleteListDel = new ArrayList<LogicObject>();
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

    public void addDeleteList(LogicObject obj) {
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
        synchronized (objMap) {
            obj.mapNext = objMap[obj.p_y][obj.p_x];
            objMap[obj.p_y][obj.p_x] = obj;
        }
    }

    public void deleteObj(LogicObject obj) {
        synchronized (objMap) {
            int x = obj.p_x;
            int y = obj.p_y;
            
            LogicObject iter = objMap[y][x];
            if (iter == obj) {
                objMap[y][x] = obj.mapNext;
            }
            else {
                while (iter.mapNext != obj) {
                    iter = iter.mapNext;
                }
                iter.mapNext = iter.mapNext.mapNext;
            }
        }
    }

    public boolean reachable(int x, int y) {
        if (x < 0 || x >= width || y < 0 || y >= height)
            return false;
        if (objMap[y][x] != null &&
            (objMap[y][x] instanceof Bomb))
            return false;
        else if (groundMap[y][x] <= WALK_THROUGH)
            return true;
        else
            return false;
    }

    public void damage(int x, int y, int power) {
        for (int i = y - 1; i <= y + 1; i ++)
            for (int j = x - 1; j <= x + 1; j ++) {
                if (i < 0 || i >= height || j < 0 || j >= width)
                    continue;
                LogicObject iter = objMap[i][j];
                while (iter != null) {
                    if (iter instanceof Hero)
                        ((Hero)iter).doDamage(power);
                    iter = iter.mapNext;
                }
            }
    }

    public boolean objMove(LogicObject obj, int off_x, int off_y) {
        int new_x = obj.p_x + off_x;
        int new_y = obj.p_y + off_y;
        int temp_x;
        int temp_y;
        if (reachable(new_x, new_y)) {
            actionList.add(obj);
            temp_x = obj.p_x;
            temp_y = obj.p_y;
            deleteObj(obj);
            obj.p_x = new_x;
            obj.p_y = new_y;
            insertObj(obj);
            obj.p_x = temp_x;
            obj.p_y = temp_y;
            return true;
        }
        else {
            return false;
        }
    }
}

