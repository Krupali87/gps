package com.app.gpsphonelocator_new.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;

import com.app.gpsphonelocator_new.R;
import com.app.gpsphonelocator_new.common.CustomToast;
import com.app.gpsphonelocator_new.common.ExtensionKt;
import com.app.gpsphonelocator_new.database.RTDB_DEFINE;
import com.app.gpsphonelocator_new.databinding.ActivitySetMailAndCodeBinding;
import com.app.gpsphonelocator_new.extensions.AppExtensionKt;
import com.app.gpsphonelocator_new.phone.service.GPSLocationService;
import com.app.gpsphonelocator_new.phone.util.AppAuthen;
import com.app.gpsphonelocator_new.phone.util.Constants;
import com.app.gpsphonelocator_new.phone.util.NetUtils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;


public final class SetMailAndCodeActivity extends BaseActivity<ActivitySetMailAndCodeBinding> {
    private boolean isKeyboardShow;
    private String inputMail = "";
    private String inputPrivateCode = "";
    private String lng = "";
    private String lat = "";
    private String addrress = "";

    public final String getInputMail() {
        return this.inputMail;
    }

    public final void setInputMail(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.inputMail = str;
    }

    public final String getInputPrivateCode() {
        return this.inputPrivateCode;
    }

    public final void setInputPrivateCode(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.inputPrivateCode = str;
    }

    public final String getLng() {
        return this.lng;
    }

    public final void setLng(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.lng = str;
    }

    public final String getLat() {
        return this.lat;
    }

    public final void setLat(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.lat = str;
    }

    public final String getAddrress() {
        return this.addrress;
    }

    public final void setAddrress(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.addrress = str;
    }

    @Override // com.phone.number.gpstracker.familylocator.phonetracker.view.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bindComponent();
        bindEvent();
        getMyLocatiton();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // com.phone.number.gpstracker.familylocator.phonetracker.view.common.BaseActivity
    public ActivitySetMailAndCodeBinding getViewBinding() {
        ActivitySetMailAndCodeBinding inflate = ActivitySetMailAndCodeBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        return inflate;
    }
    private final void bindComponent() {
        ImageView imageView = getMBinding().ivSelect;
        Editable text = getMBinding().email.getText();
        Intrinsics.checkNotNullExpressionValue(text, "mBinding.email.text");
        boolean z = true;
        if (text.length() > 0) {
            Editable text2 = getMBinding().privateCode.getText();
            Intrinsics.checkNotNullExpressionValue(text2, "mBinding.privateCode.text");
        }
        z = false;
        imageView.setEnabled(z);
        if (getMBinding().ivSelect.isEnabled()) {
            getMBinding().ivSelect.setImageResource(R.drawable.ic_check);
        } else {
            getMBinding().ivSelect.setImageResource(R.drawable.ic_check_disable);
        }
        ImageView imageView2 = getMBinding().ivBack;
        Intrinsics.checkNotNullExpressionValue(imageView2, "mBinding.ivBack");
        AppExtensionKt.hide(imageView2);
        TextView textView = getMBinding().tvTitle;
        Intrinsics.checkNotNullExpressionValue(textView, "mBinding.tvTitle");
        AppExtensionKt.show(textView);
        TextView textView2 = getMBinding().tvTitleSetting;
        Intrinsics.checkNotNullExpressionValue(textView2, "mBinding.tvTitleSetting");
        AppExtensionKt.hide(textView2);

    }

    private final void bindEvent() {
        AppExtensionKt.onClick(getMBinding().ivSelect, 1000L, new Function1<ImageView, Unit>() {
            @Override
            public Unit invoke(ImageView imageView) {
                Intrinsics.checkNotNullParameter(imageView, "$this$onClick");
                if (isKeyboardShow) {
                    onHideKeyboard();

                }
                FrameLayout frameLayout = SetMailAndCodeActivity.this.getMBinding().frLoading;
                Intrinsics.checkNotNullExpressionValue(frameLayout, "mBinding.frLoading");
                AppExtensionKt.show(frameLayout);
               checkStartLogin();
            return Unit.INSTANCE;
            }

        });
        getMBinding().ivBack.setOnClickListener(new View.OnClickListener() { // from class: com.phone.number.gpstracker.familylocator.phonetracker.phone.view.setting.SetMailAndCodeActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SetMailAndCodeActivity.bindEvent$lambda$0(SetMailAndCodeActivity.this, view);
            }
        });
        getMBinding().email.addTextChangedListener(new TextWatcher() { // from class: com.phone.number.gpstracker.familylocator.phonetracker.phone.view.setting.SetMailAndCodeActivity$bindEvent$3
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                Intrinsics.checkNotNullParameter(s, "s");
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int i, int i2, int i3) {
                Intrinsics.checkNotNullParameter(s, "s");
            }

            public void onTextChanged(CharSequence s, int i, int i2, int i3) {
                ActivitySetMailAndCodeBinding mBinding;
                ActivitySetMailAndCodeBinding mBinding2;
                ActivitySetMailAndCodeBinding mBinding3;
                ActivitySetMailAndCodeBinding mBinding4;
                ActivitySetMailAndCodeBinding mBinding5;
                ActivitySetMailAndCodeBinding mBinding6;
                Intrinsics.checkNotNullParameter(s, "s");
                boolean z = true;
                SetMailAndCodeActivity.this.isKeyboardShow = true;
                mBinding = SetMailAndCodeActivity.this.getMBinding();
                ImageView imageView = mBinding.ivSelect;
                mBinding2 = SetMailAndCodeActivity.this.getMBinding();
                Editable text = mBinding2.email.getText();
                Intrinsics.checkNotNullExpressionValue(text, "mBinding.email.text");
                if (text.length() > 0) {
                    mBinding6 = SetMailAndCodeActivity.this.getMBinding();
                    Editable text2 = mBinding6.privateCode.getText();
                    Intrinsics.checkNotNullExpressionValue(text2, "mBinding.privateCode.text");
                }
                z = false;
                imageView.setEnabled(z);
                mBinding3 = SetMailAndCodeActivity.this.getMBinding();
                if (mBinding3.ivSelect.isEnabled()) {
                    mBinding5 = SetMailAndCodeActivity.this.getMBinding();
                    mBinding5.ivSelect.setImageResource(R.drawable.ic_check);
                    return;
                }
                mBinding4 = SetMailAndCodeActivity.this.getMBinding();
                mBinding4.ivSelect.setImageResource(R.drawable.ic_check_disable);
            }
        });
        getMBinding().privateCode.addTextChangedListener(new TextWatcher() { // from class: com.phone.number.gpstracker.familylocator.phonetracker.phone.view.setting.SetMailAndCodeActivity$bindEvent$4
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                Intrinsics.checkNotNullParameter(s, "s");
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int i, int i2, int i3) {
                Intrinsics.checkNotNullParameter(s, "s");
            }

            public void onTextChanged(CharSequence s, int i, int i2, int i3) {
                ActivitySetMailAndCodeBinding mBinding;
                ActivitySetMailAndCodeBinding mBinding2;
                ActivitySetMailAndCodeBinding mBinding3;
                ActivitySetMailAndCodeBinding mBinding4;
                ActivitySetMailAndCodeBinding mBinding5;
                ActivitySetMailAndCodeBinding mBinding6;
                Intrinsics.checkNotNullParameter(s, "s");
                boolean z = true;
                SetMailAndCodeActivity.this.isKeyboardShow = true;
                mBinding = SetMailAndCodeActivity.this.getMBinding();
                ImageView imageView = mBinding.ivSelect;
                mBinding2 = SetMailAndCodeActivity.this.getMBinding();
                Editable text = mBinding2.email.getText();
                Intrinsics.checkNotNullExpressionValue(text, "mBinding.email.text");
                if (text.length() > 0) {
                    mBinding6 = SetMailAndCodeActivity.this.getMBinding();
                    Editable text2 = mBinding6.privateCode.getText();
                    Intrinsics.checkNotNullExpressionValue(text2, "mBinding.privateCode.text");
                }
                z = false;
                imageView.setEnabled(z);
                mBinding3 = SetMailAndCodeActivity.this.getMBinding();
                if (mBinding3.ivSelect.isEnabled()) {
                    mBinding5 = SetMailAndCodeActivity.this.getMBinding();
                    mBinding5.ivSelect.setImageResource(R.drawable.ic_check);
                    return;
                }
                mBinding4 = SetMailAndCodeActivity.this.getMBinding();
                mBinding4.ivSelect.setImageResource(R.drawable.ic_check_disable);
            }
        });
        getMBinding().outside.setOnClickListener(new View.OnClickListener() { // from class: com.phone.number.gpstracker.familylocator.phonetracker.phone.view.setting.SetMailAndCodeActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SetMailAndCodeActivity.bindEvent$lambda$1(SetMailAndCodeActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindEvent$lambda$0(SetMailAndCodeActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onBackPressed();
    }


    public static final void bindEvent$lambda$1(SetMailAndCodeActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ExtensionKt.hideKeyboard(this$0);
    }

    @Override
    public void showLoading() {
        super.showLoading();
        FrameLayout frameLayout = getMBinding().frLoading;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "mBinding.frLoading");
        frameLayout.setVisibility(View.VISIBLE);
    }

    @Override // com.phone.number.gpstracker.familylocator.phonetracker.view.common.BaseActivity
    public void hideLoading() {
        super.hideLoading();
        FrameLayout frameLayout = getMBinding().frLoading;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "mBinding.frLoading");
        frameLayout.setVisibility(View.GONE);
    }

    private final boolean validateInput() {
        Editable text = getMBinding().email.getText();
        Intrinsics.checkNotNullExpressionValue(text, "mBinding.email.text");
        if (!(text.length() == 0)) {
            Editable text2 = getMBinding().privateCode.getText();
            Intrinsics.checkNotNullExpressionValue(text2, "mBinding.privateCode.text");
            if (!(text2.length() == 0)) {
                this.inputMail = getMBinding().email.getText().toString();
                this.inputPrivateCode = getMBinding().privateCode.getText().toString();
                StringsKt.replace(this.inputMail,"","",false);
                StringsKt.replace(this.inputPrivateCode,"","",false);
                StringsKt.trim((CharSequence) this.inputMail).toString();
                StringsKt.trim((CharSequence) this.inputPrivateCode).toString();
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkStartLogin() {
        SetMailAndCodeActivity setMailAndCodeActivity = this;
        if (!NetUtils.haveNetworkConnection(setMailAndCodeActivity)) {
            FrameLayout frameLayout = getMBinding().frLoading;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "mBinding.frLoading");
            AppExtensionKt.hide(frameLayout);
            ExtensionKt.showToast(setMailAndCodeActivity, "Usert created fail \nPlease connect with internet...");
        } else if (validateInput()) {
            if (AppAuthen.getInstance().createUser(this.inputMail, this.inputPrivateCode, setMailAndCodeActivity)) {
                Log.d("", "User created");
                initUserFirebaseDBV2();
                return;
            }
            Log.d("", "User created false");
        } else {
            getMBinding().email.setText("");
            getMBinding().privateCode.setText("");
            getMBinding().ivSelect.setEnabled(false);
            getMBinding().ivSelect.setImageResource(R.drawable.ic_check_disable);
        }
    }


    private final void initUserFirebaseDBV2() {
        String customUserID = AppAuthen.getInstance().user_id;
        String str = AppAuthen.getInstance().user_avt;
        if (str != null) {
        }
        str = "file:///android_asset/avatar/avatar1.png";
        DatabaseReference child = FirebaseDatabase.getInstance().getReference().child(RTDB_DEFINE.TABLE_USER).child(customUserID);
        Intrinsics.checkNotNullExpressionValue(child, "getInstance().reference.\u2026     .child(customUserID)");
        HashMap hashMap = new HashMap();
        String uid = RTDB_DEFINE.TBL_USER.INSTANCE.getUID();
        Intrinsics.checkNotNullExpressionValue(customUserID, "customUserID");
        hashMap.put(uid, customUserID);
        String email = RTDB_DEFINE.TBL_USER.INSTANCE.getEMAIL();
        String str2 = this.inputMail;
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put(email, str2);
        String model = RTDB_DEFINE.TBL_USER.INSTANCE.getMODEL();
        String MODEL = Build.MODEL;
        Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
        hashMap.put(model, MODEL);
        hashMap.put(RTDB_DEFINE.TBL_USER.INSTANCE.getSHARE(), "OFF");
        hashMap.put(RTDB_DEFINE.TBL_USER.INSTANCE.getLAT(), this.lat);
        hashMap.put(RTDB_DEFINE.TBL_USER.INSTANCE.getSAVEDEMAIL(), "0");
        hashMap.put(RTDB_DEFINE.TBL_USER.INSTANCE.getLOG(), this.lng);
        hashMap.put(RTDB_DEFINE.TBL_USER.INSTANCE.getPHONE(), "");
        hashMap.put(RTDB_DEFINE.TBL_USER.INSTANCE.getUSERNAME(), this.inputMail);
        hashMap.put(RTDB_DEFINE.TBL_USER.INSTANCE.getAVATAR(), str);
        hashMap.put(RTDB_DEFINE.TBL_USER.INSTANCE.getADDRESS(), this.addrress);
        hashMap.put(RTDB_DEFINE.TBL_USER.INSTANCE.getSOS(), false);
        hashMap.put(RTDB_DEFINE.TBL_USER.INSTANCE.getSOSMSG(), "Help me now!");
        child.updateChildren(hashMap).addOnCompleteListener(new OnCompleteListener() { // from class: com.phone.number.gpstracker.familylocator.phonetracker.phone.view.setting.SetMailAndCodeActivity$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                SetMailAndCodeActivity.initUserFirebaseDBV2$lambda$2(SetMailAndCodeActivity.this, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initUserFirebaseDBV2$lambda$2(SetMailAndCodeActivity this$0, Task tasks) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(tasks, "tasks");
        if (tasks.isSuccessful()) {
            FrameLayout frameLayout = this$0.getMBinding().frLoading;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "mBinding.frLoading");
            AppExtensionKt.hide(frameLayout);
            this$0.startLocationService();
            SetMailAndCodeActivity setMailAndCodeActivity = this$0;
            AppExtensionKt.setPref((Context) setMailAndCodeActivity, Constants.SET_AVATAR, true);
            AppExtensionKt.showActivity$default(setMailAndCodeActivity, HomeOptionActivity.class, null, 4, null);
            this$0.finishAffinity();
            return;
        }
        FrameLayout frameLayout2 = this$0.getMBinding().frLoading;
        Intrinsics.checkNotNullExpressionValue(frameLayout2, "mBinding.frLoading");
        AppExtensionKt.hide(frameLayout2);
        CustomToast.Companion.customToast(this$0.getString(R.string.custom_toast_splash_Something_Wrong), this$0);
    }

    @SuppressLint("MissingPermission")
    private final void getMyLocatiton() {
        Location lastKnownLocation;
        if (isLocationPermissionGranted()) {
            @SuppressLint("WrongConstant") Object systemService = getSystemService(FirebaseAnalytics.Param.LOCATION);
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.location.LocationManager");
            LocationManager locationManager = (LocationManager) systemService;
            if (Build.VERSION.SDK_INT < 28 || !locationManager.isLocationEnabled() || !locationManager.isProviderEnabled("gps") || (lastKnownLocation = locationManager.getLastKnownLocation("gps")) == null) {
                return;
            }
            this.lng = String.valueOf(lastKnownLocation.getLongitude());
            this.lat = String.valueOf(lastKnownLocation.getLatitude());
            syncAddress(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());
        }
    }

    private final void syncAddress(double d, double d2) {

       // BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope((CoroutineContext) Dispatchers.getIO()), null, null, new SetMailAndCodeActivity$syncAddress$1(this, d, d2, null), 3, null);
    }

    private final void startLocationService() {
        SetMailAndCodeActivity setMailAndCodeActivity = this;
        boolean z = ActivityCompat.checkSelfPermission(setMailAndCodeActivity, "android.permission.ACCESS_FINE_LOCATION") == 0;
        boolean loginUser = AppAuthen.getInstance().loginUser(setMailAndCodeActivity);
        if (z && loginUser) {
            if (Build.VERSION.SDK_INT >= 26) {
                startForegroundService(new Intent(setMailAndCodeActivity, GPSLocationService.class));
            } else {
                startService(new Intent(setMailAndCodeActivity, GPSLocationService.class));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onHideKeyboard() {
        this.isKeyboardShow = false;
        ExtensionKt.hideKeyboard(this);
    }




}
