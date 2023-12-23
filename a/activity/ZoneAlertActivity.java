package com.app.gpsphonelocator_new.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.gpsphonelocator_new.adapter.ZoneAlertAdapter;
import com.app.gpsphonelocator_new.database.AlertZoneEntity;
import com.app.gpsphonelocator_new.database.UserDatabase;
import com.app.gpsphonelocator_new.database.ZoneAlertDao;
import com.app.gpsphonelocator_new.databinding.ActivityZoneAlertBinding;
import com.app.gpsphonelocator_new.extensions.AppExtensionKt;
import com.app.gpsphonelocator_new.phone.util.AppAuthen;
import com.app.gpsphonelocator_new.phone.util.Constants;
import com.app.gpsphonelocator_new.phone.util.DataExKt;
import com.app.gpsphonelocator_new.common.ExtensionKt;

import java.util.List;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

public final class ZoneAlertActivity extends BaseActivity<ActivityZoneAlertBinding> {
    private ZoneAlertAdapter adapter;
    private List<AlertZoneEntity> alertZoneList = CollectionsKt.emptyList();
    private AppAuthen.AuthUser appUser;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        Intent intent = getIntent();
        if (intent != null) {
            boolean isUpdate = intent.getBooleanExtra("is_update", false);
            if (isUpdate) {
                AlertZoneEntity zoneData = intent.getParcelableExtra("zone_data");
                // Now use zoneData to populate your UI elements, including the zone name
                if (zoneData != null) {
                    String zoneName = (String) zoneData.getZoneName();
                    // Set the zoneName to your UI element (e.g., TextView)
                }
            }
        }
        this.appUser = AppAuthen.getInstance().getCurrentUser();
        initAdapter();
    }

    public void onResume() {
        super.onResume();
     getAlertZoneDB();
    }

    private final void initAdapter() {
        Context context = this;
        this.adapter = new ZoneAlertAdapter(context);
        String stringExtra = getIntent().getStringExtra(Constants.message_key);
        ZoneAlertAdapter zoneAlertAdapter = this.adapter;
        ZoneAlertAdapter zoneAlertAdapter2 = null;
        if (zoneAlertAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            zoneAlertAdapter = null;
        }

        zoneAlertAdapter.setOnItemClicked(new Function1<AlertZoneEntity, Unit>() {
            @Override
            public Unit invoke(AlertZoneEntity alertZoneEntity) {
                String $receivedMessage=null;
                Intrinsics.checkNotNullParameter(alertZoneEntity, "it");
                Intent intent = new Intent(ZoneAlertActivity.this, CreateZoneActivity.class);
                if (StringsKt.equals($receivedMessage,Constants.zone_alert_from_home,false)) {
                    Context baseContext = ZoneAlertActivity.this.getBaseContext();
                    Intrinsics.checkNotNullExpressionValue(baseContext, "baseContext");
                    DataExKt.logEvent(baseContext, Constants.INSTANCE.getUpdate_zone());
                } else if (StringsKt.equals($receivedMessage,"zone_alert_from_map",false)) {
                    Context baseContext2 = ZoneAlertActivity.this.getBaseContext();
                    Intrinsics.checkNotNullExpressionValue(baseContext2, "baseContext");
                    DataExKt.logEvent(baseContext2, Constants.INSTANCE.getUpdate_zone2());
                }
                intent.putExtra("is_update", true);
                intent.putExtra("zone_data", alertZoneEntity);
                ZoneAlertActivity.this.startActivity(intent);
                return Unit.INSTANCE;
            }
        });
        ((ActivityZoneAlertBinding) getMBinding()).rvZone.setLayoutManager(new LinearLayoutManager(context));
        ((ActivityZoneAlertBinding) getMBinding()).rvZone.setHasFixedSize(true);
        RecyclerView recyclerView = ((ActivityZoneAlertBinding) getMBinding()).rvZone;
        ZoneAlertAdapter zoneAlertAdapter3 = this.adapter;
        if (zoneAlertAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            zoneAlertAdapter2 = zoneAlertAdapter3;
        }
        recyclerView.setAdapter(zoneAlertAdapter2);
    }


    private final void getAlertZoneDB() {
       ZoneAlertDao zoneDAO;
        List<AlertZoneEntity> listZone;
        UserDatabase.Companion companion = UserDatabase.Companion;
        Context baseContext = getBaseContext();
        Intrinsics.checkNotNullExpressionValue(baseContext, "baseContext");
        UserDatabase companion2 = companion.getInstance(baseContext);
        ZoneAlertAdapter zoneAlertAdapter = null;
        List<AlertZoneEntity> reversed = (companion2 == null || (zoneDAO = companion2.zoneDAO()) == null || (listZone = zoneDAO.getListZone()) == null) ? null : CollectionsKt.reversed(listZone);
        this.alertZoneList = reversed;
        if (reversed != null) {
            ZoneAlertAdapter zoneAlertAdapter2 = this.adapter;
            if (zoneAlertAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            } else {
                zoneAlertAdapter = zoneAlertAdapter2;
            }
            zoneAlertAdapter.setData(reversed);
        }
        ActivityZoneAlertBinding mBinding = getMBinding();
        List<AlertZoneEntity> list = this.alertZoneList;
        boolean z = true;
        if (list == null || !list.isEmpty()) {
            z = false;
        }
        if (z) {
            mBinding.exampleZoneAlert.setVisibility(View.GONE);
            LinearLayout exampleZoneAlert = mBinding.exampleZoneAlert;
            Intrinsics.checkNotNullExpressionValue(exampleZoneAlert, "exampleZoneAlert");
            AppExtensionKt.show(exampleZoneAlert);
            return;
        }
        mBinding.exampleZoneAlert.setVisibility(View.GONE);
        LinearLayout exampleZoneAlert2 = mBinding.exampleZoneAlert;
        Intrinsics.checkNotNullExpressionValue(exampleZoneAlert2, "exampleZoneAlert");
        AppExtensionKt.hide(exampleZoneAlert2);
  }

    public ActivityZoneAlertBinding getViewBinding() {
        ActivityZoneAlertBinding inflate = ActivityZoneAlertBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        return inflate;
    }

    private final void initView() {
        ActivityZoneAlertBinding activityZoneAlertBinding = (ActivityZoneAlertBinding) getMBinding();
        ImageView imageView = activityZoneAlertBinding.imgBack;
        Intrinsics.checkNotNullExpressionValue(imageView, "imgBack");
        ExtensionKt.setOnSingleClickListener(imageView, new Function1<View, Unit>() {
            @Override
            public Unit invoke(View view) {
                onBackPressed();
                return null;
            }
        });
//        activityZoneAlertBinding.cvAddZone.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intrinsics.checkNotNullParameter(this, "this$0");
//                addZone();
//            }
//        });
        activityZoneAlertBinding.imgAddZone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intrinsics.checkNotNullParameter(this, "this$0");
                addZone();
            }
        });
    }

    private final void addZone() {
        String stringExtra = getIntent().getStringExtra(Constants.message_key);


        if (StringsKt.equals(stringExtra,"zone_alert_from_map",false))
        {
            DataExKt.logEvent(this, Constants.INSTANCE.getCreate_zone2());
        }
            else if (StringsKt.equals(stringExtra,Constants.zone_alert_from_home,false))
        {
            DataExKt.logEvent(this, Constants.INSTANCE.getCreate_zone());
        }
        startActivity(new Intent(this, CreateZoneActivity.class));
    }


}
