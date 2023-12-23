package com.app.gpsphonelocator_new.phone.view.dialog;

import com.app.gpsphonelocator_new.database.UserTracked;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DialogEditFriend$handleFireBase$1$$ExternalSyntheticLambda0 implements OnCompleteListener {
    public final /* synthetic */ DialogEditFriend f$0;
    public final /* synthetic */ UserTracked f$1;

    public /* synthetic */ DialogEditFriend$handleFireBase$1$$ExternalSyntheticLambda0(DialogEditFriend dialogEditFriend, UserTracked userTracked) {
        this.f$0 = dialogEditFriend;
        this.f$1 = userTracked;
    }

    public final void onComplete(Task task) {
        DialogEditFriend$handleFireBase$1.onDataChange$lambda$0(this.f$0, this.f$1, task);
    }
}
