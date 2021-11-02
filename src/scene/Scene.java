/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scene;

import java.awt.Graphics2D;

/**
 *
 * @author HP
 */
public abstract class Scene {
    protected SceneManager sceneManager;
    public abstract void draw(Graphics2D g2d); 
    public abstract void update();
    public abstract void keyPress(int key);
    public abstract void keyTypes(int key);
    public abstract void keyReleased(int key);
    
}
