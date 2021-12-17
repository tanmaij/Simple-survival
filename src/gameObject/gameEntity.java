/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameObject;

import java.awt.Graphics2D;

/**
 *
 * @author HP
 */
public abstract class gameEntity {
    protected int col,row;
    protected float x,y,width,height,xBox,yBox,widthBox,heigthBox,left,right,top,bottom,scale;

    public gameEntity(int col, int row,  float width, float height, float left, float right, float top, float bottom, float scale) {
        this.scale = scale;
        this.col = col;
        this.row = row;
        this.width = (int)(width*scale);
        
        this.height = (int)(height*scale);
        this.left = (int)(left*scale);
        this.right = (int)(right*scale);
        this.top = (int)(top*scale);
        this.bottom = (int)(bottom*scale);
        this.widthBox = this.width-this.right-this.left;
        this.heigthBox = this.height-this.top-this.bottom;
    }
    public abstract void draw(Graphics2D g2s);
    public abstract void update();
    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    public int getEndPosition(){
        return (int) (this.y+this.height);
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getxBox() {
        return xBox;
    }

    public void setxBox(float xBox) {
        this.xBox = xBox;
    }

    public float getyBox() {
        return yBox;
    }

    public void setyBox(float yBox) {
        this.yBox = yBox;
    }

    public float getWidthBox() {
        return widthBox;
    }

    public void setWidthBox(float widthBox) {
        this.widthBox = widthBox;
    }

    public float getHeigthBox() {
        return heigthBox;
    }

    public void setHeigthBox(float heigthBox) {
        this.heigthBox = heigthBox;
    }

    public float getLeft() {
        return left;
    }

    public void setLeft(float left) {
        this.left = left;
    }

    public float getRight() {
        return right;
    }

    public void setRight(float right) {
        this.right = right;
    }

    public float getTop() {
        return top;
    }

    public void setTop(float top) {
        this.top = top;
    }

    public float getBottom() {
        return bottom;
    }

    public void setBottom(float bottom) {
        this.bottom = bottom;
    }

    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }
    
    
}
