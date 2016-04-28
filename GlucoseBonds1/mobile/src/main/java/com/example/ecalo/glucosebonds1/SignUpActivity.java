package com.example.ecalo.glucosebonds1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.baasbox.android.BaasBox;
import com.baasbox.android.BaasHandler;
import com.baasbox.android.BaasResult;
import com.baasbox.android.BaasUser;
import com.baasbox.android.BaasUser.Scope;



/**
 * Created by joel on 4/27/16.
 */
public class SignUpActivity extends AppCompatActivity {
    Context context;
    private Spinner age_list;
    private String[] ages;
    private Button sign;

    private EditText editTextUsername;
    private EditText editTextPassword;
    private EditText editTextFirstName;
    private EditText editTextLastName;
    private EditText editTextChildName;
    private EditText editTextAddress;
    private Button buttonSignUp;

    private BaasBox client;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BaasBox.Builder builder = new BaasBox.Builder(this);
        client =builder.setApiDomain("10.0.3.2")
                .setPort(9000)
                .setAppCode("1234567890")
                .setHttpConnectionTimeout(30000)
                .init();



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



        //For user input views

        editTextUsername = (EditText) findViewById(R.id.editTextUsername);
        editTextPassword = (EditText) findViewById(R.id.editTextPasswords);
        editTextFirstName = (EditText) findViewById(R.id.editTextFirstName);
        editTextLastName = (EditText) findViewById(R.id.editTextLastName);
        editTextChildName = (EditText) findViewById(R.id.editTextChildName);
        editTextAddress = (EditText) findViewById(R.id.editTextAddress);
        buttonSignUp = (Button) findViewById(R.id.buttonSignUp);

        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaasUser user = BaasUser.withUserName(editTextUsername.getText().toString());
                user.setPassword(editTextPassword.getText().toString());
                user.getScope(Scope.REGISTERED).put("Address", editTextAddress.getText().toString());
                //JsonObject extras = user.getScope(Scope.PRIVATE).putInt("age_info", 27);
                user.signup(new BaasHandler<BaasUser>(){
                    @Override
                    public void handle(BaasResult<BaasUser> result){
                        if(result.isSuccess()) {
                            Log.d("LOG", "Current user is: " + result.value());
                        } else {
                            Log.e("LOG","Show error",result.error());
                        }
                    }
                });





                Intent welcomeActivity = new Intent(context, WelcomeActivity.class);
                startActivity(welcomeActivity);              }
        });


        //getting user's input








    }
}
