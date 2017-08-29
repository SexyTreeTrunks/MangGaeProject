package com.sexytreetrunks.manggaegame.View;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.Button;

import com.sexytreetrunks.manggaegame.Control.MangGaeActivity;
import com.sexytreetrunks.manggaegame.R;

/**
 * Created by rentdotcom on 2017. 8. 28..
 */

public class GameoverDialog extends Dialog implements View.OnClickListener{
    Button button;
    Context context;
    MangGaeActivity activity;

    public GameoverDialog(Context context) {
        super(context);
        this.context = context;
        activity = (MangGaeActivity) context;
        setContentView(R.layout.activity_gameover_dialog);
        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        button = findViewById(R.id.btn_yes);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        activity.recreate();
        dismiss();
    }
}
