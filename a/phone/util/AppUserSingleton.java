package com.app.gpsphonelocator_new.phone.util;

import android.content.Context;
import com.app.gpsphonelocator_new.extensions.AppExtensionKt;


public class AppUserSingleton {
    private static AppUserSingleton instance;
    public Context appContext;
    private String avt;
    private String email;
    private String id;
    private Boolean isShareLive;
    private String private_code;
    private Boolean sos;

    public static AppUserSingleton getInstance() {
        if (instance == null) {
            instance = new AppUserSingleton();
        }
        return instance;
    }

    public String getAvt() {
        String str = this.avt;
        if (str != null && !str.isEmpty()) {
            return this.avt;
        }
        Context context = this.appContext;
        if (context == null) {
            return "file:///android_asset/avatar/avatar1.png";
        }
        return AppExtensionKt.getPref(context, Constants.AVATAR_USER, "file:///android_asset/avatar/avatar1.png");
    }

    public void setAvt(String str) {
        Context context = this.appContext;
        if (context != null) {
            this.avt = str;
            AppExtensionKt.setPref(context, Constants.AVATAR_USER, str);
        }
    }

    public void setShareLive(Boolean bool) {
        this.isShareLive = bool;
        Context context = this.appContext;
        if (context != null) {
            AppExtensionKt.setPref(context, Constants.USER_LIVE_SHARE, bool.booleanValue());
        }
    }

    public Boolean getShareLive() {
        Boolean bool = this.isShareLive;
        if (bool != null) {
            return bool;
        }
        Context context = this.appContext;
        if (context == null) {
            return false;
        }
        return Boolean.valueOf(AppExtensionKt.getPref(context, Constants.USER_LIVE_SHARE, false));
    }
}
