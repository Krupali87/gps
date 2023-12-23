package com.app.gpsphonelocator_new.phone.util;

import android.content.Context;
import android.content.SharedPreferences;

public class ShareReferAuthen {
    public static String getUserID(Context context) {
        return context.getSharedPreferences("AUTHENTICATION", 0).getString("user_id", "");
    }

    public static void setUserID(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("AUTHENTICATION", 0).edit();
        edit.putString("user_id", str);
        edit.commit();
    }

    public static String getUserMail(Context context) {
        return context.getSharedPreferences("AUTHENTICATION", 0).getString("user_email", "");
    }

    public static void setUserMail(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("AUTHENTICATION", 0).edit();
        edit.putString("user_email", str);
        edit.commit();
    }

    public static String getUserPrivateNumber(Context context) {
        return context.getSharedPreferences("AUTHENTICATION", 0).getString("user_private_number", "");
    }

    public static void setUserPrivateNumber(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("AUTHENTICATION", 0).edit();
        edit.putString("user_private_number", str);
        edit.commit();
    }
}
