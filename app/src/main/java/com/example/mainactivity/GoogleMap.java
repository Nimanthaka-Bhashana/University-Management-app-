package com.example.mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class GoogleMap extends AppCompatActivity {

    private EditText editTextCurrentLocation;
    private EditText editTextDestination;
    private Button buttonShowMap,backButton;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_map);

        editTextCurrentLocation = findViewById(R.id.editTextCurrentLocation);
        editTextDestination = findViewById(R.id.editTextDestination);
        buttonShowMap = findViewById(R.id.buttonShowMap);
        webView = findViewById(R.id.webView);
        backButton=findViewById(R.id.backButton);


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(GoogleMap.this,GuestDashboardActivity.class);
            }
        });
        // Enable JavaScript
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Set WebView client to handle page navigation
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);
                // Handle error here
            }
        });

        buttonShowMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentLocation = editTextCurrentLocation.getText().toString();
                String destination = editTextDestination.getText().toString();

                // Load Google Maps website with user's input
                webView.loadUrl("https://www.google.com/maps/dir/" + currentLocation + "/" + destination);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
