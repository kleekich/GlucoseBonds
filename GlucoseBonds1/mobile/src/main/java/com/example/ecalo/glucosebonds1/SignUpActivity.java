package com.example.ecalo.glucosebonds1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

/**
 * Created by joel on 4/27/16.
 */
public class SignUpActivity extends AppCompatActivity {
    Context context;
    private Spinner age_list;
    private String[] ages;
    private Button sign;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.sign_up);
        age_list = (Spinner) findViewById(R.id.age_list);
        ages = getResources().getStringArray(R.array.child_age);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.child_age, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        age_list.setAdapter(adapter);
        sign = (Button) findViewById(R.id.sign);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goWelcome = new Intent(context, WelcomeActivity.class);
                startActivity(goWelcome);
            }
        });

    }
}
