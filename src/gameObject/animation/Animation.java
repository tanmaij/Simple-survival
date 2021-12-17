/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameObject.animation;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class Animation {

    private float speed;
    private float state;
    private ArrayList<BufferedImage> images;

    public Animation(float speed, ArrayList<BufferedImage> images) {
        this.speed = speed;
        this.state = 0;
        this.images = images;
    }

    public void update() {
        state += speed;
        if (state > images.size()) {
            state = 0;
        }
    }

    public BufferedImage getCurrentImage() {
        return this.images.get((int) state);
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getState() {
        return state;
    }

    public void setState(float state) {
        this.state = state;
    }

    public ArrayList<BufferedImage> getImages() {
        return images;
    }

    public void setImages(ArrayList<BufferedImage> images) {
        this.images = images;
    }

}
