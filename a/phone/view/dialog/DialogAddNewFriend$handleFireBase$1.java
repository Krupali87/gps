//package com.app.gpsphonelocator_new.phone.view.dialog;
//
//
//import android.annotation.SuppressLint;
//
//import com.app.gpsphonelocator_new.R;
//import com.app.gpsphonelocator_new.database.RTDB_DEFINE;
//import com.app.gpsphonelocator_new.database.UserDatabase;
//import com.app.gpsphonelocator_new.database.UserTracked;
//import com.app.gpsphonelocator_new.database.UserTrackedDao;
//import com.app.gpsphonelocator_new.phone.util.AppAuthen;
//import com.app.gpsphonelocator_new.common.CustomToast;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import kotlin.Metadata;
//import kotlin.jvm.internal.Intrinsics;
//
//
//public final class DialogAddNewFriend$handleFireBase$1 implements ValueEventListener {
//    final /* synthetic */ String $nickname;
//    final /* synthetic */ String $phoneNumber;
//    final /* synthetic */ String $securityCode;
//    final /* synthetic */ DialogAddNewFriend this$0;
//
//    DialogAddNewFriend$handleFireBase$1(DialogAddNewFriend dialogAddNewFriend, String str, String str2, String str3) {
//        this.this$0 = dialogAddNewFriend;
//        this.$securityCode = str;
//        this.$nickname = str2;
//        this.$phoneNumber = str3;
//    }
//
//    @SuppressLint("WrongConstant")
//    public void onDataChange(DataSnapshot dataSnapshot) {
//
//    }
//
//    /* access modifiers changed from: private */
//    @SuppressLint("WrongConstant")
//    public static final void onDataChange$lambda$0(DialogAddNewFriend dialogAddNewFriend, UserTracked userTracked, Task task) {
//        UserTrackedDao userDAO;
//        Intrinsics.checkNotNullParameter(dialogAddNewFriend, "this$0");
//        Intrinsics.checkNotNullParameter(userTracked, "$user");
//        Intrinsics.checkNotNullParameter(task, "tasks");
//        if (task.isSuccessful()) {
//            UserDatabase instance = UserDatabase.Companion.getInstance(dialogAddNewFriend.ctx);
//            if (!(instance == null || (userDAO = instance.userDAO()) == null)) {
//                userDAO.insert(userTracked);
//            }
//            CustomToast.Companion.customToast(dialogAddNewFriend.ctx.getString(R.string.custom_toast_add_track_Saved_Successfully), dialogAddNewFriend.ctx);
//            dialogAddNewFriend.checkEmailsAndSubs();
//            dialogAddNewFriend.dismiss();
//            return;
//        }
//        dialogAddNewFriend.getBinding().frLoading.setVisibility(8);
//        CustomToast.Companion.customToast(dialogAddNewFriend.ctx.getString(R.string.custom_toast_add_track_Something_Wrong), dialogAddNewFriend.ctx);
//    }
//
//    public void onCancelled(DatabaseError databaseError) {
//
//    }
//}
