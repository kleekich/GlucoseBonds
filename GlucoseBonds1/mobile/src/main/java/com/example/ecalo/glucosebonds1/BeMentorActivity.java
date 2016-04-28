package com.example.ecalo.glucosebonds1;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;

/**
 * Created by joel on 4/19/16.
 */
public class BeMentorActivity extends AppCompatActivity {

    ImageButton button;
    Context context;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.be_a_mentor);
//        button = (ImageButton) findViewById(R.id.img_btn);
//        button.setImageResource(R.drawable.be_mentor);

    }
}