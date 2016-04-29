package com.example.ecalo.glucosebonds1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Random;

public class MessageActivity extends AppCompatActivity {

    ImageButton button;
    Context context;

    private DiscussArrayAdapter adapter;
    private ListView lv;
    private EditText editText1;
    private static Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discuss);
        context = this;
        //Get Intent
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String mentorName = extras.getString("MENTOR_NAME");

        TextView textViewMentorName = (TextView) findViewById(R.id.textViewMentorName);
        textViewMentorName.setText(mentorName);


        lv = (ListView) findViewById(R.id.listView1);
        adapter = new DiscussArrayAdapter(getApplicationContext(), R.layout.listitem_discuss);
        lv.setAdapter(adapter);

        editText1 = (EditText) findViewById(R.id.editText1);
        editText1.setOnKeyListener(new OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    // Perform action on key press
                    adapter.add(new OneComment(false, editText1.getText().toString()));
                    editText1.setText("");
                    return true;
                }
                return false;
            }
        });

        addItems();
    }

    private void addItems() {
        adapter.add(new OneComment(true, "Hello bubbles!"));

        for (int i = 0; i < 4; i++) {
            boolean left = i % 2 == 0;

            String words = "TEST"+ Integer.toString(i);

            adapter.add(new OneComment(left, words));
        }
    }





}
