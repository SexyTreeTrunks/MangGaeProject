package com.sexytreetrunks.manggaegame.View;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.sexytreetrunks.manggaegame.Model.Board;
import com.sexytreetrunks.manggaegame.R;

import java.util.Random;

/**
 * Created by sexytreetrunks on 2017. 8. 28..
 */

public class ImageAdapter extends BaseAdapter {
    Context context;
    Board board;
    int size;
    int[] img = {R.drawable.manggae1, R.drawable.manggae2, R.drawable.manggae3, R.drawable.manggae4, R.drawable.manggae5,
            R.drawable.manggae7, R.drawable.manggae8, R.drawable.manggae9, R.drawable.manggae10, R.drawable.manggae11,
            R.drawable.manggae12, R.drawable.manggae13, R.drawable.manggae14, R.drawable.manggae15, R.drawable.manggae16,
            R.drawable.manggae17, R.drawable.manggae18, R.drawable.manggae19, R.drawable.manggae20, R.drawable.manggae21,
            R.drawable.manggae22, R.drawable.manggae23, R.drawable.manggae24, R.drawable.manggae25, R.drawable.manggae26};

    public ImageAdapter(Context context, Board board, int width) {
        this.context = context;
        this.board = board;
        size = width;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    @Override
    public int getCount() {
        return board.getSize() * board.getSize();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView;
        if (view == null) {
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(size/board.getSize(), size/board.getSize()));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(1,1,1,1);
        } else {
            imageView = (ImageView) view;
        }
        int row = i / board.getSize();
        int col = i % board.getSize();

        imageView.setImageResource(img[board.getValueFromMatrix(row,col)]);

        return imageView;
    }
}
