package com.demomaster.runtimePermishan;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.TextView;

import com.demomaster.R;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;

public class RuntimePermishanActivity extends AppCompatActivity {

    SimplePermissionListener simplePermissionListener;
    SimpleMultiplePermissionListener multiplePermissionListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_runtime_permishan);

        simplePermissionListener = new SimplePermissionListener(this);
        multiplePermissionListener = new SimpleMultiplePermissionListener(this);
    }

    public void requredCamera(View view) {

        Dexter.withActivity(this).withPermission(Manifest.permission.CAMERA).withListener(simplePermissionListener).check();
    }

    public void requredStorage(View view) {
        Dexter.withActivity(this).withPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE).withListener(simplePermissionListener).check();
    }

    public void requredContact(View view) {
        Dexter.withActivity(this).withPermission(Manifest.permission.READ_CONTACTS).withListener(simplePermissionListener).check();
    }

    public void requredAll(View view) {

        Dexter.withActivity(this).withPermissions(Manifest.permission.CAMERA,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_CONTACTS,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION).withListener(multiplePermissionListener).check();
    }

    public void showPermissionGranted(String permissionName) {
        switch (permissionName) {
            case Manifest.permission.CAMERA:
                TextView txt_camera = (TextView) findViewById(R.id.txt_camera);
                txt_camera.setText("Permission Granted");
//                txt_camera.setTextColor(ContextCompat.getColor(this,R.color.permission_granted));
                txt_camera.setTextColor(getResources().getColor(R.color.permission_granted));
                break;
            case Manifest.permission.WRITE_EXTERNAL_STORAGE:
                TextView txt_storage = (TextView) findViewById(R.id.txt_storage);
                txt_storage.setText("Permission Granted");
//                txt_camera.setTextColor(ContextCompat.getColor(this,R.color.permission_granted));
                txt_storage.setTextColor(getResources().getColor(R.color.permission_granted));
                break;
            case Manifest.permission.READ_CONTACTS:
                TextView txt_Contact = (TextView) findViewById(R.id.txt_Contact);
                txt_Contact.setText("Permission Granted");
//                txt_camera.setTextColor(ContextCompat.getColor(this,R.color.permission_granted));
                txt_Contact.setTextColor(getResources().getColor(R.color.permission_granted));
                break;
        }
    }

    public void showPermissionDenied(String permissionName) {
        switch (permissionName) {
            case Manifest.permission.CAMERA:
                TextView txt_camera = (TextView) findViewById(R.id.txt_camera);
                txt_camera.setText("Permission Denied");
//                txt_camera.setTextColor(ContextCompat.getColor(this,R.color.permission_granted));
                txt_camera.setTextColor(getResources().getColor(R.color.permission_denied));
                break;
            case Manifest.permission.WRITE_EXTERNAL_STORAGE:
                TextView txt_storage = (TextView) findViewById(R.id.txt_storage);
                txt_storage.setText("Permission Denied");
//                txt_camera.setTextColor(ContextCompat.getColor(this,R.color.permission_granted));
                txt_storage.setTextColor(getResources().getColor(R.color.permission_denied));
                break;
            case Manifest.permission.READ_CONTACTS:
                TextView txt_Contact = (TextView) findViewById(R.id.txt_Contact);
                txt_Contact.setText("Permission Denied");
//                txt_camera.setTextColor(ContextCompat.getColor(this,R.color.permission_granted));
                txt_Contact.setTextColor(getResources().getColor(R.color.permission_denied));
                break;
        }
    }

    public void showPermissionRationale(final PermissionToken token) {
        new AlertDialog.Builder(this).setTitle("we need this permission").
                setMessage("please allow this permission for do some magic").
                setPositiveButton("Allow", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        token.continuePermissionRequest();
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        token.cancelPermissionRequest();
                        dialog.dismiss();
                    }
                })
                .setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        token.cancelPermissionRequest();
                    }
                }).show();
    }

    public void handlePermenentDeniedPermission(String permissionName) {

        switch (permissionName) {
            case Manifest.permission.CAMERA:
                TextView txt_camera = (TextView) findViewById(R.id.txt_camera);
                txt_camera.setText("Permission Denied Permanently");
//                txt_camera.setTextColor(ContextCompat.getColor(this,R.color.permission_granted));
                txt_camera.setTextColor(getResources().getColor(R.color.permission_denied_permanent));
                break;
            case Manifest.permission.WRITE_EXTERNAL_STORAGE:
                TextView txt_storage = (TextView) findViewById(R.id.txt_storage);
                txt_storage.setText("Permission Denied Permanently");
//                txt_camera.setTextColor(ContextCompat.getColor(this,R.color.permission_granted));
                txt_storage.setTextColor(getResources().getColor(R.color.permission_denied_permanent));
                break;
            case Manifest.permission.READ_CONTACTS:
                TextView txt_Contact = (TextView) findViewById(R.id.txt_Contact);
                txt_Contact.setText("Permission Denied Permanently");
//                txt_camera.setTextColor(ContextCompat.getColor(this,R.color.permission_granted));
                txt_Contact.setTextColor(getResources().getColor(R.color.permission_denied_permanent));
                break;

        }
        new AlertDialog.Builder(this).setTitle("we need this permission").
                setMessage("please allow this permission for app setting page").
                setPositiveButton("Allow", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        openSettings();
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();
                    }
                }).show();

    }

    public void openSettings() {

        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", getPackageName(), null);
        intent.setData(uri);
        startActivity(intent);
    }
}
