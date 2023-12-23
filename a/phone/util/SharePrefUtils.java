package com.app.gpsphonelocator_new.phone.util;

import android.content.Context;
import android.content.SharedPreferences;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/phone/number/gpstracker/familylocator/phonetracker/util/SharePrefUtils;", "", "()V", "Companion", "APP78_NumberLocator_v1.1.0(110)_Nov.27.2023_productionRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SharePrefUtils.kt */
public final class SharePrefUtils {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\r"}, d2 = {"Lcom/phone/number/gpstracker/familylocator/phonetracker/util/SharePrefUtils$Companion;", "", "()V", "forceRated", "", "context", "Landroid/content/Context;", "getCountOpenApp", "", "increaseCountOpenApp", "isRated", "", "setCountThemeAfterSplash", "APP78_NumberLocator_v1.1.0(110)_Nov.27.2023_productionRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SharePrefUtils.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isRated(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            SharedPreferences sharedPreferences = context.getSharedPreferences("data", 0);
            Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…a\", Context.MODE_PRIVATE)");
            return sharedPreferences.getBoolean("rated", false);
        }

        public final int getCountOpenApp(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return context.getSharedPreferences("data", 0).getInt("counts", 1);
        }

        public final void increaseCountOpenApp(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            SharedPreferences sharedPreferences = context.getSharedPreferences("data", 0);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putInt("counts", sharedPreferences.getInt("counts", 1) + 1);
            edit.commit();
        }

        public final void setCountThemeAfterSplash(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            SharedPreferences sharedPreferences = context.getSharedPreferences("data", 0);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putInt("themeAfterSplash", sharedPreferences.getInt("themeAfterSplash", 1) + 1);
            edit.commit();
        }

        public final void forceRated(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            SharedPreferences.Editor edit = context.getSharedPreferences("data", 0).edit();
            edit.putBoolean("rated", true);
            edit.commit();
        }
    }
}
