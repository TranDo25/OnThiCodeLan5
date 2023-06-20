package com.example.onthicodelan5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.onthicodelan5.database.DatabaseHelper;

public class AddDkyLopActivity extends AppCompatActivity {
    private EditText edtMSV, edtMaLop, etKyHoc, edtSoTC;
    private Button btnSave;
private DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dky_lop);
        edtMSV = findViewById(R.id.adkl_edt1);
        edtMaLop = findViewById(R.id.adkl_edt2);
        etKyHoc = findViewById(R.id.adkl_edt3);
        edtSoTC = findViewById(R.id.adkl_edt4);
        databaseHelper = new DatabaseHelper(getApplicationContext(), "database5.sqlite", null, 1);
        btnSave = findViewById(R.id.adkl_btsave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int msv = Integer.parseInt(edtMSV.getText().toString());
                int malop = Integer.parseInt(edtMaLop.getText().toString());
                int kyhoc = Integer.parseInt(etKyHoc.getText().toString());
                int sotinchi = Integer.parseInt(edtSoTC.getText().toString());
                databaseHelper.queryData("insert into sinhvien_lop values(null, "+msv+","+malop+","+kyhoc+","+sotinchi+");");
                Toast.makeText(AddDkyLopActivity.this, "add thành công", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(AddDkyLopActivity.this, DangKyLopActivity.class);
                startActivity(i);
            }
        });
    }
}