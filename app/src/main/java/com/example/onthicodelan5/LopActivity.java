package com.example.onthicodelan5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;

import com.example.onthicodelan5.adapter.LopAdapter;
import com.example.onthicodelan5.database.DatabaseHelper;
import com.example.onthicodelan5.model.Lop;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class LopActivity extends AppCompatActivity {
    private DatabaseHelper databaseHelper;
    private RecyclerView recyclerView;
    private LopAdapter adapter;
    private FloatingActionButton btnAddLop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lop);
        databaseHelper = new DatabaseHelper(getApplicationContext(), "database5.sqlite", null, 1);
        recyclerView = findViewById(R.id.rv_lop);
        adapter = new LopAdapter(getApplicationContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        DividerItemDecoration decoration = new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(decoration);
        databaseHelper.queryData("create table if not exists lop(malop integer primary key autoincrement, tenlop varchar(255), mota varchar(255));");
        databaseHelper.queryData("insert into lop values(null, 'chuyen de CNPM','lop do thay Phuong day');");
        adapter.setData(getDataLop());
        recyclerView.setAdapter(adapter);
        btnAddLop = findViewById(R.id.lop_btnadd);
        btnAddLop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LopActivity.this, AddLopActivity.class);
                startActivity(i);
            }
        });
    }

    private List<Lop> getDataLop() {
        Cursor cursor = databaseHelper.getData("select * from lop;");
        List<Lop> ds = new ArrayList<>();
        while (cursor.moveToNext()) {

            Lop tmp = new Lop(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
            ds.add(tmp);
        }
        return ds;
    }
}