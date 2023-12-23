package com.app.gpsphonelocator_new.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.app.gpsphonelocator_new.R;
import com.app.gpsphonelocator_new.database.RTDB_DEFINE;
import com.app.gpsphonelocator_new.databinding.ActivityShareMyLocationBinding;
import com.app.gpsphonelocator_new.phone.util.AppAuthen;
import com.app.gpsphonelocator_new.phone.util.AppUserSingleton;
import com.app.gpsphonelocator_new.phone.util.Constants;
import com.app.gpsphonelocator_new.common.Common;
import com.app.gpsphonelocator_new.common.CustomToast;
import com.app.gpsphonelocator_new.common.ExtensionKt;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;


public final class ShareMyLocationActivity extends BaseActivity<ActivityShareMyLocationBinding> {
    private final Lazy firebaseUser$delegate = LazyKt.lazy(new Function0<Object>() {

        @Override
        public Object invoke() {
            return AppAuthen.getInstance().getCurrentUser();
        }
    });
    private String securityCode;



    public static final  ActivityShareMyLocationBinding access$getMBinding(ShareMyLocationActivity shareMyLocationActivity) {
        return (ActivityShareMyLocationBinding) shareMyLocationActivity.getMBinding();
    }

    private final AppAuthen.AuthUser getFirebaseUser() {
        return (AppAuthen.AuthUser) this.firebaseUser$delegate.getValue();
    }


    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
//        listenerUser();
    }


    public void onStart() {
        super.onStart();
        checkBattery();
    }

    @SuppressLint("WrongConstant")
    private final void checkBattery() {
        ConstraintLayout constraintLayout = ((ActivityShareMyLocationBinding) getMBinding()).ctBattery;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "ctBattery");
        constraintLayout.setVisibility(ExtensionKt.isIgnoringBatteryOptimizations(this) ^ true ? 0 : 8);
    }

    private final void initView() {
        ActivityShareMyLocationBinding activityShareMyLocationBinding = (ActivityShareMyLocationBinding) getMBinding();
        TextView textView = activityShareMyLocationBinding.tvCodeShare;
        AppAuthen.AuthUser firebaseUser = getFirebaseUser();
        String str = null;
        textView.setText(firebaseUser != null ? firebaseUser.uid : null);
        AppAuthen.AuthUser firebaseUser2 = getFirebaseUser();
        if (firebaseUser2 != null) {
            str = firebaseUser2.uid;
        }
        this.securityCode = str;
        ImageView imageView = activityShareMyLocationBinding.imgBack;
        Intrinsics.checkNotNullExpressionValue(imageView, "imgBack");
        ExtensionKt.setOnSingleClickListener(imageView, new Function1<View, Unit>() {
            @Override
            public Unit invoke(View view) {
                onBackPressed();
                return Unit.INSTANCE;
            }
        });
        TextView textView2 = activityShareMyLocationBinding.tvCodeShare;
        Intrinsics.checkNotNullExpressionValue(textView2, "tvCodeShare");
        ExtensionKt.setOnSingleClickListener(textView2, new Function1<View, Unit>() {
            @Override
            public Unit invoke(View view) {
                ExtensionKt.copyText(ShareMyLocationActivity.this, activityShareMyLocationBinding.tvCodeShare.getText().toString());
                CustomToast.Companion.customToast(getString(R.string.custom_toast_share_my_location_Copied), ShareMyLocationActivity.this);
                return Unit.INSTANCE;
            }
        });
        ConstraintLayout constraintLayout = activityShareMyLocationBinding.ctBattery;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "ctBattery");
        ExtensionKt.setOnSingleClickListener(constraintLayout, new Function1<View, Unit>() {
            @Override
            public Unit invoke(View view) {
                startActivity(new Intent("android.settings.IGNORE_BATTERY_OPTIMIZATION_SETTINGS"));
                return Unit.INSTANCE;

            }
        });
        activityShareMyLocationBinding.switchTrack.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Intrinsics.checkNotNullParameter(ShareMyLocationActivity.this, "this$0");
                if (b) {
                    CustomToast.Companion.customToast(getString(R.string.custom_toast_this_device_Live_Sharing_On), ShareMyLocationActivity.this);
//                    DatabaseReference child = FirebaseDatabase.getInstance().getReference().child(RTDB_DEFINE.TABLE_USER);
//                    AppAuthen.AuthUser firebaseUser = ShareMyLocationActivity.this.getFirebaseUser();
//                    Intrinsics.checkNotNull(firebaseUser);
//                    child.child(firebaseUser.uid).child("share").setValue("ON");
                } else {
                    CustomToast.Companion.customToast(getString(R.string.custom_toast_this_device_Live_Sharing_Stopped), ShareMyLocationActivity.this);
//                    DatabaseReference child2 = FirebaseDatabase.getInstance().getReference().child(RTDB_DEFINE.TABLE_USER);
//                    AppAuthen.AuthUser firebaseUser2 = ShareMyLocationActivity.this.getFirebaseUser();
//                    Intrinsics.checkNotNull(firebaseUser2);
//                    child2.child(firebaseUser2.uid).child("share").setValue("OFF");
                }
                AppUserSingleton.getInstance().setShareLive(Boolean.valueOf(b));
                Common.Companion.setCheckShare(b);
            }
        });
        activityShareMyLocationBinding.imgQrCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intrinsics.checkNotNullParameter(this, "this$0");
                Intent intent = new Intent(getApplicationContext(), ShareMyLocationQRCodeActivity.class);
                intent.putExtra(Constants.SECURITY_CODE, securityCode);
                startActivity(intent);
            }
        });
    }



//    private final void listenerUser() {
//        DatabaseReference child = FirebaseDatabase.getInstance().getReference().child(RTDB_DEFINE.TABLE_USER);
//        AppAuthen.AuthUser firebaseUser = getFirebaseUser();
//        Intrinsics.checkNotNull(firebaseUser);
//        child.child(firebaseUser.uid).addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//
//                Intrinsics.checkNotNullParameter(dataSnapshot, "snapshot");
//                Object value = dataSnapshot.child("share").getValue();
//                if (value != null) {
//                    ShareMyLocationActivity.access$getMBinding(ShareMyLocationActivity.this).switchTrack.setChecked(!Intrinsics.areEqual(value, (Object) "OFF"));
//                } else {
//                    ShareMyLocationActivity.access$getMBinding(ShareMyLocationActivity.this).switchTrack.setChecked(false);
//                }
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                Intrinsics.checkNotNullParameter(databaseError, "error");
//            }
//        });
//    }

    public ActivityShareMyLocationBinding getViewBinding() {
        ActivityShareMyLocationBinding inflate = ActivityShareMyLocationBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        return inflate;
    }




}
