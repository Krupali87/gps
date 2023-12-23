package com.app.gpsphonelocator_new.activity;

import android.location.Location;

import com.app.gpsphonelocator_new.R;
import com.app.gpsphonelocator_new.common.CustomToast;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.firebase.analytics.FirebaseAnalytics;

import kotlin.jvm.internal.Intrinsics;
import mumayank.com.airlocationlibrary.AirLocation;


public final class MainActivity$getMyLocation$1 implements AirLocation.Callbacks {
    final  MainActivity this$0;

    MainActivity$getMyLocation$1(MainActivity mainActivity) {
        this.this$0 = mainActivity;
    }

    public void onFailed(AirLocation.LocationFailedEnum locationFailedEnum) {

    }

    public void onSuccess(Location location) {

    }
}
