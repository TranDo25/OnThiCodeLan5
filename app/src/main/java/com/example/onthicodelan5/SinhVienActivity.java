package com.example.onthicodelan5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;

import com.example.onthicodelan5.adapter.SinhVienAdapter;
import com.example.onthicodelan5.database.DatabaseHelper;
import com.example.onthicodelan5.model.SinhVien;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class SinhVienActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private FloatingActionButton btnAddSV;
    private SinhVienAdapter sinhVienAdapter;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recview_sv);
        btnAddSV = findViewById(R.id.btn_addsv);
        sinhVienAdapter = new SinhVienAdapter(getApplicationContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        DividerItemDecoration decor = new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL);

        databaseHelper = new DatabaseHelper(getApplicationContext(), "database5.sqlite", null, 1);
//        databaseHelper.queryData("create table if not exists sinhvien(masv integer primary key autoincrement, hoten varchar(255), namsinh integer, quequan varchar(255), namhoc integer);");
//        databaseHelper.queryData("insert into sinhvien values(null, 'Tran Xuan Do', 2001, 'Thai Binh', 4);");
//        databaseHelper.queryData("insert into sinhvien values(null, 'Tran Xuan Do', 2001, 'Thai Binh', 4);");
//        databaseHelper.queryData("insert into sinhvien values(null, 'Tran Xuan Do', 2001, 'Thai Binh', 4);");
//        databaseHelper.queryData("insert into sinhvien values(null, 'Tran Xuan Do', 2001, 'Thai Binh', 4);");
        sinhVienAdapter.setData(getListSV());
        recyclerView.setAdapter(sinhVienAdapter);
        btnAddSV = findViewById(R.id.btn_add_sv);
        btnAddSV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SinhVienActivity.this, AddSVActivity.class);
            }
        });
    }

    private List<SinhVien> getListSV() {
        Cursor cursor = databaseHelper.getData("select * from sinhvien;");
        List<SinhVien> ds = new ArrayList<>();
        while (cursor.moveToNext()) {
            SinhVien tmp = new SinhVien(cursor.getInt(0), cursor.getString(1), cursor.getInt(2), cursor.getString(3), cursor.getInt(4));
            ds.add(tmp);
        }
        return ds;
    }
}