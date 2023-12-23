package com.app.gpsphonelocator_new.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.app.gpsphonelocator_new.R;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;


public final class CustomToast {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    public static Toast currentToast;

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Toast getCurrentToast() {
            return CustomToast.currentToast;
        }

        public final void setCurrentToast(Toast toast) {
            CustomToast.currentToast = toast;
        }

        @SuppressLint("WrongConstant")
        public final void customToast(String str, Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (getCurrentToast() != null) {
                Toast currentToast = getCurrentToast();
                Intrinsics.checkNotNull(currentToast);
                currentToast.cancel();
            }
            View inflate = LayoutInflater.from(context).inflate(R.layout.custom_toast, (ViewGroup) null);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(context)\n          …ayout.custom_toast, null)");
            setCurrentToast(new Toast(context.getApplicationContext()));
            Toast currentToast2 = getCurrentToast();
            Intrinsics.checkNotNull(currentToast2);
            currentToast2.setGravity(80, 0, 20);
            Toast currentToast3 = getCurrentToast();
            Intrinsics.checkNotNull(currentToast3);
            currentToast3.setDuration(0);
            Toast currentToast4 = getCurrentToast();
            Intrinsics.checkNotNull(currentToast4);
            currentToast4.setView(inflate);
            View findViewById = inflate.findViewById(R.id.text);
            Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
            ((TextView) findViewById).setText(str);
            Toast currentToast5 = getCurrentToast();
            Intrinsics.checkNotNull(currentToast5);
            currentToast5.show();
            inflate.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (CustomToast.Companion.getCurrentToast() == null) {
                        return false;
                    }
                    Toast currentToast = CustomToast.Companion.getCurrentToast();
                    Intrinsics.checkNotNull(currentToast);
                    currentToast.cancel();
                    return true;

                }
            });
        }


    }
}
