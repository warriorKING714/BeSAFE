package com.example.rushilkhattar.navdr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;


public class SecondActivity extends AppCompatActivity {

   // int []a = {110098,110034,110048,110024,110011};
    //  int b=110024;
    int c1=0;

    GPSTracker gps = new GPSTracker(this);
    double latitude = gps.getLatitude();
    double longitude = gps.getLongitude();

    String lat = Double.toString(latitude);
    String lon = Double.toString(longitude);




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        int t2=0;
        Bundle b = getIntent().getExtras();
        if(b!=null) {
             t2 = b.getInt("name2");
        }

/*
        for(int i=0;i<5;i++)
        {
            if(a[i]==b)
            {
                c=1;
            }

        }*/
        if(t2==1000)
        {
        setContentView(R.layout.activity_second);
    }
    else
        {
            setContentView(R.layout.another_activity);
        }

        Toast.makeText(SecondActivity.this,lat , Toast.LENGTH_LONG).show();
        Toast.makeText(SecondActivity.this,lon, Toast.LENGTH_LONG).show();
}}
