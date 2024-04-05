package com.example.android77;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

public class Resign extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.resign);


        DisplayMetrics dm = new DisplayMetrics();

        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * .9), (int) (height * .23));

        TextView textView = findViewById(R.id.gameOver);

        Bundle retrievedData = getIntent().getExtras();
        if (retrievedData != null) {
            String value = retrievedData.getString("key");
            //The key argument here must match that used in the other activity
            textView.setText(value);
        }

//        textView.setText(value);
    }
}
