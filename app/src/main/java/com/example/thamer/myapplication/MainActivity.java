package com.example.thamer.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity{
    private TButton [] tables;
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private int status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //TODO: check for internet popup
        init();
        getStatus();
        setAction();
        //TODO: improve the layout

    }

    private void setAction() {
        for ( int j=1; j<tables.length; j++) {
            final int finalJ = j;
            tables[j].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplication(), String.valueOf(finalJ)+" : "+String.valueOf(tables[finalJ].getStatus()), Toast.LENGTH_LONG).show();
                    if (tables[finalJ].getStatus() == 0) {
                        myRef.child(String.valueOf(finalJ)).child("occupe").setValue(1);
                    } else {
                        myRef.child(String.valueOf(finalJ)).child("occupe").setValue(0);
                    }
                }
            });
        }
    }

    private void getStatus() {
        for ( int j=1; j<tables.length; j++) {
            final int finalJ = j;
            myRef.child(String.valueOf(j)).child("occupe").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()) {
                        status = dataSnapshot.getValue(Integer.class);
                        tables[finalJ].setStatus(status);
                        }
                        setColor(tables[finalJ]);
                    }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }

    private void setColor(TButton btn) {
        if (btn.getStatus()==1) {
            btn.setBackgroundColor(Color.RED);
        } else {
            btn.setBackgroundColor(Color.GREEN);
        }
    }


    public void init(){
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("tables");
        tables=new TButton[57];

        for (int i=0; i<tables.length;i++) {
            tables[i]=new TButton(this);
        }
        tables[1] = (TButton) findViewById(R.id.btn1);
        tables[2] = (TButton) findViewById(R.id.btn2);
        tables[3] = (TButton) findViewById(R.id.btn3);
        tables[4] = (TButton) findViewById(R.id.btn4);
        tables[5] = (TButton) findViewById(R.id.btn5);
        tables[6] = (TButton) findViewById(R.id.btn6);
        tables[7] = (TButton) findViewById(R.id.btn7);
        tables[8] = (TButton) findViewById(R.id.btn8);
        tables[9] = (TButton) findViewById(R.id.btn9);
        tables[10] = (TButton) findViewById(R.id.btn10);

        tables[20] = (TButton) findViewById(R.id.btn20);
        tables[21] = (TButton) findViewById(R.id.btn21);
        tables[22] = (TButton) findViewById(R.id.btn22);
        tables[23] = (TButton) findViewById(R.id.btn23);
        tables[24] = (TButton) findViewById(R.id.btn24);
        tables[25] = (TButton) findViewById(R.id.btn25);
        tables[26] = (TButton) findViewById(R.id.btn26);
        tables[27] = (TButton) findViewById(R.id.btn27);
        tables[28] = (TButton) findViewById(R.id.btn28);
        tables[30] = (TButton) findViewById(R.id.btn30);
        tables[31] = (TButton) findViewById(R.id.btn31);
        tables[32] = (TButton) findViewById(R.id.btn32);
        tables[33] = (TButton) findViewById(R.id.btn33);
        tables[34] = (TButton) findViewById(R.id.btn34);
        tables[35] = (TButton) findViewById(R.id.btn35);
        tables[36] = (TButton) findViewById(R.id.btn36);

        tables[40] = (TButton) findViewById(R.id.btn40);
        tables[41] = (TButton) findViewById(R.id.btn41);
        tables[42] = (TButton) findViewById(R.id.btn42);
        tables[43] = (TButton) findViewById(R.id.btn43);
        tables[44] = (TButton) findViewById(R.id.btn44);

        tables[50] = (TButton) findViewById(R.id.btn50);
        tables[51] = (TButton) findViewById(R.id.btn51);
        tables[52] = (TButton) findViewById(R.id.btn52);
        tables[53] = (TButton) findViewById(R.id.btn53);
        tables[54] = (TButton) findViewById(R.id.btn54);
        tables[55] = (TButton) findViewById(R.id.btn55);
        tables[56] = (TButton) findViewById(R.id.btn56);
    }

}
