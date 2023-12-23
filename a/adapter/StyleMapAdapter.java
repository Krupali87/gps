package com.app.gpsphonelocator_new.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.app.gpsphonelocator_new.databinding.ItemStyleMapBinding;
import com.app.gpsphonelocator_new.extensions.AppExtensionKt;
import com.app.gpsphonelocator_new.phone.callback.CallBack;
import com.app.gpsphonelocator_new.phone.model.StyleMap;
import com.bumptech.glide.Glide;
import java.util.ArrayList;
import java.util.List;

import kotlin.jvm.internal.Intrinsics;


public final class StyleMapAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public CallBack.CallBackStyleMap callBackStyleMap;
    private int currentPos;

    public List<StyleMap> listStyleMap = new ArrayList();

    StyleMapAdapter this$0;


    public final void callBackStyleMap(CallBack.CallBackStyleMap callBackStyleMap2) {
        Intrinsics.checkNotNullParameter(callBackStyleMap2, "callBackStyleMap");
        this.callBackStyleMap = callBackStyleMap2;
    }

    public  int getCurrentPos() {
        return this.currentPos;
    }

    public  void setCurrentPos(int i) {
        this.currentPos = i;
    }

    public  void checkSelectView(int i) {
        int i2 = this.currentPos;
        this.currentPos = i;
        notifyItemChanged(i);
        notifyItemChanged(i2);
    }

    public  void setData(List<StyleMap> list) {
        Intrinsics.checkNotNullParameter(list, "listStyleMap");
        this.listStyleMap = list;
        notifyDataSetChanged();
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        ItemStyleMapBinding inflate = ItemStyleMapBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f….context), parent, false)");
        return new ViewHolder(this, inflate);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        ((ViewHolder) viewHolder).bindData(i);
    }

    public int getItemCount() {
        return this.listStyleMap.size();
    }


    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemStyleMapBinding binding;
        final  StyleMapAdapter this$0;


        public ViewHolder(StyleMapAdapter styleMapAdapter, ItemStyleMapBinding itemStyleMapBinding) {
            super(itemStyleMapBinding.getRoot());
            Intrinsics.checkNotNullParameter(itemStyleMapBinding, "binding");
            this.this$0 = styleMapAdapter;
            this.binding = itemStyleMapBinding;
        }

        public  void bindData(int i) {
            Glide.with(this.binding.getRoot().getContext()).load(((StyleMap) this.this$0.listStyleMap.get(i)).getImage()).into(this.binding.ivMap);
            this.binding.tvMap.setText(((StyleMap) this.this$0.listStyleMap.get(i)).getTitle());
            if (this.this$0.getCurrentPos() == i) {
                ImageView imageView = this.binding.ivSelect;
                Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivSelect");
                AppExtensionKt.show(imageView);
            } else {
                ImageView imageView2 = this.binding.ivSelect;
                Intrinsics.checkNotNullExpressionValue(imageView2, "binding.ivSelect");
                AppExtensionKt.hide(imageView2);
            }
            this.binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intrinsics.checkNotNullParameter(this$0, "this$0");
                    CallBack.CallBackStyleMap access$getCallBackStyleMap$p = this$0.callBackStyleMap;
                    if (access$getCallBackStyleMap$p == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("callBackStyleMap");
                        access$getCallBackStyleMap$p = null;
                    }
                    access$getCallBackStyleMap$p.selectStyleMap(i);
                }
            });
        }

    }
}
