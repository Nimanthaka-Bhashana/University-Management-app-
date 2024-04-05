package com.example.mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddBranchActivity extends AppCompatActivity {

    private EditText editTextBranchCode;
    private EditText editTextBranchName;
    private Button buttonAddBranch;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_branch);

        editTextBranchCode = findViewById(R.id.editTextBranchCode);
        editTextBranchName = findViewById(R.id.editTextBranchName);
        buttonAddBranch = findViewById(R.id.buttonAddBranch);
        dbHelper = new DBHelper(this);

        buttonAddBranch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String branchCode = editTextBranchCode.getText().toString().trim();
                String branchName = editTextBranchName.getText().toString().trim();

                if (branchCode.isEmpty() || branchName.isEmpty()) {
                    Toast.makeText(AddBranchActivity.this, "Please enter branch details", Toast.LENGTH_SHORT).show();
                } else {
                    boolean isInserted = dbHelper.addBranch(branchCode, branchName);
                    if (isInserted) {
                        Toast.makeText(AddBranchActivity.this, "Branch added successfully", Toast.LENGTH_SHORT).show();
                        editTextBranchCode.setText("");
                        editTextBranchName.setText("");
                    } else {
                        Toast.makeText(AddBranchActivity.this, "Failed to add branch", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
