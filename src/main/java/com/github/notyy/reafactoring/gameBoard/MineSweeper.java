package com.github.notyy.reafactoring.gameBoard;

import java.util.ArrayList;
import java.util.List;

public class MineSweeper {
    List<int[]> theList = new ArrayList<int[]>();

    public List<int[]> getThem() {
        List<int[]> list1 = new ArrayList<int[]>();
        for(int[] x: theList){
            if(x[0] == 1){
                list1.add(x);
            }
        }
        return list1;
    }

    public boolean isFlaged(int x, int y) {
        List<int[]> list2 = getThem();
        for(int[] i: list2){
            if(i[1] == x && i[2] == y){
                return true;
            }
        }
        return false;
    }
}
