package com.app.gpsphonelocator_new.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.app.gpsphonelocator_new.R;
import com.app.gpsphonelocator_new.common.ExtensionKt;
import com.app.gpsphonelocator_new.database.AlertHistoryEntity;
import com.app.gpsphonelocator_new.databinding.ItemNotificationZoneAlertBinding;
import com.app.gpsphonelocator_new.extensions.AppExtensionKt;

import java.util.ArrayList;
import java.util.List;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

public final class NotificationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    /* access modifiers changed from: private */
    public List<AlertHistoryEntity> listNotification = new ArrayList();

    public final void setData(List<AlertHistoryEntity> list) {
        Intrinsics.checkNotNullParameter(list, "listNotification");
        this.listNotification = list;
        notifyDataSetChanged();
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        ItemNotificationZoneAlertBinding inflate = ItemNotificationZoneAlertBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(\n            Lay…          false\n        )");
        return new ViewHolder(this, inflate);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        ((ViewHolder) viewHolder).bindData(i);
    }

    public int getItemCount() {
        return this.listNotification.size();
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/phone/number/gpstracker/familylocator/phonetracker/adapter/NotificationAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/phone/number/gpstracker/familylocator/phonetracker/databinding/ItemNotificationZoneAlertBinding;", "(Lcom/phone/number/gpstracker/familylocator/phonetracker/adapter/NotificationAdapter;Lcom/phone/number/gpstracker/familylocator/phonetracker/databinding/ItemNotificationZoneAlertBinding;)V", "bindData", "", "position", "", "APP78_NumberLocator_v1.1.0(110)_Nov.27.2023_productionRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: NotificationAdapter.kt */
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemNotificationZoneAlertBinding binding;
        final /* synthetic */ NotificationAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(NotificationAdapter notificationAdapter, ItemNotificationZoneAlertBinding itemNotificationZoneAlertBinding) {
            super(itemNotificationZoneAlertBinding.getRoot());
            Intrinsics.checkNotNullParameter(itemNotificationZoneAlertBinding, "binding");
            this.this$0 = notificationAdapter;
            this.binding = itemNotificationZoneAlertBinding;
        }

        public final void bindData(int i) {
            boolean onEnter = ((AlertHistoryEntity) this.this$0.listNotification.get(i)).getOnEnter();
            if (onEnter) {
                if (((AlertHistoryEntity) this.this$0.listNotification.get(i)).getStatus() == 1) {
                    ImageView imageView = this.binding.ivZoneAlertSafe;
                    Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivZoneAlertSafe");
                    AppExtensionKt.show(imageView);
                    ImageView imageView2 = this.binding.ivZoneAlertDanger;
                    Intrinsics.checkNotNullExpressionValue(imageView2, "binding.ivZoneAlertDanger");
                    AppExtensionKt.hide(imageView2);
                    this.binding.tvTitle.setText(((AlertHistoryEntity) this.this$0.listNotification.get(i)).getUserName() + ' ' + this.binding.getRoot().getContext().getString(R.string.have_entered_safe) + ' ' + ((AlertHistoryEntity) this.this$0.listNotification.get(i)).getZoneName());
                } else {
                    ImageView imageView3 = this.binding.ivZoneAlertSafe;
                    Intrinsics.checkNotNullExpressionValue(imageView3, "binding.ivZoneAlertSafe");
                    AppExtensionKt.hide(imageView3);
                    ImageView imageView4 = this.binding.ivZoneAlertDanger;
                    Intrinsics.checkNotNullExpressionValue(imageView4, "binding.ivZoneAlertDanger");
                    AppExtensionKt.show(imageView4);
                    this.binding.tvTitle.setText(((AlertHistoryEntity) this.this$0.listNotification.get(i)).getUserName() + ' ' + this.binding.getRoot().getContext().getString(R.string.have_entered_danger) + ' ' + ((AlertHistoryEntity) this.this$0.listNotification.get(i)).getZoneName());
                }
            } else if (!onEnter) {
                if (((AlertHistoryEntity) this.this$0.listNotification.get(i)).getStatus() == 1) {
                    ImageView imageView5 = this.binding.ivZoneAlertSafe;
                    Intrinsics.checkNotNullExpressionValue(imageView5, "binding.ivZoneAlertSafe");
                    AppExtensionKt.show(imageView5);
                    ImageView imageView6 = this.binding.ivZoneAlertDanger;
                    Intrinsics.checkNotNullExpressionValue(imageView6, "binding.ivZoneAlertDanger");
                    AppExtensionKt.hide(imageView6);
                    this.binding.tvTitle.setText(((AlertHistoryEntity) this.this$0.listNotification.get(i)).getUserName() + ' ' + this.binding.getRoot().getContext().getString(R.string.have_leaved_safe) + ' ' + ((AlertHistoryEntity) this.this$0.listNotification.get(i)).getZoneName());
                } else {
                    ImageView imageView7 = this.binding.ivZoneAlertSafe;
                    Intrinsics.checkNotNullExpressionValue(imageView7, "binding.ivZoneAlertSafe");
                    AppExtensionKt.hide(imageView7);
                    ImageView imageView8 = this.binding.ivZoneAlertDanger;
                    Intrinsics.checkNotNullExpressionValue(imageView8, "binding.ivZoneAlertDanger");
                    AppExtensionKt.show(imageView8);
                    this.binding.tvTitle.setText(((AlertHistoryEntity) this.this$0.listNotification.get(i)).getUserName() + ' ' + this.binding.getRoot().getContext().getString(R.string.have_leaved_danger) + ' ' + ((AlertHistoryEntity) this.this$0.listNotification.get(i)).getZoneName());
                }
            }
            this.binding.tvTime.setText(ExtensionKt.toDateTimeFormat(((AlertHistoryEntity) this.this$0.listNotification.get(i)).getTime()));
        }
    }
}
