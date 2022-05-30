package com.demomaster;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.demomaster.demo_master.DemoMasterActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Context mContext;

    private Button btnDemoMaster;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = MainActivity.this;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbare);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "TOOLBARE CLICKE ", Toast.LENGTH_SHORT).show();
            }
        });
        btnDemoMaster = findViewById(R.id.btnDemoMaster);
        btnDemoMaster.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == btnDemoMaster.getId()) {
            startActivity(new Intent(mContext, DemoMasterActivity.class));
        }
    }
}
