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
public class RockResource extends ResourceEntity{
    
    public RockResource(BufferedImage img,int col, int row, float left, float right, float top, float bottom, float scale) {
        super(col, row, img.getWidth(), img.getHeight(), left, right, top, bottom, scale);
        this.img=img;
    }
    
}
