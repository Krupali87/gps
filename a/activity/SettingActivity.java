package com.app.gpsphonelocator_new.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.app.gpsphonelocator_new.databinding.ActivitySettingBinding;
import com.app.gpsphonelocator_new.extensions.AppExtensionKt;

import kotlin.jvm.internal.Intrinsics;

public final class SettingActivity extends BaseActivity<ActivitySettingBinding> {

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public ActivitySettingBinding getViewBinding() {
        ActivitySettingBinding inflate = ActivitySettingBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        return inflate;
    }

    private final void initView() {
        ActivitySettingBinding activitySettingBinding = (ActivitySettingBinding) getMBinding();
        activitySettingBinding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intrinsics.checkNotNullParameter(this, "this$0");
                onBackPressed();
            }
        });
        activitySettingBinding.viewSetAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intrinsics.checkNotNullParameter(this, "this$0");
                AppExtensionKt.showActivity$default(getApplicationContext(), SetAvatarActivity.class, (Bundle) null, 4, (Object) null);
                
            }
        });
        activitySettingBinding.viewSettingNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intrinsics.checkNotNullParameter(this, "this$0");
                AppExtensionKt.showActivity$default(getApplicationContext(), SettingNotificationActivity.class, (Bundle) null, 4, (Object) null);
            }
        });
        activitySettingBinding.tvLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intrinsics.checkNotNullParameter(this, "this$0");
                startActivity(new Intent(getApplicationContext(), LanguageSettingActivity.class));
            }
        });

    }

  

    
}
