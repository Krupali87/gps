package com.app.gpsphonelocator_new.phone.view.dialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

import com.app.gpsphonelocator_new.R;
import com.app.gpsphonelocator_new.database.RTDB_DEFINE;
import com.app.gpsphonelocator_new.database.UserDatabase;
import com.app.gpsphonelocator_new.database.UserTracked;
import com.app.gpsphonelocator_new.database.UserTrackedDao;
import com.app.gpsphonelocator_new.databinding.DialogEditFriendBinding;
import com.app.gpsphonelocator_new.phone.util.AppAuthen;
import com.app.gpsphonelocator_new.phone.util.Constants;
import com.app.gpsphonelocator_new.phone.util.DataExKt;
import com.app.gpsphonelocator_new.common.CustomToast;
import com.app.gpsphonelocator_new.common.InforSaved;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;


public final class DialogEditFriend extends Dialog {
    /* access modifiers changed from: private */
    public AppAuthen.AuthUser appUser;
    public DialogEditFriendBinding binding;
    /* access modifiers changed from: private */
    public final Context ctx;
    private final Function0<Unit> editFriend;
    /* access modifiers changed from: private */
    public final InforSaved userInfo;
    /* access modifiers changed from: private */
    public int x;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DialogEditFriend(Context context, InforSaved inforSaved, Function0<Unit> function0) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "ctx");
        Intrinsics.checkNotNullParameter(inforSaved, "userInfo");
        Intrinsics.checkNotNullParameter(function0, "editFriend");
        this.ctx = context;
        this.userInfo = inforSaved;
        this.editFriend = function0;
        init();
    }

    public final DialogEditFriendBinding getBinding() {
        DialogEditFriendBinding dialogEditFriendBinding = this.binding;
        if (dialogEditFriendBinding != null) {
            return dialogEditFriendBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(DialogEditFriendBinding dialogEditFriendBinding) {
        Intrinsics.checkNotNullParameter(dialogEditFriendBinding, "<set-?>");
        this.binding = dialogEditFriendBinding;
    }

    private final void init() {
        this.appUser = AppAuthen.getInstance().getCurrentUser();
        DialogEditFriendBinding inflate = DialogEditFriendBinding.inflate(LayoutInflater.from(this.ctx));
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.from(ctx))");
        setBinding(inflate);
        setContentView(getBinding().getRoot());
        Window window = getWindow();
        if (window != null) {
            window.setLayout(-1, -2);
            window.setGravity(17);
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        setCancelable(true);
        DialogEditFriendBinding binding2 = getBinding();
        binding2.imgClosePopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intrinsics.checkNotNullParameter(this, "this$0");
               dismiss();
            }
        });
        binding2.etName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    view.setBackgroundResource(R.drawable.bg_input_select_dialog);
                } else {
                    view.setBackgroundResource(R.drawable.bg_input_dialog);
                }
            }
        });
        binding2.etPhoneNumber.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    view.setBackgroundResource(R.drawable.bg_input_select_dialog);
                } else {
                    view.setBackgroundResource(R.drawable.bg_input_dialog);
                }
            }
        });
        binding2.btnEditFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intrinsics.checkNotNullParameter(this, "this$0");
                DataExKt.logEvent(ctx, Constants.INSTANCE.getSave_edit_account2());
                handleFireBase();
                dismiss();
                editFriend.invoke();
            }
        });
        binding2.etName.setText(this.userInfo.getnickname());
        binding2.etPhoneNumber.setText(this.userInfo.getphone());
    }


    @SuppressLint("WrongConstant")
    private final void handleFireBase() {
        String obj = StringsKt.trim((CharSequence) getBinding().etName.getText().toString()).toString();
        String obj2 = StringsKt.trim((CharSequence) getBinding().etPhoneNumber.getText().toString()).toString();
        String str = this.userInfo.getlocatepin();
        CharSequence charSequence = obj;
        if (!StringsKt.isBlank(charSequence)) {
            if (!(charSequence.length() == 0)) {
                getBinding().frLoading.setVisibility(0);
                FirebaseDatabase.getInstance().getReference().child(RTDB_DEFINE.TABLE_USER).child(str).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        final String $nickname=null;
                        final  String $phoneNumber=null;
                        final String $securityCode=null;
                        final DialogEditFriend dialogEditFriend=null;
                        Intrinsics.checkNotNullParameter(dataSnapshot, "i");
                        if (dataSnapshot.getValue() == null) {
                            DialogEditFriend.this.getBinding().frLoading.setVisibility(8);
                            CustomToast.Companion.customToast(ctx.getString(R.string.custom_toast_add_track_account_do_not_exist), DialogEditFriend.this.ctx);
                            return;
                        }
                        String.valueOf(dataSnapshot.child(RTDB_DEFINE.TBL_USER.INSTANCE.getEMAIL()).getValue());
                        String str = DialogEditFriend.this.userInfo.getchecked();
                        Map hashMap = new HashMap();
                        hashMap.put(RTDB_DEFINE.TBL_SAVE.INSTANCE.getLOCATEUID(), String.valueOf(dataSnapshot.child(RTDB_DEFINE.TBL_USER.INSTANCE.getUID()).getValue()));
                        hashMap.put(RTDB_DEFINE.TBL_SAVE.INSTANCE.getLOCATEPIN(), $securityCode);
                        hashMap.put(RTDB_DEFINE.TBL_SAVE.INSTANCE.getNICKNAME(), $nickname);
                        hashMap.put(RTDB_DEFINE.TBL_SAVE.INSTANCE.getCHECKED(), str);
                        hashMap.put(RTDB_DEFINE.TBL_SAVE.INSTANCE.getPHOTOURI(), String.valueOf(dataSnapshot.child(RTDB_DEFINE.TBL_SAVE.INSTANCE.getPHOTOURI()).getValue()));
                        hashMap.put(RTDB_DEFINE.TBL_SAVE.INSTANCE.getUSERNAME(), String.valueOf(dataSnapshot.child(RTDB_DEFINE.TBL_SAVE.INSTANCE.getUSERNAME()).getValue()));
                        hashMap.put(RTDB_DEFINE.TBL_SAVE.INSTANCE.getPHONE(), $phoneNumber);
                        hashMap.put(RTDB_DEFINE.TBL_SAVE.INSTANCE.getAVATAR(), String.valueOf(dataSnapshot.child(RTDB_DEFINE.TBL_SAVE.INSTANCE.getAVATAR()).getValue()));
                        hashMap.put(RTDB_DEFINE.TBL_SAVE.INSTANCE.getADDRESS(), String.valueOf(dataSnapshot.child(RTDB_DEFINE.TBL_SAVE.INSTANCE.getADDRESS()).getValue()));
                        hashMap.put(RTDB_DEFINE.TBL_SAVE.INSTANCE.getADDED_TIME(), DialogEditFriend.this.userInfo.getAddedTime());
                        UserTracked userTracked = new UserTracked(0, $nickname, $phoneNumber, $securityCode, str);
                        DatabaseReference child = FirebaseDatabase.getInstance().getReference().child(RTDB_DEFINE.TABLE_SAVE_MAIL);
                        AppAuthen.AuthUser access$getAppUser$p = DialogEditFriend.this.appUser;
                        Intrinsics.checkNotNull(access$getAppUser$p);
                        DatabaseReference child2 = child.child(access$getAppUser$p.uid).child($securityCode);
                        Intrinsics.checkNotNullExpressionValue(child2, "getInstance().reference.…     .child(securityCode)");
                        child2.updateChildren(hashMap).addOnCompleteListener(new DialogEditFriend$handleFireBase$1$$ExternalSyntheticLambda0(DialogEditFriend.this, userTracked));
                        if (DialogEditFriend.this.x == 2) {
                            CustomToast.Companion.customToast(ctx.getString(R.string.custom_toast_add_track_no_registration_in_the_Serve), DialogEditFriend.this.ctx);
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Intrinsics.checkNotNullParameter(databaseError, "error");
                        CustomToast.Companion.customToast(databaseError.getMessage(), DialogEditFriend.this.ctx);
                    }
                });
                return;
            }
        }
        CustomToast.Companion.customToast(this.ctx.getString(R.string.custom_toast_add_track_Nickname_empty), this.ctx);
    }

    private final boolean isExistAccount(String r3) {
        UserTrackedDao userDAO;
        UserDatabase companion = UserDatabase.Companion.getInstance(this.ctx);
        return ((companion == null || (userDAO = companion.userDAO()) == null) ? null : userDAO.getUser(r3)) != null;

    }


    public final void checkEmailsAndSubs() {
        Ref.IntRef intRef = new Ref.IntRef();
        try {
            DatabaseReference child = FirebaseDatabase.getInstance().getReference().child(RTDB_DEFINE.TABLE_SAVE_MAIL);
            AppAuthen.AuthUser authUser = this.appUser;
            Intrinsics.checkNotNull(authUser);
            child.child(authUser.uid).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    final Ref.IntRef $count=null;
                    Intrinsics.checkNotNullParameter(dataSnapshot, "snapshot");
                    for (DataSnapshot next : dataSnapshot.getChildren()) {
                        $count.element++;
                    }
                    if ($count.element > 0) {
                        DatabaseReference child = FirebaseDatabase.getInstance().getReference().child(RTDB_DEFINE.TABLE_USER);
                        AppAuthen.AuthUser access$getAppUser$p = DialogEditFriend.this.appUser;
                        Intrinsics.checkNotNull(access$getAppUser$p);
                        child.child(access$getAppUser$p.uid).child(RTDB_DEFINE.TBL_USER.INSTANCE.getSAVEDEMAIL()).setValue(String.valueOf($count.element));
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
