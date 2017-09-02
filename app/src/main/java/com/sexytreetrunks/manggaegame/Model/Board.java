package com.sexytreetrunks.manggaegame.Model;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by sexytreetrunks on 2017. 8. 22..
 */

public class Board {
    private int level;
    private int size;
    private int size_level;
    private int variety;
    private GameState state;
    public enum GameState { IN_PROGRESS, FINISHED }

    private int mangGaeMatrix[][];

    static int IMG_LENGTH;
    private static final HashMap<Integer, double[]> PERCENTAGE_DATA= new HashMap<>();
    static {
        PERCENTAGE_DATA.put(2, new double[]{0.45,1});
        PERCENTAGE_DATA.put(3, new double[]{0.3,0.6,1});
        PERCENTAGE_DATA.put(4, new double[]{0.2,0.45,0.7,1});
        IMG_LENGTH = 26;
    } // 넘 지저분함

    public Board() {
        reset();
    }

    public void reset() {
        level = 1;
        size = 4;
        size_level = 4;
        variety = 2;
        state = GameState.IN_PROGRESS;
        allocateMangGae();
    }

    public boolean isDominantMangGae(int row, int col) {
        int mangGaeValue = mangGaeMatrix[row][col];
        int key = 0;
        HashMap<Integer,Integer> hm = new HashMap();
        for (int i = 0; i < mangGaeMatrix.length; i++) {
            for (int j=0; j < mangGaeMatrix[i].length; j++) {
                key = mangGaeMatrix[i][j];
                if (hm.containsKey(key))
                    hm.put(key, hm.get(key)+1);
                else
                    hm.put(key, 1);
            }
        }
        int max = 0;
        for (int i:hm.keySet()) {
            if (max < hm.get(i)) {
                key = i;
                max = hm.get(i);
            }
        }
        if (mangGaeValue == key)
            return true;
        return false;
    }

    public void levelUp() {
        level++;
        if (level == 256) {
            state = GameState.FINISHED;
            return;
        }
        if (level >= 16) {
            if (level == size_level*4) {
                size++;
                size_level *= 4;
                variety = 2;
                return;
            }
            if (level % size_level == 0)
                variety++;
        }
    }

    public boolean isRoot(int root, int n) {
        double num = n;
        while (num > root) {
            num = num/root;
        }
        if(num == root)
            return true;
        return false;
    }

    public int[][] allocateMangGae() {
        initMatrixValue();
        shuffleMatrix();
        return mangGaeMatrix;
    }

    private void initMatrixValue() { //문제점 : 코드가 안이쁨 로직이 한눈에 안들어옴.
        double[] percentage_data = PERCENTAGE_DATA.get(variety);

        Random random = new Random();
        random.setSeed(System.currentTimeMillis());

        int rear = 0;
        int value = random.nextInt(IMG_LENGTH);
        int arraysize = size * size;

        mangGaeMatrix = new int[size][size];
        for(int i = 0; i < mangGaeMatrix.length; i++) {
            for (int j = 0; j < mangGaeMatrix[i].length; j++) {
                mangGaeMatrix[i][j] = value;
                int arrayIndex = i * size + j;
                if (arrayIndex == (int) (percentage_data[rear] * arraysize - 1)) {
                    rear++;
                    value = random.nextInt(IMG_LENGTH);
                }
            }
        }
    }

    private void shuffleMatrix() {
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        for (int i = mangGaeMatrix.length - 1; i > 0; i--) {
            for (int j = mangGaeMatrix[i].length - 1; j > 0; j--) {
                int m = random.nextInt(i + 1);
                int n = random.nextInt(j + 1);

                int temp = mangGaeMatrix[i][j];
                mangGaeMatrix[i][j] = mangGaeMatrix[m][n];
                mangGaeMatrix[m][n] = temp;
            }
        }
    }

    public int getLevel() {
        return level;
    }

    public int getSize() {
        return size;
    }

    public int getSize_level() {
        return size_level;
    }

    public int getVariety() {
        return variety;
    }

    public int getValueFromMatrix(int row, int col) {
        return mangGaeMatrix[row][col];
    }

    public GameState getState() {
        return state;
    }
}
