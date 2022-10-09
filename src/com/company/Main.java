// 
// Decompiled by Procyon v0.5.36
// 

package com.company;

import java.awt.event.WindowEvent;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.WindowListener;

public class Main implements  WindowListener,MouseListener, ActionListener
{
    Frame frm;
    kanvas k;
    // Main class'ının constructor'u
    // Bu Class'dan "new" ile object yaratılmasını sağlar. Class ismi ile aynı omak zorundadır.!
    public Main() {
        this.frm = new Frame();
        this.k = new kanvas(1400, 800); // create new canvas object
        this.frm.addWindowListener(this);
        this.frm.add(this.k);
        this.frm.setSize(1400, 800);
        this.frm.setVisible(true);
        this.frm.setResizable(false);

    }

    public static void main(final String[] args) {
        final Main game = new Main(); // create new Main object
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
    }

    @Override
    public void mouseClicked(final MouseEvent e) {
        System.out.println("Mouse clicked!");
    }

    @Override
    public void mousePressed(final MouseEvent e) {
    }

    @Override
    public void mouseReleased(final MouseEvent e) {
    }

    @Override
    public void mouseEntered(final MouseEvent e) {
    }

    @Override
    public void mouseExited(final MouseEvent e) {
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}