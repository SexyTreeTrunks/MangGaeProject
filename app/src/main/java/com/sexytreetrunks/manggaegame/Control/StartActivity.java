package com.sexytreetrunks.manggaegame.Control;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.sexytreetrunks.manggaegame.R;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    public void onStartClicked(View v) {
        Intent intent = new Intent(this, MangGaeActivity.class);
        startActivity(intent);
    }
}
