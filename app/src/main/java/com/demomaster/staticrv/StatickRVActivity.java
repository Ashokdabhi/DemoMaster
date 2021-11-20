package com.demomaster.staticrv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.demomaster.R;

import java.util.ArrayList;
import java.util.List;

public class StatickRVActivity extends AppCompatActivity {

    List<String> nameList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statick_rv);
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
        RecyclerView rv_statick = (RecyclerView) findViewById(R.id.rv_statick);
        LinearLayoutManager layoutManager = new LinearLayoutManager(StatickRVActivity.this);
        rv_statick.setLayoutManager(layoutManager);
        RVAdpter adpter = new RVAdpter(nameList);
        rv_statick.setAdapter(adpter);
        adpter.notifyDataSetChanged();
    }
}
