/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import asset.ImageManager;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.JPanel;
import scene.SceneManager;

/**
 *
 * @author HP
 */
public class GamePanel extends JPanel implements Runnable,KeyListener{
    
    public Font gameFont;
    
    private final int MENU_SCENE=0;
    private final int GAME_SCENE=1;
    
    private final BufferedImage image;
    private final Screen screen;
    private final SceneManager sceneManager;
    private final ImageManager asset;
    public int width,height;
    
    private int gameScene;
    public GamePanel(Screen screen){
        try{
            Font f = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/asset/04B_03__.TTF"));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(f);
        }catch(Exception e){
            System.out.println(e);
        }


        this.screen=screen;
        this.width=screen.width;
        this.height=screen.height;
        super.setSize(screen.width, screen.height);
        this.asset=new ImageManager();
        this.image=new BufferedImage(screen.width, screen.height,BufferedImage.TYPE_INT_RGB);
        this.sceneManager=new SceneManager(this);
        this.sceneManager.setCurrentScene(MENU_SCENE);
        this.addKeyListener(this);
    }
    private final int Fps=60;
    private final long TargetTime=1000/Fps;
    boolean running=true;
    long El;
    long wait;
    long start;
    @Override
    public void run() {
        while(running==true)
        {
        
         update();
         draw();
         repaint();
         start=System.nanoTime();
         El=System.nanoTime()-start;
         wait=TargetTime-El/1000000;
            try {
            Thread.sleep(wait);
            } catch (InterruptedException ex) {
               
            }
        }   
    }
    private void draw(){
        Graphics2D g2d=(Graphics2D) image.getGraphics();
        this.sceneManager.draw(g2d);
        
    }
    private void update(){
        this.sceneManager.update();
    }
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d=(Graphics2D)g;
        g2d.drawImage(image, 0, 0, null);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
       this.sceneManager.keyPress(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
