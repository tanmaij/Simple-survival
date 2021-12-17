/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asset;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author HP
 */
public class ImageManager {
    public ArrayList<BufferedImage> player; //1000 200 0 300 // 1000 200 320 300
    public BufferedImage ironArrow; //3320 240  50 240
    public BufferedImage ironSword;//sword 3540 230 70 320
    public BufferedImage ironAxe;//axe 3890 230 70 180
    public BufferedImage ironPickAxe;//pickaxe 4210 190 80 190
    public BufferedImage ironShovel;// hoe 4530 210 60 210
    public BufferedImage rockArrow; //3320 240  370 240
    public BufferedImage rockSword;//sword 3540 230 390 320
    public BufferedImage rockAxe;//axe 3890 230 390 180
    public BufferedImage rockPickAxe;//pickaxe 4210 190 400 190
    public BufferedImage rockShovel;// shovel 4530 210 380 210
    public BufferedImage woodSword;//sword 3540 230 720 320
    public BufferedImage woodAxe;//axe 3890 230 720 180
    public BufferedImage woodPickAxe;//pickaxe 4210 190 730 190
    public BufferedImage woodShovel;// shovel 4530 210 710 210
    public BufferedImage bow; // 3280 200 700 200
    public BufferedImage tile;//tile 0 960 3520 1110
    public BufferedImage ironChest;//iron chest 1630 260 1010 260
    public BufferedImage woodChest;//iron chest 1950 260 1010 260
    public BufferedImage craftingTable; //crafting table 2270 260 1000 250
    public BufferedImage furnace;// furnace 2590 260 970 310
    public BufferedImage ivil;// ivil 2900 240 1020 200
    public BufferedImage stick;// stick 3860 250 1330 250 
    public BufferedImage ironBowl;// ironBowl 3570 230 1670 200
    public BufferedImage woodBowl;// woodBowl 3890 230 1670 200
    public BufferedImage ironBowlSoup;// ironBowlSoup 4210 230 1670 200
    public BufferedImage woodBowlSoup;// woodBowlSoup 4530 230 1670 200
    public BufferedImage barbecue;// barbecue 4800 270 1600 310
    public BufferedImage meet;// meat 4800 270 1920 310
    public BufferedImage redFruit;//redFruit 4480 230 1950 280
    public BufferedImage blueFruit;//blueFruit 4200 230 1930 260
    public BufferedImage wood;//wood 3870 230 1980 230
    public BufferedImage rock;//rock 3560 250 1980 180
    public BufferedImage coal;//coal 3240 250 1990 180
    public BufferedImage iron;//iron 2920 260  1960 210 
    public BufferedImage slime;//slime 2630 230 2030 190
    public BufferedImage ironBaked;//ironBaked 2900 260 1649 250
    public BufferedImage ironMine;//2930 250 2400 160
    public BufferedImage coalMine;//3250 250 2390 170
    public BufferedImage rockMine;// 3570 250 2410 150
    public BufferedImage tree;// 3890 220 2240 320
    public BufferedImage blueBush;//4160 320 2330 230 
    public BufferedImage redBush;//4480 320 2330 230 
    public BufferedImage blueBushEmpty; //4160 320 2650 230 
    public BufferedImage redBushEmpty;//4480 320 265 230 
    public ImageManager()
    {
        try {
            BufferedImage asset=ImageIO.read(getClass().getResourceAsStream("/asset/Pack2020x10.png"));
    player=new ArrayList<>(); //1000 200 0 300 // 1000 200 320 300
    player.add(asset.getSubimage(1000,1, 200, 300));
    player.add(asset.getSubimage(1000,320, 200, 300));
    ironArrow=asset.getSubimage(3320,50, 240 , 240); //3320 240  50 240
    ironSword=asset.getSubimage(3540,70, 230, 320);//sword 3540 230 70 320
    ironAxe=asset.getSubimage(3890 ,70,230, 180);//axe 3890 230 70 180
    ironPickAxe=asset.getSubimage(4210,80, 190, 190);//pickaxe 4210 190 80 190
    ironShovel=asset.getSubimage(4530,60, 210, 210);// hoe 4530 210 60 210
    rockArrow=asset.getSubimage(3320 ,370,240, 240); //3320 240  370 240
    rockSword=asset.getSubimage(3540,390 ,230, 320);//sword 3540 230 390 320
    rockAxe=asset.getSubimage(3890,390, 230 , 180);//axe 3890 230 390 180
    rockPickAxe=asset.getSubimage(4210,400 ,190, 190);//pickaxe 4210 190 400 190
    rockShovel=asset.getSubimage(4530,380, 210, 210);// shovel 4530 210 380 210
    woodSword=asset.getSubimage(3540,720,230, 320);//sword 3540 230 720 320
    woodAxe=asset.getSubimage(3890,720, 230, 180);//axe 3890 230 720 180
    woodPickAxe=asset.getSubimage(4210,730, 190, 190);//pickaxe 4210 190 730 190
    woodShovel=asset.getSubimage(4540,700, 200, 200);// shovel 4530 210 710 210
    bow=asset.getSubimage(3280,700, 200, 200); // 3280 200 700 200
    tile=asset.getSubimage(0,3520, 960, 1110);//tile 0 960 3520 1110
    ironChest=asset.getSubimage(1630,1010, 260, 260);//iron chest 1630 260 1010 260
    woodChest=asset.getSubimage(1950,1010, 260, 260);//iron chest 1950 260 1010 260
    craftingTable=asset.getSubimage(2270,1000, 260, 250); //crafting table 2270 260 1000 250
    furnace=asset.getSubimage(2590,970, 260 , 310);// furnace 2590 260 970 310
    ivil=asset.getSubimage(2900,1020, 240, 200);// ivil 2900 240 1020 200
    stick=asset.getSubimage(3860,1330, 250, 250 );// stick 3860 250 1330 250 
    ironBowl=asset.getSubimage(3570,1670, 230, 200);// ironBowl 3570 230 1670 200
    woodBowl=asset.getSubimage(3890,1670, 230, 200);// woodBowl 3890 230 1670 200
    ironBowlSoup=asset.getSubimage(4210,1670, 230, 200);// ironBowlSoup 4210 230 1670 200
    woodBowlSoup=asset.getSubimage(4530,1670, 230, 200);// woodBowlSoup 4530 230 1670 200
    barbecue=asset.getSubimage(4800,1600, 270, 310);// barbecue 4800 270 1600 310
    meet=asset.getSubimage(4800,1920, 270, 310);// meat 4800 270 1920 310
    redFruit=asset.getSubimage(4480,1950,230, 280);//redFruit 4480 230 1950 280
    blueFruit=asset.getSubimage(4200 ,1930,230, 260);//blueFruit 4200 230 1930 260
     wood=asset.getSubimage(3870, 1980,230, 230);//wood 3870 230 1980 230
    rock=asset.getSubimage(3560,1980, 250, 180);//rock 3560 250 1980 180
    coal=asset.getSubimage(3240,1990, 250, 180);//coal 3240 250 1990 180
    iron=asset.getSubimage(2920,1960, 260 , 210 );//iron 2920 260  1960 210 
    slime=asset.getSubimage(2630,2030 ,230, 190);//slime 2630 230 2030 190
    ironBaked=asset.getSubimage(2900,1649, 260, 250);//ironBaked 2900 260 1649 250
    ironMine=asset.getSubimage(2930,2400, 250, 160);//2930 250 2400 160
    coalMine=asset.getSubimage(3250,2390, 250, 170);//3250 250 2390 170
    rockMine=asset.getSubimage(3570, 2410,250, 150);// 3570 250 2410 150
    tree=asset.getSubimage(3890,2240, 220, 320);// 3890 220 2240 320
    blueBush=asset.getSubimage(4160,2330, 320, 230 );//4160 320 2330 230 
    redBush=asset.getSubimage(4480,2330, 320, 230 );//4480 320 2330 230 
    blueBushEmpty=asset.getSubimage(4160,2650, 320, 230 ); //4160 320 2650 230 
     redBushEmpty=asset.getSubimage(4480,265, 320, 230 );//4480 320 265 230 
        } catch (IOException ex) {
            Logger.getLogger(ImageManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
