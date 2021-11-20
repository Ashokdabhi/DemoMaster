package com.demomaster.runtimePermishan;

import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

public class SimplePermissionListener implements PermissionListener {

    private final RuntimePermishanActivity activity;


    public SimplePermissionListener(RuntimePermishanActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onPermissionGranted(PermissionGrantedResponse response) {
        activity.showPermissionGranted(response.getPermissionName());
    }

    @Override
    public void onPermissionDenied(PermissionDeniedResponse response) {

        if (response.isPermanentlyDenied()){
            activity.handlePermenentDeniedPermission(response.getPermissionName());
            return;
        }
        activity.showPermissionDenied(response.getPermissionName());
    }

    @Override
    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
        activity.showPermissionRationale(token);
    }
}
