package com.app.gpsphonelocator_new.phone.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/phone/number/gpstracker/familylocator/phonetracker/phone/util/NetUtils;", "", "()V", "haveNetworkConnection", "", "context", "Landroid/content/Context;", "APP78_NumberLocator_v1.1.0(110)_Nov.27.2023_productionRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: NetUtils.kt */
public final class NetUtils {
    public static final NetUtils INSTANCE = new NetUtils();

    private NetUtils() {
    }

    @JvmStatic
    public static final boolean haveNetworkConnection(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        @SuppressLint("WrongConstant") Object systemService = context.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        NetworkInfo[] allNetworkInfo = ((ConnectivityManager) systemService).getAllNetworkInfo();
        Intrinsics.checkNotNullExpressionValue(allNetworkInfo, "cm.allNetworkInfo");
        boolean z = false;
        boolean z2 = false;
        for (NetworkInfo networkInfo : allNetworkInfo) {
            if (StringsKt.equals(networkInfo.getTypeName(), "WIFI", true) && networkInfo.isConnected()) {
                z = true;
            }
            if (StringsKt.equals(networkInfo.getTypeName(), "MOBILE", true) && networkInfo.isConnected()) {
                z2 = true;
            }
        }
        if (z || z2) {
            return true;
        }
        return false;
    }
}
