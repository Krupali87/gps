package com.app.gpsphonelocator_new.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.app.gpsphonelocator_new.R;
import com.app.gpsphonelocator_new.databinding.ItemFriendBinding;
import com.app.gpsphonelocator_new.common.ExtensionKt;
import com.app.gpsphonelocator_new.common.InforSaved;

import java.util.ArrayList;
import java.util.List;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;



public final class FriendAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final Context context;
    private Function1<? super InforSaved, Unit> onFriendClicked;

    public List<InforSaved> usersList = new ArrayList();

    public FriendAdapter(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    public final Context getContext() {
        return this.context;
    }

    public final Function1<InforSaved, Unit> getOnFriendClicked() {
        return (Function1<InforSaved, Unit>) this.onFriendClicked;
    }

    public final void setOnFriendClicked(Function1<? super InforSaved, Unit> function1) {
        this.onFriendClicked = function1;
    }

    public final void setData(List<InforSaved> list) {
        Intrinsics.checkNotNullParameter(list, "data");
        this.usersList.clear();
        this.usersList.addAll(list);
        notifyDataSetChanged();
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        ItemFriendBinding inflate = ItemFriendBinding.inflate(LayoutInflater.from(this.context), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f…(context), parent, false)");
        return new FriendVH(this, inflate);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        ((FriendVH) viewHolder).bindData(i);
    }

    public int getItemCount() {
        return this.usersList.size();
    }


    public final class FriendVH extends RecyclerView.ViewHolder {
        private final ItemFriendBinding binding;
        final /* synthetic */ FriendAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FriendVH(FriendAdapter friendAdapter, ItemFriendBinding itemFriendBinding) {
            super(itemFriendBinding.getRoot());
            Intrinsics.checkNotNullParameter(itemFriendBinding, "binding");
            this.this$0 = friendAdapter;
            this.binding = itemFriendBinding;
        }

        public final void bindData(int i) {
            InforSaved inforSaved = (InforSaved) this.this$0.usersList.get(i);
            ItemFriendBinding itemFriendBinding = this.binding;
            FriendAdapter friendAdapter = this.this$0;
            ConstraintLayout root = (ConstraintLayout) itemFriendBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "root");
            ExtensionKt.setOnSingleClickListener(root, new Function1<View, Unit>() {
                @Override
                public Unit invoke(View view) {
                    Function1<InforSaved, Unit> onFriendClicked = FriendAdapter.this.getOnFriendClicked();
                    if (onFriendClicked != null) {
                        onFriendClicked.invoke(inforSaved);
                    }
                    return Unit.INSTANCE;
                }
            });
            itemFriendBinding.tvName.setText(inforSaved.getnickname());
            itemFriendBinding.tvAddress.setText(inforSaved.getAddress());
            Drawable avatarDrawable = ExtensionKt.getAvatarDrawable(friendAdapter.getContext(), ((inforSaved.getAvatar().length() == 0) || Intrinsics.areEqual((Object) inforSaved.getAvatar(), (Object) "null")) ? "avatar_1" : inforSaved.getAvatar());
            if (avatarDrawable != null) {
                itemFriendBinding.imgAvatar.setImageDrawable(avatarDrawable);
            } else {
                itemFriendBinding.imgAvatar.setImageResource(R.drawable.avatar_1);
            }
        }
    }
}
