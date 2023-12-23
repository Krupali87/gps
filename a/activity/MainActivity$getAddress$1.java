package com.app.gpsphonelocator_new.activity;

import android.location.Address;
import android.location.Geocoder;
import android.util.Log;

import com.app.gpsphonelocator_new.common.InforSaved;
import java.util.List;
import java.util.Locale;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

public final class MainActivity$getAddress$1 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private final double lat;
    private final double lng;
    private final InforSaved user;
    private int label;
    private final MainActivity this$0;

    public MainActivity$getAddress$1(MainActivity mainActivity, double lat, double lng, InforSaved user, Continuation<?> continuation) {
        this.this$0 = mainActivity;
        this.lat = lat;
        this.lng = lng;
        this.user = user;
    }

    public MainActivity$getAddress$1 create(Object obj, Continuation<?> continuation) {
        return new MainActivity$getAddress$1(this.this$0, lat, lng, user, continuation);
    }

    public Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public Object invokeSuspend(Object obj) {
        if (this.label == 0) {
            try {
                List<Address> fromLocation = new Geocoder(this.this$0, Locale.getDefault()).getFromLocation(lat, lng, 1);
                boolean z = true;
                if (fromLocation != null && !fromLocation.isEmpty()) {
                    String addressLine = fromLocation.get(0).getAddressLine(0);
                    if (addressLine != null) {
                        user.setAddress(addressLine);
                        if (addressLine.length() <= 0) {
                            z = false;
                        }
                        if (z) {
                            MainActivity mainActivity = this.this$0;

                        }
                    }
                }
            } catch (Exception e) {
                Log.d("TAG", e.toString());
            }
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }


}