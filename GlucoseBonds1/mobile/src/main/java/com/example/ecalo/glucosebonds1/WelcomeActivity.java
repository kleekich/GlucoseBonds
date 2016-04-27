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

//        class GestureHelper implements View.OnTouchListener {
//
//            private final GestureDetector mGestureDetector;
//            Context mContext;
//
//            public GestureHelper(Context ctx) {
//                mContext = ctx;
//                mGestureDetector = new GestureDetector(ctx, new GestureListener(this));
//            }
//
//            public void onSwipeRight() {
//                Intent educationActivity = new Intent(context, EducationActivity.class);
//                startActivity(educationActivity);
//            }
//
//            ;
//
//            public void onSwipeLeft() {
//
//            }
//
//            ;
//
//            public void onSwipeTop() {
//                Intent forumsActivity = new Intent(context, ForumsActivity.class);
//                startActivity(forumsActivity);
//            }
//
//            ;
//
//            public void onSwipeBottom() {
//                Intent mentorActivity = new Intent(context, MentorshipActivity.class);
//                startActivity(mentorActivity);
//            }
//
//            ;
//
//            public void onDoubleTap() {
//                Toast.makeText(mContext, "not once but twice!", Toast.LENGTH_SHORT).show();
//            }
//
//            ;
//
//            public void onClick() {
//                //Intent forumsActivity = new Intent(context, ForumsActivity.class);
//                //startActivity(forumsActivity);
//            }
//
//            ;
//
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                return mGestureDetector.onTouchEvent(event);
//            }
//
//            private final class GestureListener extends GestureDetector.SimpleOnGestureListener {
//
//                private static final int SWIPE_THRESHOLD = 100;
//                private static final int SWIPE_VELOCITY_THRESHOLD = 100;
//                private GestureHelper mHelper;
//
//                public GestureListener(GestureHelper helper) {
//                    mHelper = helper;
//                }
//
//                @Override
//                public boolean onDown(MotionEvent e) {
//                    return true;
//                }
//
//                @Override
//                public boolean onSingleTapUp(MotionEvent e) {
//                    mHelper.onClick();
//                    return true;
//                }
//
//                @Override
//                public boolean onDoubleTap(MotionEvent e) {
//                    mHelper.onDoubleTap();
//                    return true;
//                }
//
//                @Override
//                public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
//                    boolean result = false;
//                    try {
//                        float diffY = e2.getY() - e1.getY();
//                        float diffX = e2.getX() - e1.getX();
//                        if (Math.abs(diffX) > Math.abs(diffY)) {
//                            if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
//                                if (diffX > 0) {
//                                    mHelper.onSwipeRight();
//                                } else {
//                                    mHelper.onSwipeLeft();
//                                }
//                            }
//                        } else {
//                            if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
//                                if (diffY > 0) {
//                                    mHelper.onSwipeBottom();
//                                } else {
//                                    mHelper.onSwipeTop();
//                                }
//                            }
//                        }
//                    } catch (Exception ex) {
//                        ex.printStackTrace();
//                    }
//                    return result;
//                }
//            }
//
//        }

}
