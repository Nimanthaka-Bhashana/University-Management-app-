package com.example.mainactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GuestDashboardActivity extends AppCompatActivity {
  CardView clothingCard,aboutUsCard,LecturerView,locationMap;


  Button SignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_dashboard);

        clothingCard=findViewById(R.id.clothingCard);
        aboutUsCard=findViewById(R.id.aboutUsCard);
        LecturerView=findViewById(R.id.LecturerView);
        locationMap=findViewById(R.id.locationMap);


        //Button
        SignUp=findViewById(R.id.SignUp);

        clothingCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(GuestDashboardActivity.this,DisplayCourses.class);
                startActivity(intent);

            }
        });

        aboutUsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(GuestDashboardActivity.this,AboutUsActivity.class);
                startActivity(intent);
            }
        });

        LecturerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        locationMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(GuestDashboardActivity.this,GoogleMap.class);
                startActivity(intent);
            }
        });
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(GuestDashboardActivity.this,Register.class);
                startActivity(intent);
            }
        });
    }
}