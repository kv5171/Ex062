package com.example.ex062;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Switch;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    LinearLayout activity;
    Switch swBtn;
    RadioGroup rg;
    ArrayList<Integer> idList, colorsList;
    int currRb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activity = (LinearLayout) findViewById(R.id.activity);
        swBtn = (Switch) findViewById(R.id.swBtn);
        rg = (RadioGroup) findViewById(R.id.rg);

        // create a color's array
        colorsList = new ArrayList<Integer>(4);
        colorsList.add(Color.parseColor("#FF33E6"));
        colorsList.add(Color.parseColor("#BB33FF"));
        colorsList.add(Color.parseColor("#3399FF"));
        colorsList.add(Color.parseColor("#FF4233"));

        // create a id's array
        idList = new ArrayList<Integer>(4);
        idList.add(R.id.rbPink);
        idList.add(R.id.rbPurple);
        idList.add(R.id.rbBlue);
        idList.add(R.id.rbRed);
    }

    public void changeBackground(View view) {
        if (!swBtn.isChecked()) {
            currRb = rg.getCheckedRadioButtonId();
            activity.setBackgroundColor(colorsList.get(idList.indexOf(currRb)));
        }
    }

    public void changeClicked(View view) {
        currRb = rg.getCheckedRadioButtonId();
        if ((currRb != -1) && swBtn.isChecked()) // if any rb was clicked and switch btn was clicked
            activity.setBackgroundColor(colorsList.get(idList.indexOf(currRb)));
    }
}