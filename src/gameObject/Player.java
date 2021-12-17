/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameObject;

import gameObject.animation.Animation;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author HP
 */

public class Player extends Creatures {

    private final int STATE_ANIMATION_IDLE = 0;
    private final int STATE_ANIMATION_WALKING = 1;

    BufferedImage img1, img2;
    Animation animation;
    int stateAnimation;

    public Player(BufferedImage img, BufferedImage img2, int col, int row, float left, float right, float top, float bottom, float scale) {
        super(img, col, row, left, right, top, bottom, scale);
        this.img = img;
        this.img1 = img;
        this.img2 = img2;
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(img1);
        images.add(img2);
        this.animation = new Animation(0.3f, images);
        this.stateAnimation = STATE_ANIMATION_IDLE;
        System.out.println(this.getWidth() + "; " + this.getHeight());
        System.out.println(this.getX() + "; " + this.getY());
    }

    @Override
    protected void updateExtends() {
        if (this.xForce != 0 || this.yForce != 0) {
            this.stateAnimation = STATE_ANIMATION_WALKING;
        } else {
            this.stateAnimation = STATE_ANIMATION_IDLE;
        }
        if (this.stateAnimation == STATE_ANIMATION_WALKING) {
            this.animation.update();
        }
        this.img = this.animation.getCurrentImage();
    }

    public void keyDownListenner(int k) {
        switch (k) {
            case KeyEvent.VK_W:
                this.force(xForce, -5);
                break;
            case KeyEvent.VK_A:
                this.force(-5, yForce);
                break;
            case KeyEvent.VK_S:
                this.force(xForce, 5);
                break;
            case KeyEvent.VK_D:
                this.force(5, yForce);
                break;

        }
    }

    public void keyReleaseListenner(int k) {
        switch (k) {
            case KeyEvent.VK_W:
                this.force(xForce, 0);
                break;
            case KeyEvent.VK_A:
                this.force(0, yForce);
                break;
            case KeyEvent.VK_S:
                this.force(xForce, 0);
                break;
            case KeyEvent.VK_D:
                this.force(0, yForce);
                break;

        }
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public void setX(float x) {
        this.x = x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public void setY(float y) {
        this.y = y;
    }

}
