/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scene;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import main.GamePanel;

/**
 *
 * @author HP
 */
public class GameScene extends Scene{

    
    public GameScene(GamePanel game,int size, int difficult) {
        Random random=new Random();
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
        
        ArrayList<Integer> indexToRemove=new ArrayList<>();
        for (int i = 0; i < open.size(); i++) {
            if(open.get(i).x<0 || open.get(i).x>=100 || open.get(i).y<0 || open.get(i).y>=100)
            {
                indexToRemove.add(i);
            }
        }
        for (int j = 0; j < indexToRemove.size(); j++) {
                int index=indexToRemove.get(j);
                open.remove(index);
            }
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
           indexToRemove.clear();
           for (int j = 0; j < open.size(); j++) {
            if(open.get(j).x<0 || open.get(j).x==100 || open.get(j).y<0 || open.get(j).y==100)
                indexToRemove.add(j);
            }
            for (int j = 0; j < indexToRemove.size(); j++) {
                int index=indexToRemove.get(j);
                open.remove(index);
            }
        }
        int count=0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if(matrix[i][j]==1)
                    count++;
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println("");
        }
    }
    
    
    @Override
    public void draw(Graphics2D g2d) {
        
    }

    @Override
    public void update() {
        
    }

    @Override
    public void keyPress(int key) {
        
    }

    @Override
    public void keyTypes(int key) {
        
    }

    @Override
    public void keyReleased(int key) {
        
    }
    
}
