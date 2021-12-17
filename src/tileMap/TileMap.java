/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tileMap;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import main.GamePanel;

/**
 *
 * @author HP
 */
public class TileMap {
    public BufferedImage mapImage;
    public TileMap[][] tiles;
    public GamePanel game;
    public TileMap(int[][] matrix,GamePanel game)
    {
        this.game=game;
        tiles=new TileMap[matrix.length][matrix[0].length];
        float widthToDraw=matrix.length*47;
        float heightToDraw=matrix[0].length*47;
        mapImage=new BufferedImage((int)widthToDraw, (int)heightToDraw, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d=(Graphics2D) mapImage.getGraphics();
        g2d.setColor(new Color(90,188,216));
        g2d.fillRect(0, 0, mapImage.getWidth(),mapImage.getHeight());
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                 if(matrix[i][j]==1)
                     g2d.drawImage(game.asset.tile, i*47, j*47, 48, 55, null);
            }
        }
    }
}
