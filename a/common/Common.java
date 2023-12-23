package com.app.gpsphonelocator_new.common;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.work.WorkRequest;

import com.app.gpsphonelocator_new.database.RTDB_DEFINE;
import com.app.gpsphonelocator_new.databinding.DialogConfirmDeleteBinding;
import com.app.gpsphonelocator_new.phone.util.AppAuthen;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;


public final class Common {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    public static int MAX_ZONE_ADDED = 3;

    public static float MIN_DISTANCE_GPS = 200.0f;

    public static long MIN_TIME_GPS = WorkRequest.MIN_BACKOFF_MILLIS;

    public static int ZONE_RADIUS = 600;

    public static boolean checkShare;

    public static String email;

    public static boolean isAppRunBackground;

    public static String name = "";

    public static String phone;

    public static String photoUri;

    public static String pin = "";

    public static String previousAddActivity = "";

    public static List<InforSaved> userlist1 = new ArrayList();

    public static AlertDialog dialog;


    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final long getMIN_TIME_GPS() {
            return Common.MIN_TIME_GPS;
        }

        public final void setMIN_TIME_GPS(long j) {
            Common.MIN_TIME_GPS = j;
        }

        public final float getMIN_DISTANCE_GPS() {
            return Common.MIN_DISTANCE_GPS;
        }

        public final void setMIN_DISTANCE_GPS(float f) {
            Common.MIN_DISTANCE_GPS = f;
        }

        public final int getZONE_RADIUS() {
            return Common.ZONE_RADIUS;
        }

        public final void setZONE_RADIUS(int i) {
            Common.ZONE_RADIUS = i;
        }

        public final int getMAX_ZONE_ADDED() {
            return Common.MAX_ZONE_ADDED;
        }

        public final void setMAX_ZONE_ADDED(int i) {
            Common.MAX_ZONE_ADDED = i;
        }

        public final boolean isAppRunBackground() {
            return Common.isAppRunBackground;
        }

        public final void setAppRunBackground(boolean z) {
            Common.isAppRunBackground = z;
        }

        public final String getName() {
            return Common.name;
        }

        public final void setName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            Common.name = str;
        }

        public final String getPin() {
            return Common.pin;
        }

        public final void setPin(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            Common.pin = str;
        }

        public final boolean getCheckShare() {
            return Common.checkShare;
        }

        public final void setCheckShare(boolean z) {
            Common.checkShare = z;
        }

        public final String getPhotoUri() {
            return Common.photoUri;
        }

        public final void setPhotoUri(String str) {
            Common.photoUri = str;
        }

        public final String getPhone() {
            return Common.phone;
        }

        public final void setPhone(String str) {
            Common.phone = str;
        }

        public final String getEmail() {
            return Common.email;
        }

        public final void setEmail(String str) {
            Common.email = str;
        }

        public final String getPreviousAddActivity() {
            return Common.previousAddActivity;
        }

        public final void setPreviousAddActivity(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            Common.previousAddActivity = str;
        }

        public final List<InforSaved> getUserlist1() {
            return Common.userlist1;
        }

        public final void setUserlist1(List<InforSaved> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            Common.userlist1 = list;
        }

        public final String getRandomAvatar() {
            return "avatar_" + RangesKt.random(new IntRange(1, 10), (Random) Random.Default);
        }

        @SuppressLint("ResourceType")
        public final boolean showDialogConfirmDelete(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Context context = activity;
            DialogConfirmDeleteBinding inflate = DialogConfirmDeleteBinding.inflate(LayoutInflater.from(context));
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.from(activity))");
            Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            AlertDialog show = new AlertDialog.Builder(context).setView(inflate.getRoot()).show();
            Window window = show.getWindow();
            if (window != null) {
                window.setBackgroundDrawableResource(17170445);
            }
            Window window2 = show.getWindow();
            Intrinsics.checkNotNull(window2);
            window2.setLayout((int) (((double) activity.getResources().getDisplayMetrics().widthPixels) * 0.8d), -2);
            show.setCancelable(false);
            TextView textView = inflate.txtCancel;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.txtCancel");
            ExtensionKt.setOnSingleClickListener(textView, new Function1<View, Unit>() {
                @Override
                public Unit invoke(View view) {
                    dialog.dismiss();
                    return null;
                }
            });
            TextView textView2 = inflate.txtDelete;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.txtDelete");
            ExtensionKt.setOnSingleClickListener(textView2, new Function1<View, Unit>() {
                @Override
                public Unit invoke(View view) {
                    Ref.BooleanRef check=null;
                    dialog.dismiss();
                    check.element = true;
                    return Unit.INSTANCE;
                }
            });
            return booleanRef.element;
        }

        public final void collectallusersvalue1() {
            AppAuthen.AuthUser currentUser = AppAuthen.getInstance().getCurrentUser();
            DatabaseReference child = FirebaseDatabase.getInstance().getReference().child(RTDB_DEFINE.TABLE_SAVE_MAIL);
            Intrinsics.checkNotNull(currentUser);
            DatabaseReference child2 = child.child(currentUser.uid);
            Intrinsics.checkNotNullExpressionValue(child2, "getInstance().reference.…    .child(appUser!!.uid)");
            List<InforSaved> userlist1 = getUserlist1();
            Intrinsics.checkNotNull(userlist1, "null cannot be cast to non-null type java.util.ArrayList<com.app.gpsphonelocator_new.common.InforSaved>{ kotlin.collections.TypeAliasesKt.ArrayList<com.app.gpsphonelocator_new.common.InforSaved> }");
            ((ArrayList) userlist1).clear();
            child2.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Intrinsics.checkNotNullParameter(dataSnapshot, "snapshot");
                    for (DataSnapshot value : dataSnapshot.getChildren()) {
                        InforSaved inforSaved = (InforSaved) value.getValue(InforSaved.class);
                        List<InforSaved> userlist1 = Common.Companion.getUserlist1();
                        Intrinsics.checkNotNull(userlist1, "null cannot be cast to non-null type java.util.ArrayList<com.app.gpsphonelocator_new.common.InforSaved>{ kotlin.collections.TypeAliasesKt.ArrayList<com.app.gpsphonelocator_new.common.InforSaved> }");
                        Intrinsics.checkNotNull(inforSaved);
                        ((ArrayList) userlist1).add(inforSaved);
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Intrinsics.checkNotNullParameter(databaseError, "error");
                }
            });
        }

        @SuppressLint("WrongConstant")
        public final AlertDialog setProgressDialog(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(0);
            linearLayout.setPadding(30, 30, 30, 30);
            linearLayout.setGravity(17);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            ViewGroup.LayoutParams layoutParams2 = layoutParams;
            linearLayout.setLayoutParams(layoutParams2);
            ProgressBar progressBar = new ProgressBar(context);
            progressBar.setIndeterminate(true);
            progressBar.setPadding(0, 0, 30, 0);
            progressBar.setLayoutParams(layoutParams2);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams3.gravity = 17;
            TextView textView = new TextView(context);
            textView.setText("Loading ...");
            textView.setTextColor(Color.parseColor("#000000"));
            textView.setTextSize(20.0f);
            textView.setLayoutParams(layoutParams3);
            linearLayout.addView(progressBar);
            linearLayout.addView(textView);
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setCancelable(false);
            builder.setView(linearLayout);
            AlertDialog create = builder.create();
            Intrinsics.checkNotNullExpressionValue(create, "builder.create()");
            Window window = create.getWindow();
            if (window != null) {
                WindowManager.LayoutParams layoutParams4 = new WindowManager.LayoutParams();
                Window window2 = create.getWindow();
                layoutParams4.copyFrom(window2 != null ? window2.getAttributes() : null);
                layoutParams4.width = -2;
                layoutParams4.height = -2;
                Window window3 = create.getWindow();
                if (window3 != null) {
                    window3.setAttributes(layoutParams4);
                }
                window.setFlags(16, 16);
            }
            return create;
        }
    }
}
