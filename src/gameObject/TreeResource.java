/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameObject;

import java.awt.image.BufferedImage;
import java.nio.Buffer;
import javax.imageio.ImageIO;

/**
 *
 * @author HP
 */
public class TreeResource extends ResourceEntity{
    
    public TreeResource(BufferedImage img,int col, int row, float left, float right, float top, float bottom, float scale) {
        super(col, row, img.getWidth(), img.getHeight(), left, right, top, bottom, scale);
        this.img=img;
    }
    
}
