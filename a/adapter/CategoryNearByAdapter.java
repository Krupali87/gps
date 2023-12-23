package com.app.gpsphonelocator_new.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.app.gpsphonelocator_new.R;
import com.app.gpsphonelocator_new.databinding.ItemCategoryNearByBinding;
import com.app.gpsphonelocator_new.extensions.AppExtensionKt;
import com.app.gpsphonelocator_new.phone.callback.CallBack;
import com.app.gpsphonelocator_new.phone.model.CategoryNearBy;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import kotlin.jvm.internal.Intrinsics;


public final class CategoryNearByAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    /* access modifiers changed from: private */
    public CallBack.CallBackCategory callBackCategory;
    /* access modifiers changed from: private */
    public List<CategoryNearBy> listCategory = new ArrayList();


    public final void callBackStyleMap(CallBack.CallBackCategory callBackCategory2) {
        Intrinsics.checkNotNullParameter(callBackCategory2, "callBackCategory");
        this.callBackCategory = callBackCategory2;
    }

    public final void setData(List<CategoryNearBy> list) {
        Intrinsics.checkNotNullParameter(list, "listCategory");
        this.listCategory = list;
        notifyDataSetChanged();
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        ItemCategoryNearByBinding inflate = ItemCategoryNearByBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f….context), parent, false)");
        return new ViewHolder(this, inflate);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        ((ViewHolder) viewHolder).bindData(i);
    }

    public int getItemCount() {
        return this.listCategory.size();
    }


    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemCategoryNearByBinding binding;
        final CategoryNearByAdapter this$0;


        public ViewHolder(CategoryNearByAdapter categoryNearByAdapter, ItemCategoryNearByBinding itemCategoryNearByBinding) {
            super(itemCategoryNearByBinding.getRoot());
            Intrinsics.checkNotNullParameter(itemCategoryNearByBinding, "binding");
            this.this$0 = categoryNearByAdapter;
            this.binding = itemCategoryNearByBinding;
        }

        public final void bindData(int i) {
            this.binding.tvMap.setText(((CategoryNearBy) this.this$0.listCategory.get(i)).getTitle());
            Glide.with(this.binding.getRoot().getContext()).load(((CategoryNearBy) this.this$0.listCategory.get(i)).getImage()).into(this.binding.ivMap);
            if (i == 0) {
                TextView textView = this.binding.tvMap;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.tvMap");
                AppExtensionKt.hide(textView);
                ImageView imageView = this.binding.ivMap;
                Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivMap");
                AppExtensionKt.hide(imageView);
                this.binding.tvTitle.setText(this.binding.getRoot().getContext().getString(R.string.food_and_drink));
                TextView textView2 = this.binding.tvTitle;
                Intrinsics.checkNotNullExpressionValue(textView2, "binding.tvTitle");
                AppExtensionKt.show(textView2);
                View view = this.binding.divider;
                Intrinsics.checkNotNullExpressionValue(view, "binding.divider");
                AppExtensionKt.show(view);
            } else if (i == 4) {
                TextView textView3 = this.binding.tvMap;
                Intrinsics.checkNotNullExpressionValue(textView3, "binding.tvMap");
                AppExtensionKt.hide(textView3);
                ImageView imageView2 = this.binding.ivMap;
                Intrinsics.checkNotNullExpressionValue(imageView2, "binding.ivMap");
                AppExtensionKt.hide(imageView2);
                this.binding.tvTitle.setText(this.binding.getRoot().getContext().getString(R.string.location_near_by_services));
                TextView textView4 = this.binding.tvTitle;
                Intrinsics.checkNotNullExpressionValue(textView4, "binding.tvTitle");
                AppExtensionKt.show(textView4);
                View view2 = this.binding.divider;
                Intrinsics.checkNotNullExpressionValue(view2, "binding.divider");
                AppExtensionKt.show(view2);
            } else if (i != 11) {
                TextView textView5 = this.binding.tvTitle;
                Intrinsics.checkNotNullExpressionValue(textView5, "binding.tvTitle");
                AppExtensionKt.hide(textView5);
                View view3 = this.binding.divider;
                Intrinsics.checkNotNullExpressionValue(view3, "binding.divider");
                AppExtensionKt.hide(view3);
                TextView textView6 = this.binding.tvMap;
                Intrinsics.checkNotNullExpressionValue(textView6, "binding.tvMap");
                AppExtensionKt.show(textView6);
                ImageView imageView3 = this.binding.ivMap;
                Intrinsics.checkNotNullExpressionValue(imageView3, "binding.ivMap");
                AppExtensionKt.show(imageView3);
            } else {
                TextView textView7 = this.binding.tvMap;
                Intrinsics.checkNotNullExpressionValue(textView7, "binding.tvMap");
                AppExtensionKt.hide(textView7);
                ImageView imageView4 = this.binding.ivMap;
                Intrinsics.checkNotNullExpressionValue(imageView4, "binding.ivMap");
                AppExtensionKt.hide(imageView4);
                this.binding.tvTitle.setText(this.binding.getRoot().getContext().getString(R.string.public_places));
                TextView textView8 = this.binding.tvTitle;
                Intrinsics.checkNotNullExpressionValue(textView8, "binding.tvTitle");
                AppExtensionKt.show(textView8);
                View view4 = this.binding.divider;
                Intrinsics.checkNotNullExpressionValue(view4, "binding.divider");
                AppExtensionKt.show(view4);
            }
            this.binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intrinsics.checkNotNullParameter(this, "this$0");
                    CallBack.CallBackCategory access$getCallBackCategory$p = this$0.callBackCategory;
                    if (access$getCallBackCategory$p == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("callBackCategory");
                        access$getCallBackCategory$p = null;
                    }
                    access$getCallBackCategory$p.selectCategory(((CategoryNearBy) this$0.listCategory.get(i)).getTitle());
                }
            });
        }


    }
}
