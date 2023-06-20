package com.example.onthicodelan5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.onthicodelan5.database.DatabaseHelper;

public class AddLopActivity extends AppCompatActivity {
    private EditText edtTenLop, edtMoTa;
    private Button btnSave;
    private DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lop);
        edtTenLop = findViewById(R.id.al_tlop);
        edtMoTa = findViewById(R.id.al_mta);
        btnSave = findViewById(R.id.al_btsave);
        databaseHelper = new DatabaseHelper(getApplicationContext(), "database5.sqlite", null, 1);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tenLop = edtTenLop.getText().toString();
                String moTa = edtMoTa.getText().toString();
                databaseHelper.queryData("insert into lop values(null, '"+tenLop+"','"+moTa+"');");
                Toast.makeText(AddLopActivity.this, "thêm lớp thành công", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(AddLopActivity.this, LopActivity.class);
                startActivity(i);
            }
        });
    }
}