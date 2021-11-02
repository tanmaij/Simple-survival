/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scene;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import main.GamePanel;

/**
 *
 * @author HP
 */
public class MenuScene extends Scene{
    
    private final int MAIN_STATE=0;
    private final int NEWGAME_STATE=1;
    private final int NEWGAME_CHOICE=0;
    private final int CONTINUE_CHOICE=1;
    private final int EXIT_CHOICE=2;
    
    private int customSizeState;
    private final int CUSTOM_SIZE_MAP_SMALL=0;
    private final int CUSTOM_SIZE_MAP_MEDIUM=1;
    private final int CUSTOM_SIZE_MAP_LARGE=2;
    
    private int customDifficultState;
    private final int CUSTOM_DIFFICULT_EASY=0;
    private final int CUSTOM_DIFFICULT_MEDIUM=1;
    private final int CUSTOM_DIFFICULT_HARD=2;
    
    private int customState;
    private final int CUSTOM_SIZE_CHOICE=2;
    private final int CUSTOM_DIFFICULT_CHOICE=1;
    private final int CUSTOM_BACK=0;
    private final int CUSTOM_START=3;
    
    private int state;
    
    private final GamePanel game;
    private int currentChoice;
    private final String[] buttonChoice={"New Game","Continue","Exit"};
    
    public MenuScene(GamePanel game){
        this.game=game;
        this.currentChoice=NEWGAME_CHOICE;
        this.state=MAIN_STATE;
        
    }
    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(new Color(90,188,216));
        g2d.fillRect(0, 0, this.game.width, this.game.height);
        
        g2d.setFont(new Font("04B03",Font.LAYOUT_RIGHT_TO_LEFT,20));
        g2d.setColor(Color.BLACK);
        if(this.state==MAIN_STATE)
        {
            for (int i = 0; i < buttonChoice.length; i++) {
            if(i==currentChoice)
               g2d.setColor(Color.red);
            else{
                g2d.setColor(Color.black);
            }
             g2d.drawString(buttonChoice[i], 200, 200+i*50);
        
            }
        }else if(this.state==NEWGAME_STATE)
        {
            g2d.setColor(Color.red);
            if(customState==CUSTOM_DIFFICULT_CHOICE)
            { 
                if(this.customDifficultState==CUSTOM_DIFFICULT_EASY)
                g2d.drawString("Easy", 200, 200+20);
                else if(this.customDifficultState==CUSTOM_DIFFICULT_MEDIUM)
                g2d.drawString("Normal", 200, 200+20);
                else
                    g2d.drawString("Hard", 200, 200+20);
                
                g2d.setColor(Color.black);
                if(this.customSizeState==CUSTOM_SIZE_MAP_SMALL)
                    g2d.drawString("Small", 200, 200+40);
                else if(this.customSizeState==CUSTOM_SIZE_MAP_MEDIUM)
                    g2d.drawString("Medium", 200, 200+40);
                else
                    g2d.drawString("Large", 200, 200+40);
                g2d.drawString("Back", 200-30, 200-20);
                g2d.drawString("Start", 200+30, 200+70);
            }
            else if(customState==CUSTOM_SIZE_CHOICE)
                { 
                if(this.customSizeState==CUSTOM_SIZE_MAP_SMALL)
                g2d.drawString("Small", 200, 200+40);
                else if(this.customSizeState==CUSTOM_SIZE_MAP_MEDIUM)
                g2d.drawString("Medium", 200, 200+40);
                else
                    g2d.drawString("Large", 200, 200+40);
                g2d.setColor(Color.black);
                if(this.customDifficultState==CUSTOM_DIFFICULT_EASY)
                g2d.drawString("Easy", 200, 200+20);
                else if(this.customDifficultState==CUSTOM_DIFFICULT_MEDIUM)
                g2d.drawString("Normal", 200, 200+20);
                else
                    g2d.drawString("Hard", 200, 200+20);
              
                
                 g2d.drawString("Back", 200-30, 200-20);
                 g2d.drawString("Start", 200+30, 200+70);
                    
            }
            else if(customState==CUSTOM_BACK){
                g2d.drawString("Back", 200-30, 200-20);
                g2d.setColor(Color.black);
                if(this.customDifficultState==CUSTOM_DIFFICULT_EASY)
                g2d.drawString("Easy", 200, 200+20);
                else if(this.customDifficultState==CUSTOM_DIFFICULT_MEDIUM)
                g2d.drawString("Normal", 200, 200+20);
                else
                    g2d.drawString("Hard", 200, 200+20);
       
                if(this.customSizeState==CUSTOM_SIZE_MAP_SMALL)
                g2d.drawString("Small", 200, 200+40);
                else if(this.customSizeState==CUSTOM_SIZE_MAP_MEDIUM)
                g2d.drawString("Medium", 200, 200+40);
                else
                    g2d.drawString("Large", 200, 200+40);
                g2d.drawString("Start", 200+30, 200+70);
                 
            }
            else{  
                g2d.drawString("Start", 200+30, 200+70);
                g2d.setColor(Color.black);
                if(this.customDifficultState==CUSTOM_DIFFICULT_EASY)
                    g2d.drawString("Easy", 200, 200+20);
                else if(this.customDifficultState==CUSTOM_DIFFICULT_MEDIUM)
                    g2d.drawString("Normal", 200, 200+20);
                else
                    g2d.drawString("Hard", 200, 200+20);
               
                if(this.customSizeState==CUSTOM_SIZE_MAP_SMALL)
                    g2d.drawString("Small", 200, 200+40);
                else if(this.customSizeState==CUSTOM_SIZE_MAP_MEDIUM)
                    g2d.drawString("Medium", 200, 200+40);
                else
                    g2d.drawString("Large", 200, 200+40);
                 g2d.drawString("Back", 200-30, 200-20);
                  

            }
           // System.out.println ("customState : " +customState +","+"customSizeState : " +customSizeState +",");
            
        }
    }

    @Override
    public void update() {
       
    }
    
    @Override
    public void keyPress(int key) {
    if(key==KeyEvent.VK_ENTER)
    {
        if(this.state==MAIN_STATE){
            choice(currentChoice);
        }else if(this.state==NEWGAME_STATE)
        {
            if(this.customState==CUSTOM_BACK)
                this.state=MAIN_STATE;
            else
            {
             
            }
        }
        return;
    }
    if(this.state==MAIN_STATE){
         if(key==KeyEvent.VK_DOWN)
        {
            this.currentChoice++;
            if(currentChoice>=buttonChoice.length)
                this.currentChoice=0;
        }else if(key==KeyEvent.VK_UP)
        {
            this.currentChoice--;
            if(currentChoice<0)
                this.currentChoice=buttonChoice.length-1;
        }
    }else if(this.state==NEWGAME_STATE)
    {
        
        if(key==KeyEvent.VK_DOWN)
        {
            this.customState++;
            if(this.customState>3)
                this.customState=CUSTOM_BACK;
        }
        else if(key==KeyEvent.VK_UP)
        {
            this.customState--;
            if(this.customState<0)
                this.customState=CUSTOM_START;
        }
        else if(key==KeyEvent.VK_RIGHT){
          
            if(this.customState==CUSTOM_DIFFICULT_CHOICE)
            {
            this.customDifficultState++;
            if(this.customDifficultState>2)
                this.customDifficultState=CUSTOM_DIFFICULT_EASY;  
            }   
            else if(this.customState==CUSTOM_SIZE_CHOICE)
            {
              
            this.customSizeState++;
            if(this.customSizeState>2)
                this.customSizeState=CUSTOM_SIZE_MAP_SMALL;  
            }   
        }
        else if(key==KeyEvent.VK_LEFT){
            if(this.customState==CUSTOM_DIFFICULT_CHOICE)
            {
            this.customDifficultState--;
            if(this.customDifficultState<0)
                this.customDifficultState=CUSTOM_DIFFICULT_HARD;  
            }   
            else if(this.customState==CUSTOM_SIZE_CHOICE)
            {
            this.customSizeState--;
            if(this.customSizeState<0)
                this.customSizeState=CUSTOM_SIZE_MAP_LARGE;  
            }   
        }
    }
    }
    private void choice(int choice)
    {
        if(choice==NEWGAME_CHOICE){
            this.state=NEWGAME_STATE;
            this.customState=CUSTOM_BACK;
            this.customDifficultState=CUSTOM_DIFFICULT_MEDIUM;
            this.customSizeState=CUSTOM_SIZE_MAP_MEDIUM;
        }
    }

    @Override
    public void keyTypes(int key) {
        
    }

    @Override
    public void keyReleased(int key) {
        
    }
    
}
