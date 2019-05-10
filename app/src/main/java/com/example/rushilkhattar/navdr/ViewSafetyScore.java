package com.example.rushilkhattar.navdr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ViewSafetyScore extends AppCompatActivity{

    EditText editText;
    Button button;
    DatabaseReference myRef;
    String pin1;
    int scorenew;
    ArrayList<Integer> a;
    int i=1;
    int e;
    String s1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_safety_score);
        editText = (EditText) findViewById(R.id.editText2);
        button= (Button) findViewById(R.id.button1);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            s1 = extras.getString("kashish4");
        }
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("NavDr");
        a=new ArrayList<>();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myRef.addValueEventListener(new ValueEventListener() {
                    int sum=0;
                    int i=1;
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot scoreshot : dataSnapshot.getChildren()) {
                            Score score = scoreshot.getValue(Score.class);
                            pin1=String.valueOf(score.getPin());
                            if(s1.equals(pin1)) {
                                scorenew=Integer.valueOf(score.getScore());
                                a.add(scorenew);
                                Log.d("Ma", "onDataChange: "+a.get(0));
                                //Toast.makeText(getApplicationContext(),a.get(0)+"", Toast.LENGTH_LONG).show();
                                sum=sum+scorenew;
                                i++;
                            }

                        }
                        i--;

                        sum=sum/i;
                        Toast.makeText(getApplicationContext(),sum+"", Toast.LENGTH_LONG).show();
                        Intent intent6 = new Intent(ViewSafetyScore.this, FourthActivity.class);
                        intent6.putExtra("ashish",sum );
                        startActivity(intent6);

                        Toast.makeText(getApplicationContext(),sum+"", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }
        });

    }

}
