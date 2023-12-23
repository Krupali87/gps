package com.app.gpsphonelocator_new.phone.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.app.gpsphonelocator_new.R;

public class CustomToast {
    /* access modifiers changed from: private */
    public static Toast currentToast;

    public static void customToast(String str, Context context) {
        Toast toast = currentToast;
        if (toast != null) {
            toast.cancel();
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.custom_toast, (ViewGroup) null);
        Toast toast2 = new Toast(context.getApplicationContext());
        currentToast = toast2;
        toast2.setGravity(80, 0, 20);
        currentToast.setDuration(0);
        currentToast.setView(inflate);
        ((TextView) inflate.findViewById(R.id.text)).setText(str);
        currentToast.show();
        if (inflate != null) {
            inflate.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (CustomToast.currentToast == null) {
                        return false;
                    }
                    CustomToast.currentToast.cancel();
                    return true;
                }
            });
        }
    }
}
