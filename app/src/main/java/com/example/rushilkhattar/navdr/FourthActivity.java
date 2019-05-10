package com.example.rushilkhattar.navdr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FourthActivity extends AppCompatActivity {

    int t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            t1 = extras.getInt("ashish");
        }

        if(t1<=5)
        {
            setContentView(R.layout.activity_second);
        }
        else
        {
            setContentView(R.layout.another_activity);
        }
    }
}
