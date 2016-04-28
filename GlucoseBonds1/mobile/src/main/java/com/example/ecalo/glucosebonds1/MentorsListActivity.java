

package com.example.ecalo.glucosebonds1;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.maps.android.heatmaps.HeatmapTileProvider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kangsik on 4/27/16.
 */
public class MentorsListActivity extends AppCompatActivity {
    private TextView mLatitudeText;
    private TextView mLongitudeText;
    private Double latitude;
    private Double longitude;


    //For map
    GoogleMap googleMap;
    private String currentLatString;
    private String currentLngString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("=============================");
        System.out.println("This is MentorsListActivity");
        System.out.println("=============================");
        super.onCreate(savedInstanceState);

        //For View
        setContentView(R.layout.mentors_list);
        mLatitudeText = (TextView)findViewById(R.id.latText);
        mLongitudeText = (TextView)findViewById(R.id.lngText);


        //Get Intent
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        currentLatString = extras.getString("LATITUDE");
        currentLngString= extras.getString("LONGITUDE");
        latitude = Double.parseDouble(currentLatString);
        longitude = Double.parseDouble(currentLngString);


        mLatitudeText.setText(currentLatString);
        mLongitudeText.setText(currentLngString);


        //Get map & user's current location
        googleMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        final LatLng currentLocation = new LatLng(latitude , longitude);
        Marker TP = googleMap.addMarker(new MarkerOptions().position(currentLocation).title("Current Location"));
        googleMap.getUiSettings().setZoomGesturesEnabled(true);
        CameraUpdate center = CameraUpdateFactory.newLatLng(currentLocation);
        CameraUpdate zoom = CameraUpdateFactory.zoomTo(13);
        googleMap.moveCamera(center);
        googleMap.animateCamera(zoom);


        //Mentors List Heatmap
        ArrayList<LatLng> mentorsPointsList = new ArrayList<LatLng>();

        /* Original
        Double[] mentorPoint1 = getLocationFromAddress("2232 Durant Ave , CA");
        final LatLng point1 = new LatLng(mentorPoint1[0] , mentorPoint1[1]);
        Double[] mentorPoint2 = getLocationFromAddress("6400 Christie Ave , CA");
        final LatLng point2 = new LatLng(mentorPoint2[0] , mentorPoint2[1]);
        Double[] mentorPoint3 = getLocationFromAddress("2234 Durant Ave , CA");
        final LatLng point3 = new LatLng(mentorPoint3[0] , mentorPoint3[1]);
        */


        final LatLng point1 = getLatLngFromAddress("2232 Durant Ave , CA");
        final LatLng point2 = getLatLngFromAddress("2234 Durant Ave , CA");
        final LatLng point3 = getLatLngFromAddress("2236 Durant Ave , CA");
        final LatLng point4 = getLatLngFromAddress("2238 Durant Ave , CA");
        final LatLng point5 = getLatLngFromAddress("2239 Durant Ave , CA");
        mentorsPointsList.add(point1);
        mentorsPointsList.add(point2);
        mentorsPointsList.add(point3);
        mentorsPointsList.add(point4);
        mentorsPointsList.add(point5);




        // Create a heat map tile provider, passing it the latlngs of the police stations.
        HeatmapTileProvider mProvider = new HeatmapTileProvider.Builder()
                .data(mentorsPointsList)
                .radius(50)
                .build();
        // Add a tile overlay to the map, using the heat map tile provider.
        googleMap.addTileOverlay(new TileOverlayOptions().tileProvider(mProvider));






        //Adding Additional Marker
        /*

        googleMap.addMarker(new MarkerOptions()
                .position(mentorPoint)
                .title("MentorPoint")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                .alpha(0.7f));
        */



    }
    /*
    public Double[] getLocationFromAddress(String strAddress){

        Geocoder coder = new Geocoder(this);
        List<Address> address;
        try {
            Double[] point = new Double[2];
            address = coder.getFromLocationName(strAddress,5);
            if (address==null) {
                return null;
            }
            Address location = address.get(0);
            point[0] = location.getLatitude();
            point[1] = location.getLongitude();
            return point;
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    */

    public LatLng getLatLngFromAddress(String strAddress){

        Geocoder coder = new Geocoder(this);
        List<Address> address;
        try {
            address = coder.getFromLocationName(strAddress,5);
            if (address==null) {
                return null;
            }
            Address location = address.get(0);
            LatLng pointLL = new LatLng(location.getLatitude() ,location.getLongitude());
            return pointLL;

        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
