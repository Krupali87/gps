package com.app.gpsphonelocator_new.activity;

import android.widget.FrameLayout;

import com.app.gpsphonelocator_new.extensions.AppExtensionKt;
import com.app.gpsphonelocator_new.phone.callback.CallBack;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;


public final class SetAvatarActivity$bindEvent$1 implements CallBack.CallBackAvatar {
    final /* synthetic */ SetAvatarActivity this$0;

    SetAvatarActivity$bindEvent$1(SetAvatarActivity setAvatarActivity) {
        this.this$0 = setAvatarActivity;
    }

    public void selectAvatar(int i, int i2) {

        this.this$0.getAvatarAdapter().checkSelectView(i);
        this.this$0.setAvatar(i);
    }
}
