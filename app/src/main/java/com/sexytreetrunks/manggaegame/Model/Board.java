package com.sexytreetrunks.manggaegame.Model;

import java.util.ArrayList;
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

    private int mangGaeMatrix[][];


    private static final HashMap<Integer, double[]> PERCENTAGE_DATA= new HashMap<>();
    static {
        PERCENTAGE_DATA.put(2, new double[]{0.45,1});
        PERCENTAGE_DATA.put(3, new double[]{0.3,0.6,1});
        PERCENTAGE_DATA.put(4, new double[]{0.2,0.45,0.7,1});
    } // 넘 지저분함

    Board() {
        reset();
    }

    public boolean isDominantMangGae(int chosenIndex1, int chosenIndex2) {
        int mangGaeValue = mangGaeMatrix[chosenIndex1][chosenIndex2];
        if (mangGaeValue == variety)
            return true;
        return false;
    }

    public void levelUp() {
        level++;
        if (level >= 16) {
            if (isRoot(16,level)) {
                size++;
                size_level *= 16;
                variety = 2;
                return;
            }
            if (((level - size_level) % size_level) == 0)
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

    public void reset() {
        level = 1;
        size = 4;
        size_level = 1;
        variety = 2;
        allocateMangGae();
    }

    public void allocateMangGae() {
        initMatrixValue();
        shuffleMatrix();
    }

    private void initMatrixValue() { //문제점 : 코드가 안이쁨 로직이 한눈에 안들어옴.
        double[] percentage_data = PERCENTAGE_DATA.get(variety);

        int rear = 0;
        int arraysize = size * size;

        mangGaeMatrix = new int[size][size];
        //가장 많은 셀을 차지하는 값이 가장 큰수가 되도록함.
        for(int i = 0; i < mangGaeMatrix.length; i++) {
            for (int j = 0; j < mangGaeMatrix[i].length; j++) {
                mangGaeMatrix[i][j] = rear + 1; // 1~variety값만 가짐
                int arrayIndex = i * size + j;
                if (arrayIndex == (int) (percentage_data[rear] * arraysize - 1))
                    rear++;
            }
        }
    }

    private void shuffleMatrix() {
        Random random = new Random();

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
}
