/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameObject;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author HP
 */
public abstract class Creatures extends GameEntity {

    BufferedImage img;
    float speed, damage, healpoint;
    protected float xForce, yForce;
    protected int stateDirection;
    private final int STATE_DIR_LEFT = 1;
    private final int STATE_DIR_RIGHT = -1;

    public Creatures(BufferedImage img, int col, int row, float left, float right, float top, float bottom, float scale) {
        super(col, row, img.getWidth(), img.getHeight(), left, right, top, bottom, scale);
        x = (float) (((float) this.getRow() * 47 + 47 / 2.0 - this.getWidth() / 2.0));
        y = (float) (((float) this.getCol() * 47 + 47 / 2.0 - this.getHeight() / 2.0));
        xBox = (this.getX() + this.getLeft());
        xBox = (this.getY() + this.getTop());
        this.stateDirection = STATE_DIR_LEFT;
        this.img = img;
    }

    private void updateBox() {
    }

    public void force(float xForce, float yForce) {
        this.xForce = xForce;
        this.yForce = yForce;
    }

    @Override
    public void draw(Graphics2D g2s) {
        if (this.stateDirection < 0) {
            g2s.drawImage(this.img, (int) this.x + (int) (this.width), (int) this.y, (int) this.width * this.stateDirection, (int) this.height, null);
        } else {
            g2s.drawImage(this.img, (int) this.x, (int) this.y, (int) this.width * this.stateDirection, (int) this.height, null);
        }
    }

    protected abstract void updateExtends();

    @Override
    public void update() {
        if (xForce > 0) {
            this.stateDirection = STATE_DIR_RIGHT;
        } else if (xForce < 0) {
            this.stateDirection = STATE_DIR_LEFT;
        }
        this.x = x + this.xForce;
        this.y = y + this.yForce;

        updateBox();
        updateExtends();
    }

}
