package com.app.gpsphonelocator_new.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.app.gpsphonelocator_new.R;
import com.app.gpsphonelocator_new.database.AlertZoneEntity;
import com.app.gpsphonelocator_new.databinding.ItemAlertZoneBinding;
import com.app.gpsphonelocator_new.common.ExtensionKt;

import java.util.List;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;


public final class ZoneAlertAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;

    public List<AlertZoneEntity> data = CollectionsKt.emptyList();
    private Function1<? super AlertZoneEntity, Unit> onItemClicked;

    public ZoneAlertAdapter(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    public final Context getContext() {
        return this.context;
    }

    public final void setContext(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "<set-?>");
        this.context = context2;
    }

    public final Function1<AlertZoneEntity, Unit> getOnItemClicked() {
        return (Function1<AlertZoneEntity, Unit>) this.onItemClicked;
    }

    public final void setOnItemClicked(Function1<? super AlertZoneEntity, Unit> function1) {
        this.onItemClicked = function1;
    }

    public final void setData(List<AlertZoneEntity> list) {
        Intrinsics.checkNotNullParameter(list, "data");
        this.data = list;
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.data.size();
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        ItemAlertZoneBinding inflate = ItemAlertZoneBinding.inflate(LayoutInflater.from(this.context), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f…(context), parent, false)");
        return new ZoneAlertVH(this, inflate);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        ((ZoneAlertVH) viewHolder).bindData(i);
    }

    public final class ZoneAlertVH extends RecyclerView.ViewHolder {
        private final ItemAlertZoneBinding binding;
        final  ZoneAlertAdapter this$0;


        public ZoneAlertVH(ZoneAlertAdapter zoneAlertAdapter, ItemAlertZoneBinding itemAlertZoneBinding) {
            super(itemAlertZoneBinding.getRoot());
            Intrinsics.checkNotNullParameter(itemAlertZoneBinding, "binding");
            this.this$0 = zoneAlertAdapter;
            this.binding = itemAlertZoneBinding;
        }

        public final void bindData(int i) {
            AlertZoneEntity alertZoneEntity = (AlertZoneEntity) this.this$0.data.get(i);
            View view = this.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "itemView");
            ExtensionKt.setOnSingleClickListener(view, new Function1<View, Unit>() {
                @Override
                public Unit invoke(View view) {

                    Function1<AlertZoneEntity, Unit> onItemClicked = ZoneAlertAdapter.this.getOnItemClicked();
                    if (onItemClicked != null) {
                        onItemClicked.invoke(alertZoneEntity);
                    }
                    return Unit.INSTANCE;
                }
            });
            ItemAlertZoneBinding itemAlertZoneBinding = this.binding;
            if (alertZoneEntity.getStatus() == 1) {
                itemAlertZoneBinding.imgStatus.setImageResource(R.drawable.ic_start_item_safe_zone);
                itemAlertZoneBinding.imgStatusZone.setImageResource(R.drawable.ic_safe_zone);
            } else {
                itemAlertZoneBinding.imgStatus.setImageResource(R.drawable.ic_start_item_danger_zone);
                itemAlertZoneBinding.imgStatusZone.setImageResource(R.drawable.ic_danger_zone);
            }
            itemAlertZoneBinding.tvZoneName.setText(alertZoneEntity.getZoneName());
            itemAlertZoneBinding.tvAddress.setText(alertZoneEntity.getAddress());
        }
    }
}
