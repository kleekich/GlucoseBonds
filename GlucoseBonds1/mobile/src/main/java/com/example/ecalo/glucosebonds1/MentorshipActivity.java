package com.example.ecalo.glucosebonds1;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MentorshipActivity extends AppCompatActivity implements View.OnClickListener {

    Context context;
    private ImageButton findMentor, beMentor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.mentorship_homepage);
        findMentor = (ImageButton) findViewById(R.id.imageButton);
        beMentor = (ImageButton) findViewById(R.id.imageButton2);
        findMentor.setOnClickListener(this);
        beMentor.setOnClickListener(this);
//        button = (ImageButton) findViewById(R.id.img_btn);
//        button.setImageResource(R.drawable.mentorship_screen);
//
//        button.setOnTouchListener(new GestureHelper(context));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageButton:
                Intent findMentorActivity = new Intent(context, FindMentorActivity.class);
                startActivity(findMentorActivity);
                break;
            case R.id.imageButton2:
                Intent beMentorActivity = new Intent(context, BeMentorActivity.class);
                startActivity(beMentorActivity);
                break;

        }
    }

    public class GestureHelper implements View.OnTouchListener {

        private final GestureDetector mGestureDetector;
        Context mContext;

        public GestureHelper(Context ctx) {
            mContext = ctx;
            mGestureDetector = new GestureDetector(ctx, new GestureListener(this));
        }

        public void onSwipeRight() {
            Toast.makeText(mContext, "right is always right!", Toast.LENGTH_SHORT).show();
            Intent beMentor = new Intent(context, BeMentorActivity.class);
            startActivity(beMentor);
        };

        public void onSwipeLeft() {
            Toast.makeText(mContext, "left is best!", Toast.LENGTH_SHORT).show();
        };

        public void onSwipeTop() {
            Toast.makeText(mContext, "up up and away!", Toast.LENGTH_SHORT).show();
            Intent findMentor = new Intent(context, FindMentorActivity.class);
            startActivity(findMentor);
        };

        public void onSwipeBottom() {
            Toast.makeText(mContext, "what's down there?", Toast.LENGTH_SHORT).show();
        };

        public void onDoubleTap() {
            Toast.makeText(mContext, "not once but twice!", Toast.LENGTH_SHORT).show();
        };

        public void onClick() {
            Intent messageActivity = new Intent(context, MessageActivity.class);
            startActivity(messageActivity);
        };

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            return mGestureDetector.onTouchEvent(event);
        }

        private final class GestureListener extends GestureDetector.SimpleOnGestureListener {

            private static final int SWIPE_THRESHOLD = 100;
            private static final int SWIPE_VELOCITY_THRESHOLD = 100;
            private GestureHelper mHelper;

            public GestureListener(GestureHelper helper) {
                mHelper = helper;
            }

            @Override
            public boolean onDown(MotionEvent e) {
                return true;
            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                mHelper.onClick();
                return true;
            }

            @Override
            public boolean onDoubleTap(MotionEvent e) {
                mHelper.onDoubleTap();
                return true;
            }



            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                boolean result = false;
                try {
                    float diffY = e2.getY() - e1.getY();
                    float diffX = e2.getX() - e1.getX();
                    if (Math.abs(diffX) > Math.abs(diffY)) {
                        if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                            if (diffX > 0) {
                                mHelper.onSwipeRight();
                            } else {
                                mHelper.onSwipeLeft();
                            }
                        }
                    } else {
                        if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                            if (diffY > 0) {
                                mHelper.onSwipeBottom();
                            } else {
                                mHelper.onSwipeTop();
                            }
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                return result;
            }
        }

    }

}
