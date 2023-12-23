package com.app.gpsphonelocator_new.phone.util;

import android.os.SystemClock;
import android.view.View;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;


public final class SafeOnClickListener implements View.OnClickListener {
    private long lastClickTime;
    private Function1<? super View, Unit> onSafeClick;

    public final Function1<View, Unit> getOnSafeClick() {
        return (Function1<View, Unit>) this.onSafeClick;
    }

    public final void setOnSafeClick(Function1<? super View, Unit> function1) {
        this.onSafeClick = function1;
    }

    public void onClick(View view) {
        if (SystemClock.elapsedRealtime() - this.lastClickTime >= 1000) {
            this.lastClickTime = SystemClock.elapsedRealtime();
            Function1<? super View, Unit> function1 = this.onSafeClick;
            if (function1 != null) {
                function1.invoke(view);
            }
        }
    }
}
