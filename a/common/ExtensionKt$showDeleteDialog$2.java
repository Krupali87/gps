package com.app.gpsphonelocator_new.common;

import android.app.Dialog;
import android.view.View;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

final class ExtensionKt$showDeleteDialog$2 implements Function1<View, Unit> {
    final  Dialog $dialog;
    final Function0<Unit> $onCanceled;


    ExtensionKt$showDeleteDialog$2(Function0<Unit> function0, Dialog dialog) {

        this.$onCanceled = function0;
        this.$dialog = dialog;
    }



    public final Unit invoke(View view) {
        Function0<Unit> function0 = this.$onCanceled;
        if (function0 != null) {
            function0.invoke();
        }
        this.$dialog.dismiss();
        return Unit.INSTANCE;
    }
}
