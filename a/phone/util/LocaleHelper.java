package com.app.gpsphonelocator_new.phone.util;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.app.gpsphonelocator_new.extensions.AppExtensionKt;

import java.util.Locale;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0004H\u0002¨\u0006\u000b"}, d2 = {"Lcom/phone/number/gpstracker/familylocator/phonetracker/phone/util/LocaleHelper;", "", "()V", "getLanguageCode", "", "c", "Landroid/content/Context;", "setLocale", "updateResources", "contextMain", "language", "APP78_NumberLocator_v1.1.0(110)_Nov.27.2023_productionRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LocaleHelper.kt */
public final class LocaleHelper {
    public static final LocaleHelper INSTANCE = new LocaleHelper();

    private LocaleHelper() {
    }

    public final Context setLocale(Context context) {
        Intrinsics.checkNotNullParameter(context, "c");
        return updateResources(context, getLanguageCode(context));
    }

    private final String getLanguageCode(Context context) {
        if (Intrinsics.areEqual((Object) String.valueOf(AppExtensionKt.getPref(context, Constants.PREFERENCE_SELECTED_LANGUAGE, "en")), (Object) "")) {
            return "en";
        }
        String valueOf = String.valueOf(AppExtensionKt.getPref(context, Constants.PREFERENCE_SELECTED_LANGUAGE, "en"));
        int hashCode = valueOf.hashCode();
        return hashCode != 3246 ? hashCode != 3276 ? hashCode != 3329 ? (hashCode == 3588 && valueOf.equals("pt")) ? "pt" : "en" : !valueOf.equals("hi") ? "en" : "hi" : !valueOf.equals("fr") ? "en" : "fr" : !valueOf.equals("es") ? "en" : "es";
    }

    private final Context updateResources(Context context, String str) {
        Locale locale;
        if (Intrinsics.areEqual((Object) str, (Object) "zh-rTW")) {
            locale = new Locale("zh", "TW");
        } else {
            locale = new Locale(str);
        }
        Locale.setDefault(locale);
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
        Configuration configuration = new Configuration(resources.getConfiguration());
        configuration.setLocale(locale);
        Context createConfigurationContext = context.createConfigurationContext(configuration);
        Intrinsics.checkNotNullExpressionValue(createConfigurationContext, "context.createConfigurationContext(config)");
        return createConfigurationContext;
    }
}
