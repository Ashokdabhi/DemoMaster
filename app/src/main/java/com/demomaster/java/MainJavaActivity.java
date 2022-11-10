package com.demomaster.java;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.demomaster.R;
import com.demomaster.java.picassoDemo.ListActivity;
import com.demomaster.demo_master.apiRecyleview.ApiRecycleview;
import com.demomaster.demo_master.facebook.FaceAtivity;
import com.demomaster.demo_master.googleMap.GoogleMapActivity;
import com.demomaster.demo_master.runtimePermishan.RuntimePermishanActivity;
import com.demomaster.demo_master.sqlDatabase.SqlDataBaseActivity;
import com.demomaster.java.staticrv.StatickRVActivity;

public class MainJavaActivity extends AppCompatActivity implements View.OnClickListener {

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_master);

        mContext = MainJavaActivity.this;

        Toolbar toolbar = findViewById(R.id.toolBare);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Java Logic");
        }
        toolbar.setNavigationOnClickListener(v -> onBackPressed());

        Button btnRecycleViewStatic = findViewById(R.id.btnRecycleViewStatic);
        btnRecycleViewStatic.setOnClickListener(this);
        Button btnRecycleViewList = findViewById(R.id.btnRecycleViewList);
        btnRecycleViewList.setText(getResources().getString(R.string.picasso_load_image));
        btnRecycleViewList.setOnClickListener(this);
        Button btn_ApiRecycleview = findViewById(R.id.btn_ApiRecycleview);
        btn_ApiRecycleview.setOnClickListener(this);
        Button btn_Facbook = findViewById(R.id.btn_Facbook);
        btn_Facbook.setOnClickListener(this);
        Button btn_runtime_Permishan = findViewById(R.id.btn_runtime_Permishan);
        btn_runtime_Permishan.setOnClickListener(this);
        Button btn_GoogleMap = findViewById(R.id.btn_GoogleMap);
        btn_GoogleMap.setOnClickListener(this);
        Button btn_Sql_Database = findViewById(R.id.btn_Sql_Database);
        btn_Sql_Database.setOnClickListener(this);


    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnRecycleViewStatic:
                Intent intent = new Intent(mContext, StatickRVActivity.class);
                startActivity(intent);
                break;
            case R.id.btnRecycleViewList:
                Intent listRecycle = new Intent(mContext, ListActivity.class);
                startActivity(listRecycle);
                break;
            case R.id.btn_ApiRecycleview:
                Intent intent1 = new Intent(mContext, ApiRecycleview.class);
                startActivity(intent1);
                break;
            case R.id.btn_Facbook:
                Intent facebook = new Intent(mContext, FaceAtivity.class);
                startActivity(facebook);
                break;
            case R.id.btn_runtime_Permishan:
                Intent runtime = new Intent(mContext, RuntimePermishanActivity.class);
                startActivity(runtime);
                break;
            case R.id.btn_GoogleMap:
                Intent googlemap = new Intent(mContext, GoogleMapActivity.class);
                startActivity(googlemap);
                break;
            case R.id.btn_Sql_Database:
                Intent sqliteDatabase = new Intent(mContext, SqlDataBaseActivity.class);
                startActivity(sqliteDatabase);
                break;
        }
    }
}