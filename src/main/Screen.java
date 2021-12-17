/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.CardLayout;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author HP
 */
public class Screen extends JFrame {

    int width;
    int height;
    private int xScreen, yScreen;
    private CardLayout layout;
    int stateScene;
    private GamePanel game;
    private Thread thread;

    public Screen() {
        layout = new CardLayout();
        this.width = Const.WIDTH_SCREEN * Const.SCALE_SCREEN;
        this.height = Const.HEIGHT_SCREEN * Const.SCALE_SCREEN;
        super.setTitle("Simple survival");
        super.setSize(this.width, this.height);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addnotify();
        this.setPositionCenter();
        super.setLayout(layout);
        this.game = new GamePanel(this);
        this.thread = new Thread(game);
        this.thread.start();
        super.add(this.game);
        this.game.setFocusable(true);
        this.game.requestFocus();
        super.setVisible(true);
    }

    private void addnotify() {
        super.addNotify();
    }

    private void setPositionCenter() {
        Dimension SIZE = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (SIZE.width) / 2 - (this.width) / 2;
        int y = (SIZE.height) / 2 - (this.height) / 2;
        super.setLocation(x, y);
    }

    public int getyScreen() {
        return yScreen;
    }

    public void setyScreen(int yScreen) {
        this.yScreen = yScreen;
    }

    public int getxScreen() {
        return xScreen;
    }

    public void setxScreen(int xScreen) {
        this.xScreen = xScreen;
    }

}
