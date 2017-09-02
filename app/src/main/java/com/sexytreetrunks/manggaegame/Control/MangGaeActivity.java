package com.sexytreetrunks.manggaegame.Control;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.sexytreetrunks.manggaegame.Model.Board;
import com.sexytreetrunks.manggaegame.R;
import com.sexytreetrunks.manggaegame.View.GameoverDialog;
import com.sexytreetrunks.manggaegame.View.ImageAdapter;

public class MangGaeActivity extends Activity implements AdapterView.OnItemClickListener{
    Board board;
    GridView gridLayout;
    ImageAdapter imageAdapter;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mang_gae);
        gridLayout = findViewById(R.id.gridView);
        textView = findViewById(R.id.textView);

        board = new Board();
        board.allocateMangGae();

        Display display = ((WindowManager)getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
        int lcdWidth = display.getWidth();
        imageAdapter = new ImageAdapter(this, board,lcdWidth);
        gridLayout.setNumColumns(board.getSize());
        gridLayout.setAdapter(imageAdapter);
        gridLayout.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        int row = i / board.getSize();
        int col = i % board.getSize();
        if (board.isDominantMangGae(row,col)) {
            board.levelUp();
            textView.setText("Level " + board.getLevel());
            if (board.getState() == Board.GameState.FINISHED) {
                Intent intent = new Intent(this, StartActivity.class);
                startActivity(intent);
                MangGaeActivity.this.finish();
            }
            board.allocateMangGae();
            gridLayout.setNumColumns(board.getSize());
            imageAdapter.setBoard(board);
            imageAdapter.notifyDataSetChanged();
        } else {
            board.reset();
            GameoverDialog dialog = new GameoverDialog(this);
            dialog.show();
        }
    }
}
