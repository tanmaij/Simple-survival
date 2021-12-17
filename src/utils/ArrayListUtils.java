/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import gameObject.ResourceEntity;
import gameObject.gameEntity;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class ArrayListUtils {
    static public boolean rowColIsExist(ArrayList<gameEntity> list, int col, int row){
        for (gameEntity gameEntity1 : list) {
            if(gameEntity1.getCol()==col && gameEntity1.getRow()==row)
                return true;
        }
        return false;
    }
}
