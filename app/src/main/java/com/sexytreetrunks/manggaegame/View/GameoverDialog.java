package com.sexytreetrunks.manggaegame.View;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.Button;

import com.sexytreetrunks.manggaegame.Control.MangGaeActivity;
import com.sexytreetrunks.manggaegame.R;

/**
 * Created by SexyTreetrunks on 2017. 8. 28..
 */

public class GameoverDialog extends Dialog implements View.OnClickListener{
    Button button_yes;
    Button button_no;
    MangGaeActivity activity;

    public GameoverDialog(Context context) {
        super(context);
        activity = (MangGaeActivity) context;
        setContentView(R.layout.activity_gameover_dialog);
        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        button_yes = findViewById(R.id.btn_yes);
        button_no = findViewById(R.id.btn_no);
        button_yes.setOnClickListener(this);
        button_no.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_yes:
                activity.recreate();
                dismiss();
                break;
            case R.id.btn_no:
                activity.finish();
        }
    }
}
