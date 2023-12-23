package com.app.gpsphonelocator_new.activity;

import android.location.Address;
import android.location.Geocoder;
import java.util.List;
import java.util.Locale;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;


final class SetMailAndCodeActivity$syncAddress$1 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final double $lat;
    final double $lng;
    int label;
    final  SetMailAndCodeActivity this$0;


    SetMailAndCodeActivity$syncAddress$1(SetMailAndCodeActivity setMailAndCodeActivity, double d, double d2, Continuation<?> continuation) {

        this.this$0 = setMailAndCodeActivity;
        this.$lat = d;
        this.$lng = d2;
    }


    public final SetMailAndCodeActivity$syncAddress$1 create(Object obj, Continuation<?> continuation) {
        return new SetMailAndCodeActivity$syncAddress$1(this.this$0, this.$lat, this.$lng, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SetMailAndCodeActivity$syncAddress$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }


    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        //ResultKt.throwOnFailure(obj);
        try {
            List<Address> fromLocation = new Geocoder(this.this$0, Locale.getDefault()).getFromLocation(this.$lat, this.$lng, 1);
            boolean z = true;
            if (fromLocation == null || !(!fromLocation.isEmpty())) {
                z = false;
            }
            if (z) {
                SetMailAndCodeActivity setMailAndCodeActivity = this.this$0;
                String addressLine = fromLocation.get(0).getAddressLine(0);
                Intrinsics.checkNotNullExpressionValue(addressLine, "addressList[0].getAddressLine(0)");
                setMailAndCodeActivity.setAddrress(addressLine);
            }
        } catch (Exception unused) {
            this.this$0.setAddrress("Address not detected");
        }
        return Unit.INSTANCE;
    }

}
