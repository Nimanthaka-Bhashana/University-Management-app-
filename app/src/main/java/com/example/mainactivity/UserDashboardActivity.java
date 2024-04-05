package com.example.mainactivity;



import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserDashboardActivity extends AppCompatActivity {

    Button editprofilebtn;
    CardView courseCard, locationMap,aboutUsCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);

        // Finding views
        editprofilebtn = findViewById(R.id.editprofilebtn);
        courseCard = findViewById(R.id.courseCard);
        aboutUsCard=findViewById(R.id.aboutUsCard);
        locationMap = findViewById(R.id.locationMap);

        // Setting onClickListener for EditButton
        editprofilebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserDashboardActivity.this, ProfileDashboard.class);
                startActivity(intent);
            }
        });

        // Setting onClickListener for courseCard
        courseCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserDashboardActivity.this, DisplayCourses.class);
                startActivity(intent);
            }
        });

        // Setting onClickListener for locationMap
        locationMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserDashboardActivity.this, GoogleMap.class);
                startActivity(intent);
            }
        });

        aboutUsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(UserDashboardActivity.this,AboutUsActivity.class);
                startActivity(intent);
            }
        });
    }

    // Method to display courses
    public void displayCourse() {
        Intent intent = new Intent(UserDashboardActivity.this, DisplayCourses.class);
        startActivity(intent);
    }


}