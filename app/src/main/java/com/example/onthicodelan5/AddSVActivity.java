package com.example.onthicodelan5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.onthicodelan5.database.DatabaseHelper;

public class AddSVActivity extends AppCompatActivity {
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_svactivity);
        TextView txtHoTen = findViewById(R.id.addsv_hoten);
        TextView txtNamSinh = findViewById(R.id.addsv_namsinh);
        TextView txtQuequan = findViewById(R.id.addsv_quequan);
        TextView txtNamHoc = findViewById(R.id.addsv_namhoc);
        Button btnAddSV = findViewById(R.id.addsv_btnadd);
        databaseHelper = new DatabaseHelper(getApplicationContext(), "database5.sqlite", null, 1);
        btnAddSV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String hoTen = String.valueOf(txtHoTen.getText());
                int namSinh = Integer.parseInt((String) txtNamSinh.getText());
                String queQuan = String.valueOf(txtQuequan.getText());
                int namHoc = Integer.parseInt(String.valueOf(txtNamHoc.getText()));
                databaseHelper.queryData("insert into sinhvien values(null, '" + hoTen + "', " + namSinh + ", '" + queQuan + "', " + namHoc + ");");
                Toast.makeText(AddSVActivity.this, "thêm mới sinh viên thành công", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(AddSVActivity.this, SinhVienActivity.class);
                startActivity(i);
            }
        });
    }
}