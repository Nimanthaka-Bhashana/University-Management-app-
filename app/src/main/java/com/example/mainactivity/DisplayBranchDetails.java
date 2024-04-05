package com.example.mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayBranchDetails extends AppCompatActivity {
    TextView textViewBranchCode, textViewBranchName;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_branch_details);

        textViewBranchCode = findViewById(R.id.textViewBranchCode);
        textViewBranchName = findViewById(R.id.textViewBranchName);
        dbHelper = new DBHelper(this);

        displayBranchDetails();
    }

    private void displayBranchDetails() {
        // Retrieve branch details from the database
        Cursor cursor = dbHelper.getAllBranches();

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                // Check if the column exists in the cursor
                int branchCodeIndex = cursor.getColumnIndex(DBHelper.COL_BRANCH_CODE);
                int branchNameIndex = cursor.getColumnIndex(DBHelper.COL_BRANCH_NAME);

                if (branchCodeIndex != -1 && branchNameIndex != -1) {
                    String branchCode = cursor.getString(branchCodeIndex);
                    String branchName = cursor.getString(branchNameIndex);

                    // Display branch details
                    textViewBranchCode.setText("Branch Code: " + branchCode);
                    textViewBranchName.setText("Branch Name: " + branchName);
                } else {
                    // Columns not found in the cursor
                    Toast.makeText(this, "Branch details not found.", Toast.LENGTH_SHORT).show();
                }
            } else {
                // No data found in the cursor
                Toast.makeText(this, "No branch details found.", Toast.LENGTH_SHORT).show();
            }
            cursor.close();
        } else {
            // Cursor is null
            Toast.makeText(this, "Failed to retrieve branch details.", Toast.LENGTH_SHORT).show();
        }
    }
}
