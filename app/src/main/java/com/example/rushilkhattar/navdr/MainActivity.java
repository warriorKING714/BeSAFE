package com.example.rushilkhattar.navdr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static final String TAG = "MainActivity";
    Button b1, b2, b3;
    RelativeLayout relativeLayout;
    int i;
    String text1 = "I am in danger. I need help. Plese follow my location:";

    String t1, t2;
    String pref1, pref2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle extras = getIntent().getExtras();
   /*     if (extras != null) {
            t1 = extras.getString("name10");
            t2 = extras.getString("name11");
        }*/

      /*  SharedPreferences settings = PreferenceManager
                .getDefaultSharedPreferences(MainActivity.this);
        pref1=settings.getString("name", "anon");
        pref2=settings.getString("subdivision", "anon");*/

        pref1 = Preferences.getPrefs("rushil1", getApplicationContext());
        pref2 = Preferences.getPrefs("rushil2", getApplicationContext());
        Log.d(TAG, "onCreate: "+ pref1 + "-->" + pref2);

        b1 = (Button) findViewById(R.id.button1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent6 = new Intent(MainActivity.this, MapsActivity.class);
                intent6.putExtra("name12", pref1);
                intent6.putExtra("name13", pref2);
                startActivity(intent6);

            }
        });


        i = 0;
        relativeLayout = (RelativeLayout) findViewById(R.id.bg);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i++;
                if (i == 4) {
                    i = 0;
                    Intent myintent = new Intent(MainActivity.this, MapsActivity.class);
                    myintent.putExtra("name", text1);
                    startActivity(myintent);


                }
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

         if (id == R.id.nav_thirdlayout) {

            Intent intent2 = new Intent(MainActivity.this, ThirdActivity.class);
            startActivity(intent2);

        } else if (id == R.id.nav_slideshow) {

            Intent newintent = new Intent(MainActivity.this, MapsActivity.class);
            newintent.putExtra("kashish", 1101);
            startActivity(newintent);

        } else if (id == R.id.nav_manage) {

             Intent newintent = new Intent(MainActivity.this, FifthActivity.class);
             startActivity(newintent);


        } else if (id == R.id.nav_share) {
            Intent newintent = new Intent(MainActivity.this, MapsActivity.class);
            newintent.putExtra("kashish3", 100100);
            startActivity(newintent);

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    int t = 0;

    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if ((keyCode == KeyEvent.KEYCODE_VOLUME_DOWN)) {
            t++;
            if (t == 2) {
                t = 0;
                Intent myintent = new Intent(MainActivity.this, MapsActivity.class);
                myintent.putExtra("name", text1);
                startActivity(myintent);
            }

        }
        return super.onKeyDown(keyCode, event);
    }
}
