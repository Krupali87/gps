package com.app.gpsphonelocator_new.phone.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SharedPref {
    public static SharedPreferences mSharePref;

    public static void init(Context context) {
        if (mSharePref == null) {
            mSharePref = PreferenceManager.getDefaultSharedPreferences(context);
        }
    }

    public static boolean isFirstTime(Context context) {
        return context.getSharedPreferences("data", 0).getBoolean("firstTime", true);
    }

    public static boolean isFirstClick(Context context) {
        return context.getSharedPreferences("data", 0).getBoolean("firstClick", true);
    }

    public static void setFirstClick(Context context, Boolean bool) {
        SharedPreferences.Editor edit = context.getSharedPreferences("data", 0).edit();
        edit.putBoolean("firstClick", bool.booleanValue());
        edit.commit();
    }

    public static void setFirstTime(Context context, Boolean bool) {
        SharedPreferences.Editor edit = context.getSharedPreferences("data", 0).edit();
        edit.putBoolean("firstTime", bool.booleanValue());
        edit.commit();
    }

    public static boolean isIntro(Context context) {
        return context.getSharedPreferences("data", 0).getBoolean("intro", false);
    }

    public static void setIntro(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("data", 0).edit();
        edit.putBoolean("intro", true);
        edit.commit();
    }

    public static int getCountOpenApp(Context context) {
        return context.getSharedPreferences("data", 0).getInt("counts", 1);
    }

    public static void increaseCountOpenApp(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("data", 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt("counts", sharedPreferences.getInt("counts", 1) + 1);
        edit.apply();
    }

    public static void forceRated(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("data", 0).edit();
        edit.putBoolean("rated", true);
        edit.apply();
    }

    public static boolean isRated(Context context) {
        return context.getSharedPreferences("data", 0).getBoolean("rated", false);
    }

    public static void setCountThemeAfterSplash(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("data", 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt("themeAfterSplash", sharedPreferences.getInt("themeAfterSplash", 1) + 1);
        edit.apply();
    }
}
