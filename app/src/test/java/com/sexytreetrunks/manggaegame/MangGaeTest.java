package com.sexytreetrunks.manggaegame;

import com.sexytreetrunks.manggaegame.Model.Board;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.notification.RunListener;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class MangGaeTest {
    private Board board;

    @Before
    public void setup() {
        board = new Board();
    }

    //테스트 해야 할것
    //1. dominantmanggae를 선택했는지 판단하는 여부
    //     -- 이건 dominant manggae인 망개가 variety값 가지도록 percentage_Data를 짰는데 실제로 랜덤값 넣고 실행했을떄 이게 일케 되는지 확인하는거임.
    //2. levelup 잘되는지 확인

    @Test //2
    public void isCorrectVariableWhenLevelup() {
        for(int level=2; level<= 256; level++) {
            board.levelUp();
            switch (level) {
                case 16:
                    assertEquals("size_assert",5,board.getSize());
                    assertEquals("variety_assert",2,board.getVariety());
                    assertEquals("size_level_assert",16,board.getSize_level());
                    break;
                case 32:
                    assertEquals("size_assert",5,board.getSize());
                    assertEquals("variety_assert",3,board.getVariety());
                    assertEquals("size_level_assert",16,board.getSize_level());
                    break;
                case 64:
                    assertEquals("size_assert",6,board.getSize());
                    assertEquals("variety_assert",2,board.getVariety());
                    assertEquals("size_level_assert",64,board.getSize_level());
                    break;
                case 128:
                    assertEquals("size_assert",6,board.getSize());
                    assertEquals("variety_assert",3,board.getVariety());
                    assertEquals("size_level_assert",64,board.getSize_level());
                    break;
                case 192:
                    assertEquals("size_assert",6,board.getSize());
                    assertEquals("variety_assert",4,board.getVariety());
                    assertEquals("size_level_assert",64,board.getSize_level());
                    break;
            }
        }
    }//levelup 존나게 한다음에 특정 레벨에서(변수값이 바껴야하는 레벨--> 16, 32,64,, 등등) 변수값 assert

    @Test
    public void checkDominantMangGaeMethod() {
        int[][] matrix = board.allocateMangGae();
        HashMap<Integer,Integer> hashMap = new HashMap<>();

        for(int i=0; i< matrix.length; i++) {
            for (int j=0; j<matrix[i].length;j++) {
                int current = matrix[i][j];
                if(hashMap.containsKey(current))
                    hashMap.put(current,hashMap.get(current)+1);
                else
                    hashMap.put(current,1);
            }
        }

        int maxValue = 0;
        int maxKey = 0;
        for(int key:hashMap.keySet()) {
            int value = hashMap.get(key);
            if(maxValue < value) {
                maxValue = value;
                maxKey = key;
            }
        }

        assertEquals(maxKey,board.getVariety());

    }//allocate 한담에 isDominant의 결과값과 하나하나 망개를 세어서 나온 결과값이 같은지 assert
    //level size에 따라서 잘 되는지 확인필요
}