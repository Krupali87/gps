package com.app.gpsphonelocator_new.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.app.gpsphonelocator_new.R;
import com.app.gpsphonelocator_new.database.RTDB_DEFINE;
import com.app.gpsphonelocator_new.databinding.ActivitySosBinding;
import com.app.gpsphonelocator_new.phone.util.AppAuthen;
import com.app.gpsphonelocator_new.common.ExtensionKt;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;


public final class SOSActivity extends BaseActivity<ActivitySosBinding> {

    public String address = "";
    private boolean isCurrentSOS;



    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
//        bindComponent();


    }


    @SuppressLint("WrongConstant")
    public void onResume() {
        super.onResume();
        ((ActivitySosBinding) getMBinding()).layoutAddFriend.setVisibility(0);
    }

//    private final void bindComponent() {
//     // getSOS();
//
//    }
//
////    private final void getSOS() {
////        FirebaseApp.initializeApp(this);
////        AppAuthen.AuthUser currentUser = AppAuthen.getInstance().getCurrentUser();
//////        DatabaseReference child = FirebaseDatabase.getInstance().getReference().child(RTDB_DEFINE.TABLE_USER);
//////        Intrinsics.checkNotNull(currentUser);
//////        DatabaseReference child2 = child.child(currentUser.uid);
////      //  Intrinsics.checkNotNullExpressionValue(child2, "getInstance().reference.…E_USER).child(user!!.uid)");
////        child2.addValueEventListener(new ValueEventListener() {
////            @Override
////            public void onDataChange(DataSnapshot dataSnapshot) {
////
////                Intrinsics.checkNotNullParameter(dataSnapshot, "snapshot");
////                boolean parseBoolean = Boolean.parseBoolean(String.valueOf(dataSnapshot.child("sos").getValue()));
////                String valueOf = String.valueOf(dataSnapshot.child("sos_msg").getValue());
////                address = String.valueOf(dataSnapshot.child("address").getValue());
////                updateSOSUI(parseBoolean, valueOf);
////            }
////
////            @Override
////            public void onCancelled(DatabaseError databaseError) {
////                Intrinsics.checkNotNullParameter(databaseError, "error");
////            }
////        });
////    }


    @SuppressLint("WrongConstant")
    public final void updateSOSUI(boolean z, String str) {
        this.isCurrentSOS = z;
        getMBinding().txtAddress.setText(this.address);
        if (z) {
            getMBinding().sosImg.setVisibility(8);
            getMBinding().sosGif.setVisibility(0);
            getMBinding().editTextSmsMgs.setText(str);
            getMBinding().editTextSmsMgs.setEnabled(false);
            getMBinding().imgPower.setImageResource(R.drawable.ic_power);
            getMBinding().btnSos.setBackgroundResource(R.drawable.bg_btn_offsos);
            getMBinding().txtSentBtn.setText(R.string.sos_btn_stop);
            return;
        }
        getMBinding().sosGif.setVisibility(8);
        getMBinding().sosImg.setVisibility(0);
        getMBinding().editTextSmsMgs.setText(R.string.sos_mgs_example);
        getMBinding().editTextSmsMgs.setEnabled(true);
        getMBinding().imgPower.setImageResource(R.drawable.ic_send);
        getMBinding().btnSos.setBackgroundResource(R.drawable.bg_btn_sendsos);
        getMBinding().txtSentBtn.setText(R.string.sos_btn_send);

    }

    private final void initView() {
        ImageView imageView = ((ActivitySosBinding) getMBinding()).imgBack;
        Intrinsics.checkNotNullExpressionValue(imageView, "imgBack");
        ExtensionKt.setOnSingleClickListener(imageView, new Function1<View, Unit>() {
            @Override
            public Unit invoke(View view) {
                onBackPressed();
                return Unit.INSTANCE;
            }
        });
        ((ActivitySosBinding) getMBinding()).btnSos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intrinsics.checkNotNullParameter(this, "this$0");
                if (isCurrentSOS) {
                    isCurrentSOS = false;
                    AppAuthen.AuthUser currentUser = AppAuthen.getInstance().getCurrentUser();
               //     DatabaseReference child = FirebaseDatabase.getInstance().getReference().child(RTDB_DEFINE.TABLE_USER);
                    Intrinsics.checkNotNull(currentUser);
                  //  child.child(currentUser.uid).child("sos").setValue(false);
                } else {
                    isCurrentSOS = true;
                    AppAuthen.AuthUser currentUser2 = AppAuthen.getInstance().getCurrentUser();
                   // DatabaseReference child2 = FirebaseDatabase.getInstance().getReference().child(RTDB_DEFINE.TABLE_USER);
                  //  Intrinsics.checkNotNull(currentUser2);
                  //  child2.child(currentUser2.uid).child("sos").setValue(true);
                  //  FirebaseDatabase.getInstance().getReference().child(RTDB_DEFINE.TABLE_USER).child(currentUser2.uid).child("sos_msg").setValue(((ActivitySosBinding) SOSActivity.this.getMBinding()).editTextSmsMgs.getText().toString());
                }
               updateSOSUI(SOSActivity.this.isCurrentSOS, ((ActivitySosBinding) SOSActivity.this.getMBinding()).editTextSmsMgs.getText().toString());
            }
        });
    }


    public ActivitySosBinding getViewBinding() {
        ActivitySosBinding inflate = ActivitySosBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        return inflate;
    }

    @SuppressLint("WrongConstant")
    public void showLoading() {
        super.showLoading();
        FrameLayout frameLayout = ((ActivitySosBinding) getMBinding()).frLoading;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "mBinding.frLoading");
        frameLayout.setVisibility(0);
    }

    @SuppressLint("WrongConstant")
    public void hideLoading() {
        super.hideLoading();
        FrameLayout frameLayout = ((ActivitySosBinding) getMBinding()).frLoading;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "mBinding.frLoading");
        frameLayout.setVisibility(8);
    }


}
