package com.app.gpsphonelocator_new.common;

import android.app.DatePickerDialog;
import android.widget.DatePicker;
import java.util.Calendar;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ExtensionKt$$ExternalSyntheticLambda0 implements DatePickerDialog.OnDateSetListener {
    public final /* synthetic */ Calendar f$0;
    public final /* synthetic */ Function1 f$1;

    public /* synthetic */ ExtensionKt$$ExternalSyntheticLambda0(Calendar calendar, Function1 function1) {
        this.f$0 = calendar;
        this.f$1 = function1;
    }

    public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        ExtensionKt.showDatePicker$lambda$3(this.f$0, this.f$1, datePicker, i, i2, i3);
    }
}
