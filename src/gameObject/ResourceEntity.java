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
public class ResourceEntity extends GameEntity {

    protected BufferedImage img;
    protected int numResource;
    public ResourceEntity(int col, int row, float width, float height, float left, float right, float top, float bottom, float scale) {
        super(col, row, width, height, left, right, top, bottom, scale);
        x = (float) (((float) this.getRow() * 47 + 47 / 2.0 - this.getWidth() / 2.0));
        y = (float) (((float) this.getCol() * 47 + 47 / 2.0 - this.getHeight() / 2.0));
        xBox = (this.getX() + this.getLeft());
        yBox = (this.getY() + this.getTop());
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.drawImage(img, (int) this.getX(), (int) this.getY(), (int) this.getWidth(), (int) this.getHeight(), null);
    }

    @Override
    public void update() {

    }
    public boolean checkCollisionLeft( Creatures creatures )
    {
      float xBox= creatures.getxBox();
      float yBox= creatures.getyBox();
      float wBox= creatures.getWidthBox();
      float hBox= creatures.getHeigthBox();
      return ((xBox+wBox)>=this.xBox && (xBox+wBox)<=this.xBox+this.widthBox  && (yBox < this.yBox+this.heigthBox && yBox+hBox>this.yBox));
    }

    @Override
    protected boolean checkCollisionRight(Creatures creatures) {
       float xBox= creatures.getxBox();
      float yBox= creatures.getyBox();
      float wBox= creatures.getWidthBox();
      float hBox= creatures.getHeigthBox();
      return ((xBox)<=this.xBox+this.widthBox && (xBox+wBox)>=this.xBox+this.widthBox  && (yBox < this.yBox+this.heigthBox && yBox+hBox>this.yBox));
    
    }

    @Override
    protected boolean checkCollisionTop(Creatures creatures) {
      float xBox= creatures.getxBox();
      float yBox= creatures.getyBox();
      float wBox= creatures.getWidthBox();
      float hBox= creatures.getHeigthBox();
      return ((xBox)<=this.xBox+this.widthBox && (xBox+wBox)>=this.xBox  && (yBox < this.yBox+this.heigthBox && yBox+hBox>=this.yBox));
    
    }

    @Override
    protected boolean checkCollisionBottom(Creatures creatures) {
       float xBox= creatures.getxBox();
      float yBox= creatures.getyBox();
      float wBox= creatures.getWidthBox();
      float hBox= creatures.getHeigthBox();
      return ((xBox)<=this.xBox+this.widthBox && (xBox+wBox)>=this.xBox  && (yBox+hBox > this.yBox && yBox<=this.yBox+this.heigthBox));
    }
    
}
