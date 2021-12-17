/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameObject;

import java.awt.image.BufferedImage;

/**
 *
 * @author HP
 */
public class FruitResource extends ResourceEntity{
    BufferedImage imgEmpty;
    BufferedImage imgAlready;
    public FruitResource(BufferedImage imgAlready,BufferedImage imgEmpty,int col, int row, float left, float right, float top, float bottom, float scale) {
        super(col, row, imgAlready.getWidth(), imgAlready.getHeight(), left, right, top, bottom, scale);
        this.img=imgAlready;
        this.imgEmpty=imgEmpty;
        this.imgAlready=imgAlready;
    }
}
