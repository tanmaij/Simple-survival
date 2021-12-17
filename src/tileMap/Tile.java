/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tileMap;

/**
 *
 * @author HP
 */
public class Tile {
    private boolean block;
    private final float x;
    private final float y;
    public Tile(boolean block,int x,int y){
        this.block=block;
        this.x=x;
        this.y=y;
    }
    
    public boolean isBlock() {
        return block;
    }

    public void setBlock(boolean block) {
        this.block = block;
    }
    
}
