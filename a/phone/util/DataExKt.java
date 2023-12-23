package com.app.gpsphonelocator_new.phone.util;

import android.content.Context;
import android.os.Bundle;

import androidx.core.app.NotificationCompat;

import com.google.firebase.analytics.FirebaseAnalytics;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"logEvent", "", "context", "Landroid/content/Context;", "event", "", "APP78_NumberLocator_v1.1.0(110)_Nov.27.2023_productionRelease"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: DataEx.kt */
public final class DataExKt {
    public static final void logEvent(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_EVENT);
        FirebaseAnalytics.getInstance(context).logEvent(str, new Bundle());
    }
}
