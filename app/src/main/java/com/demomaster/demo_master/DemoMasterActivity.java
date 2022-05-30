package com.demomaster.demo_master;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.demomaster.R;
import com.demomaster.demo_master.RecycleApiCall.ListActivity;
import com.demomaster.demo_master.apiRecyleview.ApiRecycleview;
import com.demomaster.demo_master.dataBindig.DataBindigMainActivity;
import com.demomaster.demo_master.facebook.FaceAtivity;
import com.demomaster.demo_master.googleMap.GoogleMapActivity;
import com.demomaster.demo_master.notification.NotificaionActivity;
import com.demomaster.demo_master.runtimePermishan.RuntimePermishanActivity;
import com.demomaster.demo_master.sqlDatabase.SqlDataBaseActivity;
import com.demomaster.demo_master.staticrv.StatickRVActivity;

public class DemoMasterActivity extends AppCompatActivity implements View.OnClickListener {

    private Context mContext;

    private Button btn_RecyleViewStatick;
    private Button btn_ApiRecycleview;
    private Button btn_Piramind;
    private Button btn_Facbook;
    private Button btn_RecyleViewList;
    private Button btn_runtime_Permishan;
    private Button btn_Notifiation;
    private Button btn_GoogleMap;
    private Button btn_Sql_Database;
    private Button btn_room;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_master);

        mContext = DemoMasterActivity.this;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbare);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btn_RecyleViewStatick = (Button) findViewById(R.id.btn_RecyleViewStatick);
        btn_RecyleViewStatick.setOnClickListener(this);
        btn_RecyleViewList = (Button) findViewById(R.id.btn_RecyleViewList);
        btn_RecyleViewList.setOnClickListener(this);
        btn_ApiRecycleview = (Button) findViewById(R.id.btn_ApiRecycleview);
        btn_ApiRecycleview.setOnClickListener(this);
        btn_Piramind = (Button) findViewById(R.id.btn_Piramind);
        btn_Piramind.setOnClickListener(this);
        btn_Facbook = (Button) findViewById(R.id.btn_Facbook);
        btn_Facbook.setOnClickListener(this);
        btn_runtime_Permishan = (Button) findViewById(R.id.btn_runtime_Permishan);
        btn_runtime_Permishan.setOnClickListener(this);
        btn_Notifiation = (Button) findViewById(R.id.btn_Notifiation);
        btn_Notifiation.setOnClickListener(this);
        btn_GoogleMap = (Button) findViewById(R.id.btn_GoogleMap);
        btn_GoogleMap.setOnClickListener(this);
        btn_Sql_Database = (Button) findViewById(R.id.btn_Sql_Database);
        btn_Sql_Database.setOnClickListener(this);
        btn_room = (Button) findViewById(R.id.btn_room);
        btn_room.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_RecyleViewStatick:
                Intent intent = new Intent(mContext, StatickRVActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_RecyleViewList:
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
                Intent runtimeper = new Intent(mContext, RuntimePermishanActivity.class);
                startActivity(runtimeper);
                break;
            case R.id.btn_Notifiation:
                Intent notificatin = new Intent(mContext, NotificaionActivity.class);
                startActivity(notificatin);
                break;
            case R.id.btn_GoogleMap:
                Intent googlemap = new Intent(mContext, GoogleMapActivity.class);
                startActivity(googlemap);
                break;
            case R.id.btn_Sql_Database:
                Intent sqltiteDatabse = new Intent(mContext, SqlDataBaseActivity.class);
                startActivity(sqltiteDatabse);
                break;
            case R.id.btn_room:
                Intent databindig = new Intent(mContext, DataBindigMainActivity.class);
                startActivity(databindig);
                break;
            case R.id.btn_Piramind:
               /* int i,j, n = 5;
                for (i = 0; i < n; i++) {
                    for (j = 0; j <= i; j++) {
                        System.out.print("* ");
                    }
                    System.out.println();
                }

                int i, j, n = 5;
                for (i = 1; i < n; i++) {
                    for (j = 2 * (n - i); j >= 1; j--) {
                        System.out.print(" ");
                    }
                    for (j = 0; j < i; j++) {
                        System.out.print("* ");
                    }
                    System.out.println();
                }

                int i, j, n = 15;
                for (i = 0; i < n; i++) {
                    for (j = n - i; j > 1; j--) {
                        System.out.print(" ");
                    }
                    for (j = 0; j <= i; j++) {
                        System.out.print("* ");
                    }
                    System.out.println();
                }

                int i, j, n = 4;
                for (i = 1; i <= n; i++) {
                    int sum = i;
                    for (j = 1; j <= i; j++) {
                        System.out.print(sum + " ");

                        sum = sum + n - j;
                    }
                    System.out.println();
//                    System.out.print(i+" ");
                }
                for (int i = 1; i <= 4; i++) {
                    int sum = i;
                    for (int j = 4; j >= 1; j--) {
                        System.out.print(sum + " ");
                        sum++;
                    }
                    sum = i + 1 + 4;
                    System.out.println();
                }*/
                int sum = 1;
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j <= i; j++) {
                        System.out.print(sum + " ");
                        sum = sum + 1;
                    }
                    System.out.println();
                }
                /*int i, j, n = 5 ,sum=1;
                for (i = 1; i < n; i++) {
                    for (j = 2 * (n - i); j >= 1; j--) {
                        System.out.print(" ");
                    }
                    for (j = 0; j < i; j++) {
                        System.out.print(" "+sum);
                        sum = sum+1;
                    }
//                    sum=1;
                    System.out.println();
                }*/
                /*int i, j, n = 5, sum = 1;
                for (i = 0; i < n; i++) {
                    for (j = n - i; j > 1; j--) {
                        System.out.print(" ");
                    }
                    for (j = 0; j <= i; j++) {
                        System.out.print(" " + sum);
                        sum = sum + 1;
                    }
//                    sum=1;
                    System.out.println();
                }*/
                break;
        }
    }
}