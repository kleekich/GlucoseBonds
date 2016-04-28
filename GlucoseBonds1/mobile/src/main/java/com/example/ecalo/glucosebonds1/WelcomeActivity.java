package com.example.ecalo.glucosebonds1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {

    //    ImageButton button;
    Context context;
    private LinearLayout forums, education, mentorship;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.welcome_screen);
        forums = (LinearLayout) findViewById(R.id.forums);
        education = (LinearLayout) findViewById(R.id.education);
        mentorship = (LinearLayout) findViewById(R.id.mentorship);
        forums.setOnClickListener(this);
        education.setOnClickListener(this);
        mentorship.setOnClickListener(this);

//        button = (ImageButton) findViewById(R.id.img_btn);
//        button.setImageResource(R.drawable.gb_main);
//
//        button.setOnTouchListener(new GestureHelper(context));
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.forums:
                Intent forumsActivity = new Intent(context, ForumsActivity.class);
                startActivity(forumsActivity);
                break;
            case R.id.education:
                Intent educationActivity = new Intent(context, EducationActivity.class);
                startActivity(educationActivity);
                break;
            case R.id.mentorship:
                Intent mentorActivity = new Intent(context, MentorshipActivity.class);
                startActivity(mentorActivity);
                break;
        }
    }

}
