/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameObject;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import main.GamePanel;
import scene.GameScene;

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
    GameScene gameScene;
    public Creatures(BufferedImage img, int col, int row, float left, float right, float top, float bottom, float scale,GameScene gameScene) {
        
        super(col, row, img.getWidth(), img.getHeight(), left, right, top, bottom, scale);
        this.gameScene=gameScene;
        x = (float) (((float) this.getRow() * 47 + 47 / 2.0 - this.getWidth() / 2.0));
        y = (float) (((float) this.getCol() * 47 + 47 / 2.0 - this.getHeight() / 2.0));
        xBox = (this.getX() + this.getLeft());
        yBox = (this.getY() + this.getTop());
        this.stateDirection = STATE_DIR_LEFT;
        this.img = img;
    }

    private void updateBox() {
        xBox = (this.getX() + this.getLeft());
        yBox = (this.getY() + this.getTop());
        System.err.println(xBox+" "+yBox+" "+widthBox+" "+heigthBox);
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
        
        updateBox();
        if (xForce > 0) {
            this.stateDirection = STATE_DIR_RIGHT;
        } else if (xForce < 0) {
            this.stateDirection = STATE_DIR_LEFT;
        }
        float xToUpdate=xForce;
        float yToUpdate=yForce;

        if(this.xForce>0)
            if(checkCollisionLeft())
                xToUpdate=0;
        if(this.xForce<0)
            if(checkCollisionRight())
                xToUpdate=0;
        if(this.yForce>0)
            if(checkCollisionTop())
                yToUpdate=0;
         if(this.yForce<0)
            if(checkCollisionBottom())
                yToUpdate=0;
        this.x = x + xToUpdate;
        this.y = y + yToUpdate;

        updateExtends();
    }
    boolean checkCollisionLeft()
    {
        for (GameEntity gameEntity : this.gameScene.getEntities()) {
            if(gameEntity.checkCollisionLeft(this))
                return true;
        }
        return false;
    }
    boolean checkCollisionRight()
    {
        for (GameEntity gameEntity : this.gameScene.getEntities()) {
            if(gameEntity.checkCollisionRight(this))
                return true;
        }
        return false;
    }
    boolean checkCollisionTop()
    {
        for (GameEntity gameEntity : this.gameScene.getEntities()) {
            if(gameEntity.checkCollisionTop(this))
                return true;
        }
        return false;
    }
    boolean checkCollisionBottom()
    {
        for (GameEntity gameEntity : this.gameScene.getEntities()) {
            if(gameEntity.checkCollisionBottom(this))
                return true;
        }
        return false;
    }
             

}
