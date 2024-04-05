package com.example.android77;


import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;

import java.util.ArrayList;

public class GameOver extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.gameover);



        DisplayMetrics dm = new DisplayMetrics();

        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * .9), (int) (height * .23));

        TextView textView = findViewById(R.id.gameOver);
        textView.setText("Draw!\nGameOver!");


//        Bundle drawSave = getIntent().getExtras();
//        if (drawSave != null) {
//
//            ArrayList<String> value = drawSave.getStringArrayList("fileSystemArray");
//            System.out.println("THIS IS THE VALUE FROM PASSING" + value);
//            //The key argument here must match that used in the other activity
//
//            String sessionId = String.valueOf(getIntent().getStringArrayListExtra("fileSystemArray"));
////            String sessionId = getIntent().getStringExtra("fileSystemArray");
//            System.out.println("THIS IS THE VALUE FROM PASSING" + sessionId);
//        }

    }

}
