package com.example.onthicodelan5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    private Button btnSV, btnLop, btnDkyLop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnSV = findViewById(R.id.btn1);
        btnLop = findViewById(R.id.btn2);
        btnDkyLop = findViewById(R.id.btn3);
        btnSV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this, SinhVienActivity.class);
                startActivity(i);
            }
        });
        btnLop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this, LopActivity.class);
                startActivity(i);
            }
        });
        btnDkyLop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this, DangKyLopActivity.class);
                startActivity(i);
            }
        });
    }
}