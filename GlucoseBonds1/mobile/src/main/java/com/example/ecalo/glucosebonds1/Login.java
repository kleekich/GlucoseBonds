package com.example.ecalo.glucosebonds1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by joel on 4/27/16.
 */
public class Login extends AppCompatActivity {
    Context context;
    private Button loginBtn;
    private TextView createNew;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.login_screen);
        loginBtn = (Button) findViewById(R.id.login);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent welcomeActivity = new Intent(context, WelcomeActivity.class);
                startActivity(welcomeActivity);              }
        });
        createNew = (TextView) findViewById(R.id.create_new);
        createNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signActivity = new Intent(context, SignUpActivity.class);
                startActivity(signActivity);
            }
        });
    }
}
