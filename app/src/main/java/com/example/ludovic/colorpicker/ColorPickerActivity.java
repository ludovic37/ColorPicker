package com.example.ludovic.colorpicker;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ColorPickerActivity extends Activity implements
        ColorPickerView.OnColorChangedListener{

    Activity activity;
    TextView txt;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.activity = this;

        View v = new ColorPickerView(activity, ColorPickerActivity.this, Color.WHITE);


        RelativeLayout layout = (RelativeLayout) findViewById(R.id.activity_main);
        txt = (TextView) findViewById(R.id.textColor);

        layout.addView(v);


    }

    @Override
    public void colorChanged(int color) {
        ColorPickerActivity.this.findViewById(android.R.id.content)
                .setBackgroundColor(color);
    }

    @Override
    public void getColorChanged(int color){

        String hexColor = String.format("#%06X", (0xFFFFFF & color));

        txt.setText("Color: "+hexColor);
    }



}
