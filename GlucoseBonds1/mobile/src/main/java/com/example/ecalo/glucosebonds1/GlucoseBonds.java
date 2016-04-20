package com.example.ecalo.glucosebonds1;

import android.app.Application;

import com.baasbox.android.BaasBox;

/**
 * Created by Allen on 4/18/2016.
 */
public class GlucoseBonds extends Application {

    private BaasBox client;

    @Override
    public void onCreate() {
        super.onCreate();
        BaasBox.Builder b = new BaasBox.Builder(this);
        // have to use 10.0.3.2 for genymotion
        client = b.setApiDomain("10.0.3.2")
                .setPort(9000)
                .setAppCode("1234567890")
                .init();
    }
}
