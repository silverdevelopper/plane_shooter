// 
// Decompiled by Procyon v0.5.36
// 

package com.company;

import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyListener;
import java.awt.Canvas;

public class kanvas extends Canvas implements KeyListener // interfaceleri implements ile eklersin, Normal classları extends ile eklersin
{
    private static final double turn_speed = 6.0;
    int w;
    int h;
    int ucak_x;
    int ucak_y;
    int Timer;
    int ucak_v0;
    int ucak_len;
    int ucak_height;
    int rocket_x;
    int rocket_y;
    int rocket_size;
    int ground;
    int level;
    int x1;
    int y1;
    int x2;
    int y2;
    double a;
    double b;
    double v_a;
    double v_b;
    double angle;
    Bomb bomb;
    boolean bomb_realsed;
    boolean coolesion;
    boolean level_up;
    int scor;
    Image plane;
    Image img2;
    Image img3;
    Image background;
    private int x3;
    private int x4;
    private int y3;
    private int y4;
    Font scr;
    Font level_font;
    Font hit;

    public kanvas(final int w, final int h) { // kanvas class'ının constructor'u (yaratıcı fonksiyon demek)
        this.Timer = 0;
        this.ucak_v0 = 3;
        this.ucak_len = 70;
        this.ucak_height = 70;
        this.rocket_size = 50;
        this.ground = 700;
        this.level = 1;
        this.angle = 0.0;
        this.bomb_realsed = false;
        this.coolesion = false;
        this.level_up = true;
        this.scr = new Font("Comic Sans", 0, 25);
        this.level_font = new Font("Comic Sans", 0, 60);
        this.hit = new Font("Comic Sans", 0, 25);
        this.setBackground(Color.darkGray);
        this.addKeyListener(this);
        this.w = w;
        this.h = h;
        this.ucak_x = 10;
        this.ucak_y = 50;
        this.scor = 0;
        this.rocket_y = this.ground;
        this.rocket_x = (int)(Math.random() * (w - 250) + 150.0);
        this.x1 = this.rocket_x;
        this.y1 = this.rocket_y;
        this.plane = Toolkit.getDefaultToolkit().getImage("src/assets/images/jet.png");
        this.img2 = Toolkit.getDefaultToolkit().getImage("src/assets/images/rocket.png");
        this.background = Toolkit.getDefaultToolkit().getImage("src/assets/images/sky.jpg");
    }

    private boolean isCollision() {
        return this.x4 >= this.ucak_x && this.x4 <= this.ucak_x + this.ucak_len && this.ucak_y + this.ucak_height >= this.y4 && this.y4 >= this.ucak_y;
    }

    @Override // override etmek
    public void paint(final Graphics p) { // Canvas içindeki her şeyi sen yazıyorsun
        final Graphics2D g2 = (Graphics2D)p;
        final Graphics2D g3 = (Graphics2D)p;
        g2.drawImage(this.background, 0, 0, this.w, this.h + 300, this); // draw image
        if (this.isCollision()) {
            g3.setColor(Color.red);
            g3.setFont(this.hit);
            g3.drawString("Hit!!", this.x4, this.y4);
            this.ucak_x = -this.ucak_len;
            this.x1 = (int)(Math.random() * (this.w - 250) + 150.0);
            ++this.ucak_v0;
            this.scor += this.ucak_v0 * 100;
            ++this.level;
            this.level_up = true;
            this.repaint();
        }
        if (this.level_up) {
            p.setColor(Color.cyan);
            p.setFont(this.level_font);
            p.drawString("Level " + String.valueOf(this.level), this.w / 2 - 100, this.h / 2 - 20);
            this.sleep(500);
            this.level_up = false;
        }
        p.setFont(this.scr);
        p.setColor(Color.red);
        p.drawString("Scor:" + String.valueOf(this.scor), this.w - 200, 40);
        p.setColor(Color.yellow);
        p.setColor(Color.red);
        g2.drawImage(this.plane, this.ucak_x, this.ucak_y, this.ucak_len, this.ucak_height, this); // draw plane
        p.drawRect(this.ucak_x, this.ucak_y, this.ucak_len, this.ucak_height);
        p.setColor(Color.green);
        p.setColor(Color.green);
        this.a = (int)(Math.cos(3.141592653589793 * this.angle / 180.0) * this.rocket_size);
        this.b = (int)(Math.sin(3.141592653589793 * this.angle / 180.0) * this.rocket_size);
        this.x2 = (int)(this.x1 + this.a);
        this.y2 = (int)(this.y1 - this.b);
        this.x3 = (int)(this.x1 + this.rocket_size / 4 * Math.sin(Math.toRadians(this.angle)));
        this.y3 = (int)(this.y1 + this.rocket_size / 4 * Math.cos(Math.toRadians(this.angle)));
        this.x4 = (int)((int)(this.rocket_x + this.a) + this.rocket_size / 4 * Math.sin(Math.toRadians(this.angle)));
        this.y4 = (int)((int)(this.rocket_y - this.b) + this.rocket_size / 4 * Math.cos(Math.toRadians(this.angle)));
        p.drawLine(this.x1, this.y1, this.x2, this.y2);
        if (this.bomb_realsed) {
            this.rocket_x += (int)(this.v_a / 2.0);
            this.rocket_y -= (int)(this.v_b / 2.0);
            p.setColor(Color.yellow);
            p.drawLine(this.x3, this.y3, this.x4, this.y4);
        }
        if (this.rocket_x > this.w || this.rocket_x < 0 || this.rocket_y < 0) {
            this.bomb_realsed = false;
            this.rocket_x = this.x1;
            this.rocket_y = this.y1;
        }
        g2.rotate(-(3.141592653589793 * this.angle / 180.0), this.rocket_x, this.rocket_y);
        g2.drawImage(this.img2, this.rocket_x, this.rocket_y, this.rocket_size, this.rocket_size / 2, this);
        this.ucak_x += this.ucak_v0;
        if (this.ucak_x > this.w + this.ucak_len) {
            this.ucak_x = -this.ucak_len;
        }
        this.sleep(10);
        this.angle %= 360.0;
        g2.finalize();
        this.repaint();
    }

    void sleep(final int t) {
        try {
            Thread.sleep(t);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void keyTyped(final KeyEvent e) {
    }

    @Override
    public void keyPressed(final KeyEvent e) {
        final int key = e.getKeyCode();
        switch (key) {
            case 38: {
                this.bomb_realsed = true;
                this.v_a = this.a;
                this.v_b = this.b;
                break;
            }
            case 37: {
                if (!this.bomb_realsed) {
                    this.angle += 6.0;
                    break;
                }
                break;
            }
            case 39: {
                if (!this.bomb_realsed) {
                    this.angle -= 6.0;
                    break;
                }
                break;
            }
        }
    }

    @Override
    public void keyReleased(final KeyEvent e) {
    }
}