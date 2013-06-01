package com.hatrick.logic;
public class LogicMap {
    static final int WALK_THROUGH = 32;
    int size_x, size_y;
    int ratio;
    int[][] groundMap;
    LogicObject[][] objMap;
    LogicObject objList;
    LogicObject actionList;
    LogicObject deleteList;

    // NOTICE !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    //   Here we suppose ratio > width
    public LogicMap(int size_x, int size_y, int[][] groundMap, int ratio) {
        LogicObject.mapInstance = this;
        this.size_x = size_x;
        this.size_y = size_y;
        this.ratio = ratio;
        this.groundMap = groundMap;
        objMap = new LogicObject[(int)(int)Math.ceil(1.0 * size_x / ratio)][(int)(int)Math.ceil(1.0 * size_y / ratio)];
        for (int i = 0; i < (int)(int)Math.ceil(1.0 * size_x / ratio); i ++)
            for (int j = 0; j < (int)(int)Math.ceil(1.0 * size_y / ratio); j ++)
                objMap[i][j] = null;
        objList = null;
        actionList = null;
        deleteList = null;
    }

    public LogicMap(int size_x, int size_y, int[][] groundMap) {
        this(size_x, size_y, groundMap, 8);
    }

    public void addNewObj(LogicObject obj) {
        obj.listNext = objList;
        objList = obj;
        insertObj(obj);
        if (obj.actionTime != 0) {
            addActionList(obj);
        }
        if (obj.deleteTime != 0) {
            addDeleteList(obj);
        }
    }

    private void addActionList(LogicObject obj) {
        if (actionList == null) {
            obj.actionListNext = actionList;
            actionList = obj;
        }
        else if (obj.actionTime < actionList.actionTime) {
            obj.actionListNext = actionList;
            actionList = obj;
        }
        else {
            LogicObject iter = actionList;
            while (iter.actionListNext != null
                    && iter.actionListNext.actionTime < obj.actionTime)
                iter = iter.actionListNext;
            obj.actionListNext = iter.actionListNext;
            iter.actionListNext = obj;
        }
    }

    private void addDeleteList(LogicObject obj) {
        if (deleteList == null) {
            obj.deleteListNext = deleteList;
            deleteList = obj;
        }
        else if (obj.deleteTime < deleteList.deleteTime) {
            obj.deleteListNext = deleteList;
            deleteList = obj;
        }
        else {
            LogicObject iter = deleteList;
            while (iter.deleteListNext != null
                    && iter.deleteListNext.deleteTime < obj.deleteTime)
                iter = iter.deleteListNext;
            obj.deleteListNext = iter.deleteListNext;
            iter.deleteListNext = obj;
        }
    }

    private void insertObj(LogicObject obj) {
        int x = (int)(int)Math.floor(obj.pos_x / ratio);
        int y = (int)(int)Math.floor(obj.pos_y / ratio);
        obj.mapNext = objMap[x][y];
        objMap[x][y] = obj;
    }

    private void deleteObj(LogicObject obj) {
        int x = (int)(int)Math.floor(obj.pos_x / ratio);
        int y = (int)(int)Math.floor(obj.pos_y / ratio);
        
        LogicObject iter = objMap[x][y];
        if (iter == obj) {
            objMap[x][y] = obj.mapNext;
        }
        else {
            while (iter.mapNext != obj)
                iter = iter.mapNext;
            iter.mapNext = iter.mapNext.mapNext;
        }
    }

    public void damage(double pos_x, double pos_y, double range, double power) {
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
        
    }

    public void objMoveUp(LogicObject obj, double off_x) {
        // make sure how far can we go
        //   two direction according to off_ > 0 or < 0
        double next_x = obj.pos_x + off_x;
        for (int i = (int)(int)Math.ceil(obj.pos_x);
                i > (int)(int)Math.floor(obj.pos_x + off_x); i --)
            for (int j = (int)(int)Math.floor(obj.pos_y);
                    j < (int)(int)Math.ceil(obj.pos_y + obj.width); j ++)
                if (i < 0 || groundMap[i][j] > WALK_THROUGH) {
                    next_x = i + 1;
                    break;
                }
        int script_x = (int)(int)Math.floor(next_x / ratio);
        int script_y = (int)(int)Math.floor(obj.pos_y / ratio);
        LogicObject iter;
        if (script_x > 0) {
            iter = objMap[script_x - 1][script_y];
            while (iter != null) {
                if (iter.collide(next_x, obj.pos_y))
                    next_x = iter.pos_x + iter.width;
                iter = iter.mapNext;
            }
            script_y = (int)(int)Math.floor((obj.pos_y + obj.width) / ratio);
            iter = objMap[script_x - 1][script_y];
            while (iter != null) {
                if (iter.collide(next_x, obj.pos_y + obj.width))
                    next_x = iter.pos_x + iter.width;
                iter = iter.mapNext;
            }
        }
        script_y = (int)(int)Math.floor(obj.pos_y / ratio);
        iter = objMap[script_x][script_y];
        while (iter != null) {
            if (iter.collide(next_x, obj.pos_y))
                next_x = iter.pos_x + iter.width;
            iter = iter.mapNext;
        }
        script_y = (int)(int)Math.floor((obj.pos_y + obj.width) / ratio);
        iter = objMap[script_x][script_y];
        while (iter != null) {
            if (iter.collide(next_x, obj.pos_y + obj.width))
                next_x = iter.pos_x + iter.width;
            iter = iter.mapNext;
        }
        if ((int)(int)Math.floor(obj.pos_x / ratio) != (int)(int)Math.floor(next_x / ratio)) {
            deleteObj(obj);
            obj.pos_x = next_x;
            insertObj(obj);
        }
    }

    public void objMoveDown(LogicObject obj, double off_x) {
        // make sure how far can we go
        //   two direction according to off_ > 0 or < 0
        double next_x = obj.pos_x + off_x;
        for (int i = (int)(int)Math.floor(obj.pos_x + obj.width);
                i < (int)(int)Math.ceil(obj.pos_x + obj.width + off_x); i ++)
            for (int j = (int)(int)Math.floor(obj.pos_y);
                    j < (int)(int)Math.ceil(obj.pos_y + obj.width); j ++)
                if (i >= size_x || groundMap[i][j] > WALK_THROUGH) {
                    next_x = i - obj.width;
                    break;
                }
        int script_x = (int)(int)Math.floor((next_x + obj.width)/ ratio);
        int script_y = (int)(int)Math.floor(obj.pos_y / ratio);
        LogicObject iter;
        if (script_x < (int)(int)Math.ceil(size_x / ratio) - 1) {
            iter = objMap[script_x + 1][script_y];
            while (iter != null) {
                if (iter.collide(next_x + obj.width, obj.pos_y))
                    next_x = iter.pos_x - obj.width;
                iter = iter.mapNext;
            }
            script_y = (int)(int)Math.floor((obj.pos_y + obj.width) / ratio);
            iter = objMap[script_x + 1][script_y];
            while (iter != null) {
                if (iter.collide(next_x + obj.width, obj.pos_y + obj.width))
                    next_x = iter.pos_x - obj.width;
                iter = iter.mapNext;
            }
        }
        script_y = (int)(int)Math.floor(obj.pos_y / ratio);
        iter = objMap[script_x][script_y];
        while (iter != null) {
            if (iter.collide(next_x + obj.width, obj.pos_y))
                next_x = iter.pos_x - obj.width;
            iter = iter.mapNext;
        }
        script_y = (int)(int)Math.floor((obj.pos_y + obj.width) / ratio);
        iter = objMap[script_x][script_y];
        while (iter != null) {
            if (iter.collide(next_x + obj.width, obj.pos_y + obj.width))
                next_x = iter.pos_x - obj.width;
            iter = iter.mapNext;
        }
        if ((int)(int)Math.floor(obj.pos_x / ratio) != (int)(int)Math.floor(next_x / ratio)) {
            deleteObj(obj);
            obj.pos_x = next_x;
            insertObj(obj);
        }
    }

    public void objMoveLeft(LogicObject obj, double off_y) {
        // make sure how far can we go
        //   two direction according to off_ > 0 or < 0
        double next_y = obj.pos_y + off_y;
        for (int j = (int)(int)Math.ceil(obj.pos_y);
                j > (int)(int)Math.floor(obj.pos_y + off_y); j --)
            for (int i = (int)(int)Math.ceil(obj.pos_x);
                    i < (int)(int)Math.floor(obj.pos_x + obj.width); i ++)
                if (j < 0 || groundMap[i][j] > WALK_THROUGH) {
                    next_y = j + 1;
                    break;
                }
        int script_x = (int)(int)Math.floor(obj.pos_x / ratio);
        int script_y = (int)(int)Math.floor(next_y / ratio);
        LogicObject iter;
        if (script_y > 0) {
            iter = objMap[script_x][script_y - 1];
            while (iter != null) {
                if (iter.collide(obj.pos_x, next_y))
                    next_y = iter.pos_y + iter.width;
                iter = iter.mapNext;
            }
            script_x = (int)(int)Math.floor((obj.pos_x + obj.width) / ratio);
            iter = objMap[script_x][script_y - 1];
            while (iter != null) {
                if (iter.collide(obj.pos_x + obj.width, next_y))
                    next_y = iter.pos_y + iter.width;
                iter = iter.mapNext;
            }
        }
        script_x = (int)(int)Math.floor(obj.pos_x / ratio);
        iter = objMap[script_x][script_y];
        while (iter != null) {
            if (iter.collide(obj.pos_x, next_y))
                next_y = iter.pos_y + iter.width;
            iter = iter.mapNext;
        }
        script_x = (int)(int)Math.floor((obj.pos_x + obj.width) / ratio);
        iter = objMap[script_x][script_y];
        while (iter != null) {
            if (iter.collide(obj.pos_x + obj.width, next_y))
                next_y = iter.pos_y + iter.width;
            iter = iter.mapNext;
        }
        if ((int)(int)Math.floor(obj.pos_y / ratio) != (int)(int)Math.floor(next_y / ratio)) {
            deleteObj(obj);
            obj.pos_y = next_y;
            insertObj(obj);
        }
    }


    public void objMoveRight(LogicObject obj, double off_y) {
        // make sure how far can we go
        //   two direction according to off_ > 0 or < 0
        double next_y = obj.pos_y + off_y;
        for (int j = (int)(int)Math.floor(obj.pos_y + obj.width);
                j < (int)(int)Math.ceil(obj.pos_y + obj.width + off_y); j ++)
            for (int i = (int)(int)Math.floor(obj.pos_x);
                    i < (int)(int)Math.ceil(obj.pos_x + obj.width); i ++)
                if (j >= size_y || groundMap[i][j] > WALK_THROUGH) {
                    next_y = j - obj.width;
                    break;
                }
        int script_x = (int)(int)Math.floor(obj.pos_x / ratio);
        int script_y = (int)(int)Math.floor((next_y + obj.width) / ratio);;
        LogicObject iter;
        if (script_y < (int)(int)Math.ceil(size_y / ratio) - 1) {
            iter = objMap[script_x][script_y + 1];
            while (iter != null) {
                if (iter.collide(obj.pos_x, next_y + obj.width))
                    next_y = iter.pos_y - obj.width;
                iter = iter.mapNext;
            }
            script_x = (int)(int)Math.floor((obj.pos_x + obj.width) / ratio);
            iter = objMap[script_x][script_y - 1];
            while (iter != null) {
                if (iter.collide(obj.pos_x + obj.width, next_y + obj.width))
                    next_y = iter.pos_y - obj.width;
                iter = iter.mapNext;
            }
        }
        script_x = (int)(int)Math.floor(obj.pos_x / ratio);
        iter = objMap[script_x][script_y];
        while (iter != null) {
            if (iter.collide(obj.pos_x, next_y + obj.width))
                next_y = iter.pos_y - obj.width;
            iter = iter.mapNext;
        }
        script_x = (int)(int)Math.floor((obj.pos_x + obj.width) / ratio);
        iter = objMap[script_x][script_y];
        while (iter != null) {
            if (iter.collide(obj.pos_x + obj.width, next_y + obj.width))
                next_y = iter.pos_y - obj.width;
            iter = iter.mapNext;
        }
        if ((int)(int)Math.floor(obj.pos_y / ratio) != (int)Math.floor(next_y / ratio)) {
            deleteObj(obj);
            obj.pos_y = next_y;
            insertObj(obj);
        }
    }
}

