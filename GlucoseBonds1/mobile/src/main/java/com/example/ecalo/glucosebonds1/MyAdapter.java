package com.example.ecalo.glucosebonds1;

/**
 * Created by Kangsik on 3/2/16.
 */

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.google.android.gms.common.api.GoogleApiClient;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import retrofit.http.GET;
//import retrofit.http.Query;


public class MyAdapter extends ArrayAdapter<String> {


    private Activity context;
    private final List<String> mentorsNames;



    public MyAdapter(Activity context, ArrayList<String> mentorsNames) {
        super(context,R.layout.row_mentors_layout, mentorsNames);
        //super(context, R.layout.congressional_list_view_cell, legislators);
        this.context= context;
        this.mentorsNames=mentorsNames;


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater theInflater = LayoutInflater.from(getContext());
        View theView = theInflater.inflate(R.layout.row_mentors_layout, parent, false);
        //View rowView=inflater.inflate(R.layout.congressional_list_view_cell, null, true);

        final String mentorName = getItem(position);

        //ImageView in row



        //textView in row
        TextView nameTextView = (TextView) theView.findViewById(R.id.);
        TextView partyTextView = (TextView) theView.findViewById(R.id.partyTextView);
        TextView emailTextView = (TextView) theView.findViewById(R.id.emailTextView);
        TextView websiteTextView = (TextView) theView.findViewById(R.id.websiteTextView);
        ImageView imageViewParty = (ImageView) theView.findViewById(R.id.imageViewParty);


        String name = rep.title +". "+ rep.firstName + " "+ rep.lastName;
        String party = rep.party;
        String email = rep.email;
        String website = rep.website;


        nameTextView.setText(name);
        partyTextView.setText(party);
        emailTextView.setText(email);
        websiteTextView.setText(website);






        return theView;

    }



}
