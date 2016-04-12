package com.example.ecalo.glucosebonds1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logo = (ImageButton) findViewById(R.id.logo_pic);
        logo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent next = new Intent();
                startActivity(next);
            }
        });
    }

}
