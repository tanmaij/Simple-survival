/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scene;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import main.GamePanel;

/**
 *
 * @author HP
 */
public class SceneManager {
    private ArrayList<Scene> scenes;
    GamePanel game;
    private int currentScene=0;
    private final int MENU_SCENE_INDEX=0;
    private final int LEVEL1_SCENE_INDEX=1;
     GameScene gameScene;
    public SceneManager(GamePanel game){
        this.game=game;
        gameScene=new GameScene(game,1,2);
        scenes=new ArrayList<>();
        scenes.add(new MenuScene(game,this));
        scenes.add(gameScene);
    }
    public void keyPress(KeyEvent key){
        
        this.scenes.get(currentScene).keyPress(key.getKeyCode());
    }
    public void keyTypes(KeyEvent key){
        this.scenes.get(currentScene).keyTypes(key.getKeyCode());}
    public void keyReleased(KeyEvent key){
        this.scenes.get(currentScene).keyReleased(key.getKeyCode());
    }
    public void draw(Graphics2D g2d){
        g2d.clearRect(0, 0, this.game.width, this.game.height);
        this.scenes.get(currentScene).draw(g2d);
    }
    public void update(){
        this.scenes.get(currentScene).update();
    }
    public Scene getCurrentScene() {
        return this.scenes.get(currentScene);
    }
    
    public void setCurrentScene(int currentScene) {
        this.currentScene = currentScene;
        System.out.println(this.currentScene);
        if(this.currentScene==1)
        {
            this.gameScene.newGame();
        }
    }
    
}
