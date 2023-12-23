package com.app.gpsphonelocator_new.phone.service;

import android.annotation.SuppressLint;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

import com.app.gpsphonelocator_new.database.RTDB_DEFINE;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J$\u0010\n\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¨\u0006\u000f"}, d2 = {"com/phone/number/gpstracker/familylocator/phonetracker/phone/service/GPSLocationService$updateMyLocation$1", "Landroid/location/LocationListener;", "onLocationChanged", "", "p0", "Landroid/location/Location;", "onProviderDisabled", "provider", "", "onProviderEnabled", "onStatusChanged", "status", "", "extras", "Landroid/os/Bundle;", "APP78_NumberLocator_v1.1.0(110)_Nov.27.2023_productionRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: GPSLocationService.kt */
public final class GPSLocationService$updateMyLocation$1 implements LocationListener {
    final /* synthetic */ LocationManager $lm;
    final /* synthetic */ GPSLocationService this$0;

    public void onProviderDisabled(String str) {
        Intrinsics.checkNotNullParameter(str, "provider");
    }

    public void onProviderEnabled(String str) {
        Intrinsics.checkNotNullParameter(str, "provider");
    }

    GPSLocationService$updateMyLocation$1(LocationManager locationManager, GPSLocationService gPSLocationService) {
        this.$lm = locationManager;
        this.this$0 = gPSLocationService;
    }

    public void onLocationChanged(Location location) {
        Intrinsics.checkNotNullParameter(location, "p0");
        try {
            @SuppressLint("MissingPermission") Location lastKnownLocation = this.$lm.getLastKnownLocation("gps");
            DatabaseReference child = FirebaseDatabase.getInstance().getReference().child(RTDB_DEFINE.TABLE_USER).child(this.this$0.getF().uid);
            Intrinsics.checkNotNullExpressionValue(child, "getInstance().reference.….TABLE_USER).child(f.uid)");
            if (lastKnownLocation != null) {
                boolean z = true;
                if (!(this.this$0.longitude == lastKnownLocation.getLongitude())) {
                    if (this.this$0.latitude != lastKnownLocation.getLatitude()) {
                        z = false;
                    }
                    if (!z) {
                        HashMap hashMap = new HashMap();
                        this.this$0.longitude = lastKnownLocation.getLongitude();
                        this.this$0.latitude = lastKnownLocation.getLatitude();
                        hashMap.put(RTDB_DEFINE.TBL_SAVE.INSTANCE.getLATITUDES(), String.valueOf(this.this$0.latitude));
                        hashMap.put(RTDB_DEFINE.TBL_SAVE.INSTANCE.getLONGITUDES(), String.valueOf(this.this$0.longitude));
                        GPSLocationService gPSLocationService = this.this$0;

                        child.updateChildren(hashMap).addOnCompleteListener(new GPSLocationService$updateMyLocation$1$$ExternalSyntheticLambda0());
                        return;
                    }
                }
            }
            Log.d("LOG", "Location the same");
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public static final void onLocationChanged$lambda$0(Task task) {
        Intrinsics.checkNotNullParameter(task, "tasks");
        task.isSuccessful();
    }

    public void onStatusChanged(String str, int i, Bundle bundle) {
        LocationListener.super.onStatusChanged(str, i, bundle);
    }
}
