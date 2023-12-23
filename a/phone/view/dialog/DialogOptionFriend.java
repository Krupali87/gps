package com.app.gpsphonelocator_new.phone.view.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

import com.app.gpsphonelocator_new.R;
import com.app.gpsphonelocator_new.database.RTDB_DEFINE;
import com.app.gpsphonelocator_new.database.UserDatabase;
import com.app.gpsphonelocator_new.database.UserTracked;
import com.app.gpsphonelocator_new.database.UserTrackedDao;
import com.app.gpsphonelocator_new.databinding.DialogConfirmDeleteBinding;
import com.app.gpsphonelocator_new.databinding.DialogOptionFriendBinding;
import com.app.gpsphonelocator_new.phone.util.AppAuthen;
import com.app.gpsphonelocator_new.common.ExtensionKt;
import com.app.gpsphonelocator_new.common.InforSaved;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;


public final class DialogOptionFriend extends Dialog {
    public DialogOptionFriendBinding binding;
    /* access modifiers changed from: private */
    public final Activity ctx;
    private boolean isAllowToTrack;
    private Function1<? super InforSaved, Unit> onEditClicked;
    private Function0<Unit> onSwitchTracked;
    private final InforSaved user;

    DialogOptionFriend dialogOptionFriend;
    DialogOptionFriendBinding dialogOptionFriendBinding;

    AlertDialog alertDialog;
    public DialogOptionFriend(Activity activity, InforSaved inforSaved) {
        super(activity);
        Intrinsics.checkNotNullParameter(activity, "ctx");
        Intrinsics.checkNotNullParameter(inforSaved, "user");
        this.ctx = activity;
        this.user = inforSaved;
        init();
    }

    public final InforSaved getUser() {
        return this.user;
    }

    public final DialogOptionFriendBinding getBinding() {
        DialogOptionFriendBinding dialogOptionFriendBinding = this.binding;
        if (dialogOptionFriendBinding != null) {
            return dialogOptionFriendBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(DialogOptionFriendBinding dialogOptionFriendBinding) {
        Intrinsics.checkNotNullParameter(dialogOptionFriendBinding, "<set-?>");
        this.binding = dialogOptionFriendBinding;
    }

    public final boolean isAllowToTrack() {
        return this.isAllowToTrack;
    }

    public final void setAllowToTrack(boolean z) {
        this.isAllowToTrack = z;
    }

    public final Function1<InforSaved, Unit> getOnEditClicked() {
        return (Function1<InforSaved, Unit>) this.onEditClicked;
    }

    public final void setOnEditClicked(Function1<? super InforSaved, Unit> function1) {
        this.onEditClicked = function1;
    }

    public final Function0<Unit> getOnSwitchTracked() {
        return this.onSwitchTracked;
    }

    public final void setOnSwitchTracked(Function0<Unit> function0) {
        this.onSwitchTracked = function0;
    }

    private final void init() {
        UserTrackedDao userDAO;
        List<UserTracked> checkedFriends;
        DialogOptionFriendBinding inflate = DialogOptionFriendBinding.inflate(LayoutInflater.from(this.ctx));
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.from(ctx))");
        setBinding(inflate);
        setContentView(getBinding().getRoot());
        Window window = getWindow();
        if (window != null) {
            window.setLayout(-1, -2);
            window.setGravity(80);
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.getAttributes().windowAnimations = R.style.DialogTranslateIn;
        }
        setCancelable(true);
        UserDatabase instance = UserDatabase.Companion.getInstance(this.ctx);
        if (!(instance == null || (userDAO = instance.userDAO()) == null || (checkedFriends = userDAO.getCheckedFriends(this.user.getlocateuid())) == null)) {
            for (UserTracked checked : checkedFriends) {

            }
        }
        getBinding().imgSwitch.setImageResource(this.isAllowToTrack ? R.drawable.ic_switch_on : R.drawable.ic_switch_off);
        DialogOptionFriendBinding binding2 = getBinding();
        binding2.imgSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UserTrackedDao userDAO;
                Intrinsics.checkNotNullParameter(this, "this$0");
                Intrinsics.checkNotNullParameter(this, "$this_apply");
                dialogOptionFriend.isAllowToTrack = !dialogOptionFriend.isAllowToTrack;
                dialogOptionFriendBinding.imgSwitch.setImageResource(dialogOptionFriend.isAllowToTrack ? R.drawable.ic_switch_on : R.drawable.ic_switch_off);
                Function0<Unit> function0 = dialogOptionFriend.onSwitchTracked;
                if (function0 != null) {
                    function0.invoke();
                }
                UserDatabase instance = UserDatabase.Companion.getInstance(dialogOptionFriend.ctx);
                if (instance != null && (userDAO = instance.userDAO()) != null) {
                    userDAO.updateChecked(String.valueOf(dialogOptionFriend.isAllowToTrack), dialogOptionFriend.user.getlocateuid());
                }
            }
        });
        binding2.viewEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intrinsics.checkNotNullParameter(dialogOptionFriend, "this$0");
                Function1<? super InforSaved, Unit> function1 = dialogOptionFriend.onEditClicked;
                if (function1 != null) {
                    function1.invoke(dialogOptionFriend.user);
                }
            }
        });
        binding2.viewUnfriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intrinsics.checkNotNullParameter(dialogOptionFriend, "this$0");
                if (!dialogOptionFriend.isAllowToTrack) {
                    DialogConfirmDeleteBinding inflate = DialogConfirmDeleteBinding.inflate(LayoutInflater.from(dialogOptionFriend.ctx));
                    Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.from(ctx))");
                    AlertDialog show = new AlertDialog.Builder(dialogOptionFriend.ctx).setView(inflate.getRoot()).show();
                    Intrinsics.checkNotNullExpressionValue(show, "dialog");
                    ExtensionKt.initLayout$default(show, dialogOptionFriend.ctx, 0.0f, 2, (Object) null);
                    inflate.txtCancel.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            AlertDialog alertDialog=null;
                            alertDialog.dismiss();
                        }
                    });
                    inflate.txtDelete.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intrinsics.checkNotNullParameter(dialogOptionFriend, "this$0");
                            alertDialog.dismiss();
                            DatabaseReference child = FirebaseDatabase.getInstance().getReference().child(RTDB_DEFINE.TABLE_SAVE_MAIL);
                            String str = AppAuthen.getInstance().getCurrentUser().uid;
                            Intrinsics.checkNotNull(str);
                            child.child(str).child(dialogOptionFriend.user.getlocatepin()).removeValue();
                            DatabaseReference child2 = FirebaseDatabase.getInstance().getReference().child(RTDB_DEFINE.TABLE_USER);
                            String str2 = AppAuthen.getInstance().getCurrentUser().uid;
                            Intrinsics.checkNotNull(str2);
                            child2.child(str2).addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    UserTrackedDao userDAO;
                                    Intrinsics.checkNotNullParameter(dataSnapshot, "snapshot");
                                    int parseInt = Integer.parseInt(String.valueOf(dataSnapshot.child("savedemails").getValue()));
                                    DatabaseReference child = FirebaseDatabase.getInstance().getReference().child(RTDB_DEFINE.TABLE_USER);
                                    String str = AppAuthen.getInstance().getCurrentUser().uid;
                                    Intrinsics.checkNotNull(str);
                                    child.child(str).child("savedemails").setValue(String.valueOf(parseInt - 1));
                                    UserDatabase instance = UserDatabase.Companion.getInstance(DialogOptionFriend.this.ctx);
                                    if (!(instance == null || (userDAO = instance.userDAO()) == null)) {
                                        userDAO.deleteById(DialogOptionFriend.this.getUser().getlocatepin());
                                    }
                                    String string = DialogOptionFriend.this.ctx.getString(R.string.toast_tracked_user_adapter_Successfully);
                                    Intrinsics.checkNotNullExpressionValue(string, "ctx.getString(R.string.t…ser_adapter_Successfully)");
                                    ExtensionKt.showToast(DialogOptionFriend.this.ctx, string);
                                    DialogOptionFriend.this.dismiss();
                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {
                                    Intrinsics.checkNotNullParameter(databaseError, "error");
                                }
                            });
                        }
                    });
                    return;
                }
                ExtensionKt.showToast(dialogOptionFriend.ctx, dialogOptionFriend.ctx.getString(R.string.toast_tracked_user_adapter_Please_OFF) + ' ' + dialogOptionFriend.user.getnickname());
            }
        });
    }




}
