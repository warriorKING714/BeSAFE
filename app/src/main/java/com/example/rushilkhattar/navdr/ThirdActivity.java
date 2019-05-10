package com.example.rushilkhattar.navdr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {

    EditText editText;
    EditText editText2;

    String res;
    String res2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        editText = (EditText)findViewById(R.id.editText);
        editText2 = (EditText)findViewById(R.id.editText2);
       /* SharedPreferences preferences = getSharedPreferences("MyPrefs",MODE_PRIVATE);
        editText.setText(preferences.getString("username",""));
        editText.setText(preferences.getString("username2",""));*/


    }



    public void saveusername(View view)
    {
        /*SharedPreferences settings = PreferenceManager
                .getDefaultSharedPreferences(ThirdActivity.this);

        SharedPreferences.Editor edit = settings.edit();

        edit.putString("name", res);
        edit.putString("subdivision", res2);
        edit.commit();*/

        res = editText.getText().toString();
        res2 = editText2.getText().toString();

        Preferences.setPrefs("rushil1",res,getApplicationContext());
        Preferences.setPrefs("rushil2",res2,getApplicationContext());

        editText.setText(" ");
        editText2.setText(" ");
        Toast.makeText(this, "Details Saved", Toast.LENGTH_SHORT).show();
        /*SharedPreferences preferences = getSharedPreferences("MyPrefs",MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.commit();*/
    }




    public void onBackPressed() {

        super.onBackPressed();
        Intent intent1 = new Intent(getApplicationContext(),MainActivity.class);
       // intent1.putExtra("name10",res);
      // intent1.putExtra("name 11",res2)

        startActivity(intent1);
        finish();
    }
}
