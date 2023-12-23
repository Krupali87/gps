package com.app.gpsphonelocator_new.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.app.gpsphonelocator_new.databinding.ItemAvatarBinding;
import com.app.gpsphonelocator_new.extensions.AppExtensionKt;
import com.app.gpsphonelocator_new.phone.callback.CallBack;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

        import kotlin.jvm.internal.Intrinsics;

public final class AvatarAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public CallBack.CallBackAvatar callBackAvatar;
    private int currentPos;
    public List<String> listAvatar = new ArrayList();

    public  int getCurrentPos() {
        return this.currentPos;
    }

    public  void setCurrentPos(int i) {
        this.currentPos = i;
    }

    public AvatarAdapter avatarAdapter;

    public final void callBackAvatar(CallBack.CallBackAvatar callBackAvatar2) {
        Intrinsics.checkNotNullParameter(callBackAvatar2, "callBackAvatar");
        this.callBackAvatar = callBackAvatar2;
    }

    public  void checkSelectView(int i) {
        int i2 = this.currentPos;
        this.currentPos = i;
        notifyItemChanged(i);
        notifyItemChanged(i2);
    }

    public final void setData(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "listAvatar");
        this.listAvatar = list;
        notifyDataSetChanged();
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        ItemAvatarBinding inflate = ItemAvatarBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f….context), parent, false)");
        return new ViewHolder(this, inflate);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        ((ViewHolder) viewHolder).bindData(i);
    }

    public int getItemCount() {
        return this.listAvatar.size();
    }


    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemAvatarBinding binding;
        final AvatarAdapter this$0;


        public ViewHolder(AvatarAdapter avatarAdapter, ItemAvatarBinding itemAvatarBinding) {
            super(itemAvatarBinding.getRoot());
            Intrinsics.checkNotNullParameter(itemAvatarBinding, "binding");
            this.this$0 = avatarAdapter;
            this.binding = itemAvatarBinding;
        }

        public final void bindData(int i) {
            if (((CharSequence) this.this$0.listAvatar.get(i)).length() == 0) {
                Glide.with(this.binding.getRoot().getContext()).load("avatar/avatar1.png").into((ImageView) this.binding.ivAvatar);
            } else {
                Glide.with(this.binding.getRoot().getContext()).load((String) this.this$0.listAvatar.get(i)).into((ImageView) this.binding.ivAvatar);
            }
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

                    Intrinsics.checkNotNullParameter(this, "this$0");
                    CallBack.CallBackAvatar access$getCallBackAvatar$p = this$0.callBackAvatar;
                    if (access$getCallBackAvatar$p == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("callBackAvatar");
                        access$getCallBackAvatar$p = null;
                    }
                    access$getCallBackAvatar$p.selectAvatar(i, this$0.listAvatar.size());
                }
            });
        }


    }
}
