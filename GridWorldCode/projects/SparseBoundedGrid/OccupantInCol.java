/*
*    Filename: OccupantInCol.java
*    Description: NULL
*    Last modified: 2015-08-23 10:37
*
*    Created by Eleveneat on 2015-08-23
*    Email: eleveneat@gmail.com
*    Copyright (C) 2015 Eleveneat. All rights reserved.
*/

public class OccupantInCol {
    private Object occupant;
    private int col;

    public OccupantInCol(Object o, int c) {
        occupant = o;
        col = c;
    }

    public void setObject(Object o) {
        occupant = o;
    }

    public void setCol(int c) {
        col = c;
    }

    public Object getObject() {
        return occupant;
    }

    public int getCol() {
        return col;
    }
}
