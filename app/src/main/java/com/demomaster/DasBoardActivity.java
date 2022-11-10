package com.demomaster;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.demomaster.java.MainJavaActivity;
import com.demomaster.kotlin.MainKotlinActivity;

public class DasBoardActivity extends AppCompatActivity implements View.OnClickListener {

    private Context mContext;

    private Button btnJava;
    private Button btnKotlin;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = DasBoardActivity.this;
        Toolbar toolbar = findViewById(R.id.toolBare);
        setSupportActionBar(toolbar);

        btnJava = findViewById(R.id.btnJava);
        btnJava.setOnClickListener(this);
        btnKotlin = findViewById(R.id.btnKotlin);
        btnKotlin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == btnJava.getId()) {
            startActivity(new Intent(mContext, MainJavaActivity.class));
        } else if (v.getId() == btnKotlin.getId()) {
            startActivity(new Intent(mContext, MainKotlinActivity.class));
        }
    }
}
