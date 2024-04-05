package com.example.android77;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;

import androidx.core.content.res.ResourcesCompat;

//import androidx.annotation.Nullable;

public class Pop extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.popwindow);

        DisplayMetrics dm = new DisplayMetrics();

        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * .8), (int) (height * .6));

        ImageView imageView1;
        ImageView imageView2;
        ImageView imageView3;
        ImageView imageView4;

        Drawable drawable1;
        Drawable drawable2;
        Drawable drawable3;
        Drawable drawable4;

//        imageView1 = findViewById(R.id.blackBishop);
//        drawable = ResourcesCompat.getDrawable(getResources(),R.drawable.blackbishop,null);
//        drawable.setBounds(20,0,70,80);
//        imageView1.set.setCompoundDrawables( drawable, null, null,  null );


        imageView1 = (ImageView) findViewById(R.id.blackBishop);
        imageView1.setImageResource(R.drawable.blackbishop);

        imageView2 = (ImageView) findViewById(R.id.blackKnight);
        imageView2.setImageResource(R.drawable.blackknight);

        imageView3 = (ImageView) findViewById(R.id.blackRook);
        imageView3.setImageResource(R.drawable.blackrook);

        imageView4 = (ImageView) findViewById(R.id.blackQueen);
        imageView4.setImageResource(R.drawable.blackqueen);

    }
}