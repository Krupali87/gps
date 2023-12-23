package com.app.gpsphonelocator_new.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.app.gpsphonelocator_new.database.AlertZoneEntity;
import com.app.gpsphonelocator_new.databinding.ItemZoneAlertPopupBinding;
import com.app.gpsphonelocator_new.extensions.AppExtensionKt;
import com.app.gpsphonelocator_new.phone.callback.CallBack;
import com.app.gpsphonelocator_new.database.AlertZoneEntity;
import com.app.gpsphonelocator_new.databinding.ItemZoneAlertPopupBinding;
import com.app.gpsphonelocator_new.phone.callback.CallBack;

import java.util.ArrayList;
import java.util.List;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;


public final class ZoneAlertPopUpAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public CallBack.CallBackZoneAlertPopUp callBackZoneAlertPopUp;

    public List<AlertZoneEntity> listZoneAlert = new ArrayList();

    public  void callBackZoneAlertPopUp(CallBack.CallBackZoneAlertPopUp callBackZoneAlertPopUp2) {
        Intrinsics.checkNotNullParameter(callBackZoneAlertPopUp2, "callBackZoneAlertPopUp");
        this.callBackZoneAlertPopUp = callBackZoneAlertPopUp2;
    }

    public  void setData(List<AlertZoneEntity> list) {
        Intrinsics.checkNotNullParameter(list, "listZoneAlert");
        this.listZoneAlert = list;
        notifyDataSetChanged();
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        ItemZoneAlertPopupBinding inflate = ItemZoneAlertPopupBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f….context), parent, false)");
        return new ViewHolder(this, inflate);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        ((ViewHolder) viewHolder).bindData(i);
    }

    public int getItemCount() {
        List<AlertZoneEntity> list = this.listZoneAlert;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemZoneAlertPopupBinding binding;
        final  ZoneAlertPopUpAdapter this$0;

        public ViewHolder(ZoneAlertPopUpAdapter zoneAlertPopUpAdapter, ItemZoneAlertPopupBinding itemZoneAlertPopupBinding) {
            super(itemZoneAlertPopupBinding.getRoot());
            Intrinsics.checkNotNullParameter(itemZoneAlertPopupBinding, "binding");
            this.this$0 = zoneAlertPopUpAdapter;
            this.binding = itemZoneAlertPopupBinding;
        }


        public final void bindData(int r6) {
            AlertZoneEntity alertZoneEntity;
            AlertZoneEntity alertZoneEntity2;
            List list = this.this$0.listZoneAlert;
            String str = null;
            Integer valueOf = (list == null || (alertZoneEntity2 = (AlertZoneEntity) list.get(r6)) == null) ? null : Integer.valueOf(alertZoneEntity2.getStatus());
            if (valueOf != null && valueOf.intValue() == 1) {
                ImageView imageView = this.binding.ivSafeZoneAlert;
                Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivSafeZoneAlert");
                AppExtensionKt.show(imageView);
                ImageView imageView2 = this.binding.ivDangerZoneAlert;
                Intrinsics.checkNotNullExpressionValue(imageView2, "binding.ivDangerZoneAlert");
                AppExtensionKt.hide(imageView2);
            } else {
                ImageView imageView3 = this.binding.ivSafeZoneAlert;
                Intrinsics.checkNotNullExpressionValue(imageView3, "binding.ivSafeZoneAlert");
                AppExtensionKt.hide(imageView3);
                ImageView imageView4 = this.binding.ivDangerZoneAlert;
                Intrinsics.checkNotNullExpressionValue(imageView4, "binding.ivDangerZoneAlert");
                AppExtensionKt.show(imageView4);
            }
            TextView textView = this.binding.tvZoneAlert;
            List list2 = this.this$0.listZoneAlert;
            if (list2 != null && (alertZoneEntity = (AlertZoneEntity) list2.get(r6)) != null) {
                str = String.valueOf(alertZoneEntity.getZoneName());
            }
            textView.setText(str);
            ConstraintLayout root = (ConstraintLayout) this.binding.getRoot();
            final ZoneAlertPopUpAdapter zoneAlertPopUpAdapter = this.this$0;
            root.setOnClickListener(new View.OnClickListener() { // from class: com.phone.number.gpstracker.familylocator.phonetracker.adapter.ZoneAlertPopUpAdapter$ViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ZoneAlertPopUpAdapter.ViewHolder.this.bindData$lambda$0(ZoneAlertPopUpAdapter.this, r6, view);
                }
            });

        }
        public  final void bindData$lambda$0(ZoneAlertPopUpAdapter this$0, int i, View vie) {
            CallBack.CallBackZoneAlertPopUp callBackZoneAlertPopUp;
            AlertZoneEntity alertZoneEntity;
            AlertZoneEntity alertZoneEntity2;
            AlertZoneEntity alertZoneEntity3;
            AlertZoneEntity alertZoneEntity4;
            AlertZoneEntity alertZoneEntity5;
            Intrinsics.checkNotNullParameter(this, "this$0");
            CallBack.CallBackZoneAlertPopUp callBackZoneAlertPopUp2 = this$0.callBackZoneAlertPopUp;
            Double d = null;
            if (callBackZoneAlertPopUp2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("callBackZoneAlertPopUp");
                callBackZoneAlertPopUp = null;
            } else {
                callBackZoneAlertPopUp = callBackZoneAlertPopUp2;
            }
            List list = this$0.listZoneAlert;
            String valueOf = String.valueOf((list == null || (alertZoneEntity5 = (AlertZoneEntity) list.get(i)) == null) ? null : alertZoneEntity5.getZoneName());
            List list2 = this$0.listZoneAlert;
            String valueOf2 = String.valueOf((list2 == null || (alertZoneEntity4 = (AlertZoneEntity) list2.get(i)) == null) ? null : alertZoneEntity4.getAddress());
            List list3 = this$0.listZoneAlert;
            String valueOf3 = String.valueOf((list3 == null || (alertZoneEntity3 = (AlertZoneEntity) list3.get(i)) == null) ? null : alertZoneEntity3.getLatitude());
            List list4 = this$0.listZoneAlert;
            if (list4 != null && (alertZoneEntity2 = (AlertZoneEntity) list4.get(i)) != null) {
                d = alertZoneEntity2.getLongitude();
            }
            String valueOf4 = String.valueOf(d);
            List list5 = this$0.listZoneAlert;
            callBackZoneAlertPopUp.selectZoneAlertPopUp(i, valueOf, valueOf2, valueOf3, valueOf4, (list5 == null || (alertZoneEntity = (AlertZoneEntity) list5.get(i)) == null) ? 0 : alertZoneEntity.getStatus());
        }
    }

}


