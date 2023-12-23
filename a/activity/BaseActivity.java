package com.app.gpsphonelocator_new.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.viewbinding.ViewBinding;
import com.app.gpsphonelocator_new.common.Common;
import com.app.gpsphonelocator_new.phone.service.GPSLocationService;
import com.app.gpsphonelocator_new.phone.util.LocaleHelper;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public abstract class BaseActivity<T extends ViewBinding> extends AppCompatActivity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int REQUEST_CODE_PERMISSIONS = 101;
    protected T mBinding;

    public abstract T getViewBinding();

    public void onLocationPermissionGranted() {
    }

    public final T getMBinding() {
        T t = this.mBinding;
        if (t != null) {
            return t;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        return null;
    }

    public final void setMBinding(T t) {
        Intrinsics.checkNotNullParameter(t, "<set-?>");
        this.mBinding = t;
    }


    @SuppressLint("WrongConstant")
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initWindow();
        setRequestedOrientation(1);
        fullScreencall();
        setMBinding(getViewBinding());
        setContentView(getMBinding().getRoot());
    }

    @SuppressLint("ResourceType")
    public void initWindow() {
        Window window = getWindow();
        if (window != null) {
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(getResources().getColor(17170444));
            window.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));
            window.getDecorView().setSystemUiVisibility(8192);
        }
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().setFlags(512, 512);
        }
    }

    private final void fullScreencall() {
        View decorView = getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "window.decorView");
        decorView.setSystemUiVisibility(InputDeviceCompat.SOURCE_TOUCHSCREEN);
    }

    public void showLoading() {
        Window window = getWindow();
        if (window != null) {
            window.setFlags(16, 16);
        }
    }

    public void hideLoading() {
        Window window = getWindow();
        if (window != null) {
            window.clearFlags(16);
        }
    }

    public void stopLocationService() {
        if (!Common.Companion.isAppRunBackground()) {
            stopService(new Intent(this, GPSLocationService.class));
        }
    }

    @SuppressLint({"WrongConstant", "MissingPermission"})
    public boolean isNetworkAvailable() {
        NetworkCapabilities networkCapabilities;
        @SuppressLint("WrongConstant") Object systemService = getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        @SuppressLint("MissingPermission") Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
            return false;
        }
        if (!networkCapabilities.hasTransport(1) && !networkCapabilities.hasTransport(0) && !networkCapabilities.hasTransport(3) && !networkCapabilities.hasTransport(2)) {
            return false;
        }
        return true;
    }

    public void requestLocationPermission() {
        Context context = this;
        boolean z = true;
        if (ActivityCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            if (ActivityCompat.checkSelfPermission(context, "android.permission.FOREGROUND_SERVICE") != 0) {
                z = false;
            }
            if (!z) {
                ActivityCompat.requestPermissions(this, new String[]{"android.permission.FOREGROUND_SERVICE"}, 101);
                return;
            }
            return;
        }
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.FOREGROUND_SERVICE"}, 101);
    }

    public boolean isLocationPermissionGranted() {
        return ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(iArr, "grantResults");
        super.onRequestPermissionsResult(i, strArr, iArr);
    }


    public void attachBaseContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "base");
        super.attachBaseContext(LocaleHelper.INSTANCE.setLocale(context));
    }

    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
