// 
// Decompiled by Procyon v0.5.36
// 

package com.company;

public class Bomb
{
    int x;
    int y;
    int size;
    int v_x;
    double v_y;

    public Bomb(final int x, final int y, final int v0) {
        this.size = 8;
        this.v_x = 0;
        this.v_y = 5.0;
        this.x = x;
        this.y = y;
        this.v_x = v0;
    }

    public void updateV_Y(final int t) {
        this.v_y += 0.01 * t;
        this.y += (int)this.v_y;
    }

    public void updateV_X() {
        this.x += this.v_x;
    }
}