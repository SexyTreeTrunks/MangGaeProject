package com.sexytreetrunks.manggaegame.View;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.sexytreetrunks.manggaegame.Model.Board;
import com.sexytreetrunks.manggaegame.R;

/**
 * Created by sexytreetrunks on 2017. 8. 28..
 */

public class ImageAdapter extends BaseAdapter {
    Context context;
    Board board;
    int size;

    public ImageAdapter(Context context, Board board) {
        this.context = context;
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
            imageView.setLayoutParams(new GridView.LayoutParams(120, 120));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(1,1,1,1);
        } else {
            imageView = (ImageView) view;
        }
        int row = i / board.getSize();
        int col = i % board.getSize();
        switch (board.getValueFromMatrix(row,col)) {
            case 1:
                imageView.setImageResource(R.drawable.manggae1);
                break;
            case 2:
                imageView.setImageResource(R.drawable.manggae2);
                break;
            case 3:
                imageView.setImageResource(R.drawable.manggae3);
                break;
            case 4:
                imageView.setImageResource(R.drawable.manggae4);
        }
        return imageView;
    }
}
