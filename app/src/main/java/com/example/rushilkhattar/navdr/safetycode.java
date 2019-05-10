package com.example.rushilkhattar.navdr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class safetycode extends AppCompatActivity {
    EditText editText;
    Button b1;
    DatabaseReference myRef;
    String s1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safetycode);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            s1 = extras.getString("kashish2");
        }
        b1 = (Button) findViewById(R.id.b1);
        editText = (EditText) findViewById(R.id.editText);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("NavDr");
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addscore();

            }
        });

    }

    private void addscore(){
        String pin=s1;
        String score = editText.getText().toString();
        int score2 = Integer.parseInt(score);
        if (!TextUtils.isEmpty(score)) {
            String Id=myRef.push().getKey();
            Score score1=new Score(pin,score2);
            myRef.child(Id).setValue(score1);
            Toast.makeText(getApplicationContext(),"Score Added.", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(getApplicationContext(),"Please insert safety score.", Toast.LENGTH_LONG).show();

        }
    }
}