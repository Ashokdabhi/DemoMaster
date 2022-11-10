package com.demomaster.java.staticrv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.demomaster.R;

import java.util.ArrayList;
import java.util.List;

public class StatickRVActivity extends AppCompatActivity {

    List<String> nameList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statick_rv);

        Toolbar toolbar = findViewById(R.id.toolBare);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(v -> onBackPressed());

        nameList.add("Test");
        nameList.add("Demo");
        nameList.add("TestDemo");
        nameList.add("DemoTest");
        nameList.add("DemoTest");
        nameList.add("DemoTest");
        nameList.add("DemoTest");
        nameList.add("DemoTest");
        nameList.add("DemoTest");
        nameList.add("DemoTest");
        nameList.add("DemoTest");
        nameList.add("DemoTest");
        nameList.add("DemoTest");
        nameList.add("DemoTest");
        nameList.add("DemoTest");
        nameList.add("DemoTest");
        nameList.add("DemoTest");

        RecyclerView rvStatic = findViewById(R.id.rvStatic);
        LinearLayoutManager layoutManager = new LinearLayoutManager(StatickRVActivity.this);
        rvStatic.setLayoutManager(layoutManager);
        RVAdpter adpter = new RVAdpter(nameList);
        rvStatic.setAdapter(adpter);

    }
}
