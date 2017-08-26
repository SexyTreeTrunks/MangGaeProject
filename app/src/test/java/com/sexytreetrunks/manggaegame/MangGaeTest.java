package com.sexytreetrunks.manggaegame;

import com.sexytreetrunks.manggaegame.Model.Board;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.notification.RunListener;

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
    //2. levelup 잘되는지 확인

    @Test //2
    public void isCorrectVariableWhenLevelup() {


    }//levelup 존나게 한다음에 특정 레벨에서(변수값이 바껴야하는 레벨--> 16, 32,64,, 등등) 변수값 assert

    @Test
    public void testCheckingDominantMangGae() {

    }
}