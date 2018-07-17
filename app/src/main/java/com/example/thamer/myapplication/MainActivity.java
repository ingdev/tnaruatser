package com.example.thamer.myapplication;

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


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_20;
    private Button btn_21;
    private Button btn_22;
    private Button btn_23;
    private Button btn_24;
    private Button btn_25;
    private Button btn_26;
    private Button btn_27;
    private Button btn_28;
    private Button btn_30;
    private Button btn_31;
    private Button btn_32;
    private Button btn_33;
    private Button btn_34;
    private Button btn_35;
    private Button btn_36;
    private Button btn_40;
    private Button btn_41;
    private Button btn_42;
    private Button btn_43;
    private Button btn_44;
    private Button btn_50;
    private Button btn_56;
    private Button btn_55;
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private String occuper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("tables");
        btn_20 = (Button) findViewById(R.id.but20);
        myRef.child("20").child("occupe").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                occuper= dataSnapshot.getValue(String.class);
                if (occuper.equals("true"))
                    btn_20.setBackgroundColor(Color.RED);
                else
                    btn_20.setBackgroundColor(Color.GREEN);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        btn_20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (occuper.equals("true"))
                {
                    myRef.child("20").child("occupe").setValue("false");
                    btn_20.setBackgroundColor(Color.GREEN);
                }

                    else
                {
                    myRef.child("20").child("occupe").setValue("true");
                    btn_20.setBackgroundColor(Color.RED);

                }
            }
        });
    }



    @Override
    public void onClick(View v) {

    }

}
