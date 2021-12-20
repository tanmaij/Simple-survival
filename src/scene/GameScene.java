/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scene;

import gameObject.CoalResource;
import gameObject.FruitResource;
import gameObject.IronResource;
import gameObject.Player;
import gameObject.ResourceEntity;
import gameObject.RockResource;
import gameObject.TreeResource;
import gameObject.GameEntity;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import main.GamePanel;
import tileMap.TileMap;
import utils.ArrayListUtils;

/**
 *
 * @author HP
 */
public class GameScene extends Scene{
    
    int xCamera,yCamera;
    TileMap tileMap;
    GamePanel game;
    ArrayList<GameEntity> entities;
    Player player;
    BufferedImage bfrimg;
    public GameScene(GamePanel game,int size, int difficult) {
        this.game=game;
        this.entities=new ArrayList<>();
    }
    
    public void newGame()
    {
        
        Random random=new Random();
        int numResourceEntity=random.nextInt(100)+100;
        int numLand=random.nextInt(2000)+6000;
        int[][] matrix=new int[100][100];
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                matrix[i][j]=-1;
            }
        }
        
        Point rand=new Point(random.nextInt(100-1), random.nextInt(100-1));
        matrix[rand.x][rand.y]=1;
        ArrayList<Point> open=new ArrayList<>();
        open.add(new Point(rand.x-1, rand.y));
        open.add(new Point(rand.x, rand.y-1));
        open.add(new Point(rand.x+1, rand.y));
        open.add(new Point(rand.x, rand.y+1));
        
         open.removeIf(point -> point.x<0 || point.x==100 || point.y<0 || point.y==100);
        for (int i = 0; i < numLand; i++) {
           int randIndexNewPoint=random.nextInt(open.size());
           Point randNewPoint=new Point(open.get(randIndexNewPoint));
           while(true)
           {
           if(matrix[randNewPoint.x][randNewPoint.y]==1){
               randIndexNewPoint=random.nextInt(open.size());
               randNewPoint=new Point(open.get(randIndexNewPoint));
           }else{
               break;
           }
           }
           matrix[randNewPoint.x][randNewPoint.y]=1;
           open.add(new Point(randNewPoint.x-1, randNewPoint.y));
           open.add(new Point(randNewPoint.x, randNewPoint.y-1));
           open.add(new Point(randNewPoint.x+1, randNewPoint.y));
           open.add(new Point(randNewPoint.x, randNewPoint.y+1));
           
            open.removeIf(point -> point.x<0 || point.x==100 || point.y<0 || point.y==100);
        }
        this.tileMap=new TileMap(matrix, game);
        float widthToDraw=matrix.length*47;
        float heightToDraw=matrix[0].length*47;
        this.bfrimg=new BufferedImage((int)widthToDraw, (int)heightToDraw, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < numResourceEntity; i++) {
            int ranRow=random.nextInt(100);
            int ranCol=random.nextInt(100);
            if((ArrayListUtils.rowColIsExist(entities, ranCol, ranRow)))
                System.err.println("kkkk");
            if(matrix[ranRow][ranCol]==-1 || ArrayListUtils.rowColIsExist(entities, ranCol, ranRow)){
            }
            else{
            int ranSrc=random.nextInt(5);
            
            {
               if(ranSrc==0)
                this.entities.add(new TreeResource(this.game.asset.tree,ranCol,ranRow, 90, 90, 300, 0, 1f/3f));
             else if(ranSrc==1)
                this.entities.add(new CoalResource(this.game.asset.coalMine,ranCol,ranRow, 0, 0, 100, 0, 1f/4f));
              else if(ranSrc==2)
                this.entities.add(new FruitResource(this.game.asset.redBush,this.game.asset.redBushEmpty, ranCol,ranRow, 0, 0, 150, 0, 1f/4f));
             else if(ranSrc==3)
                this.entities.add(new IronResource(this.game.asset.ironMine, ranCol,ranRow, 0, 0, 100, 0, 1f/4f));
              else if(ranSrc==4)
                this.entities.add(new RockResource(this.game.asset.rockMine, ranCol,ranRow, 0, 0, 100, 0, 1f/4f));
               
            }
            }
        }
        int ranRowPlayer=0;
        int ranColPlayer=0;
        while(true)
        {
            ranColPlayer=random.nextInt(100);
            ranRowPlayer=random.nextInt(100);
           if(matrix[ranRowPlayer][ranColPlayer]==-1 || ArrayListUtils.rowColIsExist(entities, ranColPlayer, ranRowPlayer)){
               
            }
           else
            break;
        }
        this.player=new Player(this.game.asset.player.get(0), this.game.asset.player.get(1), ranColPlayer, ranRowPlayer, 0, 0, 250, 0, 1f/5f,this);
        this.entities.add(player);
        
    }
    @Override
    public void draw(Graphics2D g2d) {
        
        if(this.bfrimg!=null){ 
        Graphics2D g2s=(Graphics2D) this.bfrimg.getGraphics();
        
        if(this.tileMap !=null)
        g2s.drawImage(this.tileMap.mapImage,0,0,null);
        entities.sort(Comparator.comparing(GameEntity::getEndPosition));
        for (GameEntity entity : entities) {
            entity.draw(g2s);
        }
        g2d.drawImage(bfrimg, xCamera, yCamera, null);
        }
    }

    @Override
    public void update() {       
        for (GameEntity entity : entities) {
            entity.update();
        }
        if(player!=null)
        uploadCamera();

    }
    public void uploadCamera()
    {
        this.xCamera=-(int) ((int) player.getX()-this.game.width/2+this.player.getWidth()/2);
        this.yCamera=-(int) ((int) player.getY()-this.game.height/2+this.player.getHeight()/2);
        if(this.xCamera>0)
            this.xCamera=0;
        if(this.xCamera<-this.tileMap.mapImage.getWidth()+this.game.width)
            this.xCamera=-this.tileMap.mapImage.getWidth()+this.game.width;
         if(this.yCamera>0)
            this.yCamera=0;
        if(this.yCamera<-this.tileMap.mapImage.getHeight()+this.game.height)
            this.yCamera=-this.tileMap.mapImage.getHeight()+this.game.height;
    }

    @Override
    public void keyPress(int key) {
        this.player.keyDownListenner(key);
    }

    @Override
    public void keyTypes(int key) {
        
    }

    @Override
    public void keyReleased(int key) {
        this.player.keyReleaseListenner(key);
    }

    public ArrayList<GameEntity> getEntities() {
        return entities;
    }
    
}
