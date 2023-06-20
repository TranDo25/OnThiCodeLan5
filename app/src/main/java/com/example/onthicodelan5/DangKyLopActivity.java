package com.example.onthicodelan5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;

import com.example.onthicodelan5.adapter.DkyLopAdapter;
import com.example.onthicodelan5.database.DatabaseHelper;
import com.example.onthicodelan5.model.DangKyLop;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class DangKyLopActivity extends AppCompatActivity {
    private DatabaseHelper databaseHelper;
    private DkyLopAdapter adapter;
    private RecyclerView recyclerView;
    private FloatingActionButton btnAddDky;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky_lop);
        databaseHelper = new DatabaseHelper(getApplicationContext(),"database5.sqlite", null, 1);
        recyclerView = findViewById(R.id.rv_dklop);
        btnAddDky = findViewById(R.id.dkl_btadd);
        adapter = new DkyLopAdapter(getApplicationContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        DividerItemDecoration decoration = new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(decoration);
//        databaseHelper.queryData("create table if not exists sinhvien_lop(id integer primary key autoincrement, masv integer, malop integer, kyhoc integer, sotc integer, " +
//                "foreign key(masv) references sinhvien(masv), foreign key(malop) references lop(malop));");
//        databaseHelper.queryData("insert into sinhvien_lop values(null, 1, 1, 2, 3)");
        adapter.setData(getListDKy());
        recyclerView.setAdapter(adapter);
        btnAddDky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DangKyLopActivity.this, AddDkyLopActivity.class);
                startActivity(i);
            }
        });
    }

    private List<DangKyLop> getListDKy() {
        Cursor cursor = databaseHelper.getData("select * from sinhvien_lop;");
        List<DangKyLop> ds = new ArrayList<>();
        while (cursor.moveToNext()) {
            DangKyLop tmp = new DangKyLop(cursor.getInt(0), cursor.getInt(1), cursor.getInt(2), cursor.getInt(3), cursor.getInt(4));
            ds.add(tmp);
        }
        return ds;
    }
}