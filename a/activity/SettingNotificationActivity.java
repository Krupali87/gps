package com.app.gpsphonelocator_new.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import com.app.gpsphonelocator_new.databinding.ActivitySettingNotificationBinding;
import com.app.gpsphonelocator_new.extensions.AppExtensionKt;
import com.app.gpsphonelocator_new.phone.util.Constants;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

public final class SettingNotificationActivity extends BaseActivity<ActivitySettingNotificationBinding> {
    private boolean isOnPushNotify = true;
    private boolean isOnZoneAlert = true;

    public static  ActivitySettingNotificationBinding access$getMBinding(SettingNotificationActivity settingNotificationActivity) {
        return (ActivitySettingNotificationBinding) settingNotificationActivity.getMBinding();
    }

    public  boolean isOnZoneAlert() {
        return this.isOnZoneAlert;
    }

    public  void setOnZoneAlert(boolean z) {
        this.isOnZoneAlert = z;
    }

    public  boolean isOnPushNotify() {
        return this.isOnPushNotify;
    }

    public  void setOnPushNotify(boolean z) {
        this.isOnPushNotify = z;
    }


    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bindComponent();
        bindEvent();
    }

    private final void bindComponent() {
        Context context = this;
        boolean pref = AppExtensionKt.getPref(context, Constants.NOTIFICATION_SOS_ALERT, true);
        ((ActivitySettingNotificationBinding) getMBinding()).onOffSwitchPushNotification.setChecked(pref);
        this.isOnPushNotify = pref;
        boolean pref2 = AppExtensionKt.getPref(context, Constants.NOTIFICATION_ZONE_ALERT, true);
        ((ActivitySettingNotificationBinding) getMBinding()).onOffSwitchZoneAlert.setChecked(pref2);
        this.isOnZoneAlert = pref2;

    }

    public ActivitySettingNotificationBinding getViewBinding() {
        ActivitySettingNotificationBinding inflate = ActivitySettingNotificationBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        return inflate;
    }

    private final void bindEvent() {
        ActivitySettingNotificationBinding activitySettingNotificationBinding = (ActivitySettingNotificationBinding) getMBinding();
        activitySettingNotificationBinding.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intrinsics.checkNotNullParameter(this, "this$0");
               onBackPressed();
            }
        });
        activitySettingNotificationBinding.ivSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intrinsics.checkNotNullParameter(this, "this$0");
                Context context = getApplicationContext();
                AppExtensionKt.setPref(context, Constants.NOTIFICATION_SOS_ALERT, isOnPushNotify);
                AppExtensionKt.setPref(context, Constants.NOTIFICATION_ZONE_ALERT, isOnZoneAlert);
                onBackPressed();
            }
        });
        activitySettingNotificationBinding.onOffSwitchPushNotification.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                Intrinsics.checkNotNullParameter(this, "this$0");
                getCheckedPushNotificationInformation(b);
            }
        });
        activitySettingNotificationBinding.onOffSwitchZoneAlert.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                Intrinsics.checkNotNullParameter(this, "this$0");
                getCheckedPushNotificationZoneAlert(b);
            }
        });
    }

    private void getCheckedPushNotificationZoneAlert(boolean z) {
        if (z) {
            this.isOnZoneAlert = true;
            ((ActivitySettingNotificationBinding) getMBinding()).onOffSwitchZoneAlert.setChecked(true);
        } else if (!z) {
            this.isOnZoneAlert = false;
            AppExtensionKt.setPref((Context) this, Constants.NOTIFICATION_ZONE_ALERT, false);
            ((ActivitySettingNotificationBinding) getMBinding()).onOffSwitchZoneAlert.setChecked(false);
        }
    }

    private  void getCheckedPushNotificationInformation(boolean z) {
        if (z) {
            this.isOnPushNotify = true;
            AppExtensionKt.setPref((Context) this, Constants.NOTIFICATION_SOS_ALERT, true);
            ((ActivitySettingNotificationBinding) getMBinding()).onOffSwitchPushNotification.setChecked(true);
        } else if (!z) {
            this.isOnPushNotify = false;
            AppExtensionKt.setPref((Context) this, Constants.NOTIFICATION_SOS_ALERT, false);
            ((ActivitySettingNotificationBinding) getMBinding()).onOffSwitchPushNotification.setChecked(false);
        }
    }


}
