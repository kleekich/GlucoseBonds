package com.example.ecalo.glucosebonds1;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageButton;

import com.baasbox.android.BaasBox;
import com.baasbox.android.BaasDocument;
import com.baasbox.android.BaasHandler;
import com.baasbox.android.BaasResult;

/**
 * Created by joel on 4/19/16.
 */
public class BeMentorActivity extends AppCompatActivity {
    private BaasBox client;
    ImageButton button;
    Context context;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.be_a_mentor);
//        button = (ImageButton) findViewById(R.id.img_btn);
//        button.setImageResource(R.drawable.be_mentor);


        BaasBox.Builder builder = new BaasBox.Builder(this);
        client =builder.setApiDomain("10.0.3.2")
                .setPort(9000)
                .setAppCode("1234567890")
                .setHttpConnectionTimeout(30000)
                .init();

        BaasDocument doc = new BaasDocument("mentorAddresses");
        doc.putString("title","2232 Durant Ave")
                .putString("body","2232 Durant Ave");
        doc.save(new BaasHandler<BaasDocument>() {
            @Override
            public void handle(BaasResult<BaasDocument> res) {
                if(res.isSuccess()) {
                    Log.d("LOG", "Saved: " + res.value());
                } else {

                }
            }
        });

    }
}