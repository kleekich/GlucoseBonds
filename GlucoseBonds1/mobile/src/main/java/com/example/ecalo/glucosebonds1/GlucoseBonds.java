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
        //String apiDomain = "192.168.1.183";
        String apiDomain = "10.0.3.2";
        //String apiDomain = "10.0.2.2";
        //String apiDomain = "192.168.57.1";
        //String apiDomain = "192.168.56.2";
        //String apiDomain = "10.142.16.43";
        //String apiDomain = "192.168.138.1";
        //String apiDomain = "10.142.16.1";
        //String apiDomain = "50.141.29.2";
        client = b.setApiDomain(apiDomain)
                .setPort(9000)
                .setAppCode("1234567890")
                .setHttpConnectionTimeout(3000)
                .init();
    }

}
