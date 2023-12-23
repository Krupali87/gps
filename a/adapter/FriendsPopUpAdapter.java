package com.app.gpsphonelocator_new.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.app.gpsphonelocator_new.common.InforSaved;
import com.app.gpsphonelocator_new.database.UserDatabase;
import com.app.gpsphonelocator_new.database.UserTracked;
import com.app.gpsphonelocator_new.database.UserTrackedDao;
import com.app.gpsphonelocator_new.databinding.ItemFriendPopupBinding;
import com.app.gpsphonelocator_new.extensions.AppExtensionKt;
import com.app.gpsphonelocator_new.phone.callback.CallBack;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import kotlin.jvm.internal.Intrinsics;


public final class FriendsPopUpAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    /* access modifiers changed from: private */
    public CallBack.CallBackFriendsPopUp callBackFriendsPopUp;
    /* access modifiers changed from: private */
    public List<InforSaved> listFriendPopUp = new ArrayList();

    public final void callBackFriendsPopUp(CallBack.CallBackFriendsPopUp callBackFriendsPopUp2) {
        Intrinsics.checkNotNullParameter(callBackFriendsPopUp2, "callBackFriendsPopUp");
        this.callBackFriendsPopUp = callBackFriendsPopUp2;
    }

    public final void setData(List<InforSaved> list) {
        Intrinsics.checkNotNullParameter(list, "listFriendPopUp");
        this.listFriendPopUp = list;
        notifyDataSetChanged();
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        ItemFriendPopupBinding inflate = ItemFriendPopupBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f….context), parent, false)");
        return new ViewHolder(this, inflate);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        ((ViewHolder) viewHolder).bindData(i);
    }

    public int getItemCount() {
        return this.listFriendPopUp.size();
    }

    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemFriendPopupBinding binding;
        final /* synthetic */ FriendsPopUpAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(FriendsPopUpAdapter friendsPopUpAdapter, ItemFriendPopupBinding itemFriendPopupBinding) {
            super(itemFriendPopupBinding.getRoot());
            Intrinsics.checkNotNullParameter(itemFriendPopupBinding, "binding");
            this.this$0 = friendsPopUpAdapter;
            this.binding = itemFriendPopupBinding;
        }

        public final void bindData(int i) {
            UserTrackedDao userDAO;
            List<UserTracked> checkedFriends;
            UserDatabase.Companion companion = UserDatabase.Companion;
            Context context = this.binding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "binding.root.context");
            UserDatabase instance = companion.getInstance(context);
            if (!(instance == null || (userDAO = instance.userDAO()) == null || (checkedFriends = userDAO.getCheckedFriends(((InforSaved) this.this$0.listFriendPopUp.get(i)).getlocateuid())) == null)) {
                for (UserTracked checked : checkedFriends) {
                    if (Intrinsics.areEqual((Object) checked.getChecked(), (Object) "true")) {
                        ImageView imageView = this.binding.ivAllowTracking;
                        Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivAllowTracking");
                        AppExtensionKt.show(imageView);
                        ImageView imageView2 = this.binding.ivNotAllowTracking;
                        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.ivNotAllowTracking");
                        AppExtensionKt.hide(imageView2);
                    } else {
                        ImageView imageView3 = this.binding.ivAllowTracking;
                        Intrinsics.checkNotNullExpressionValue(imageView3, "binding.ivAllowTracking");
                        AppExtensionKt.hide(imageView3);
                        ImageView imageView4 = this.binding.ivNotAllowTracking;
                        Intrinsics.checkNotNullExpressionValue(imageView4, "binding.ivNotAllowTracking");
                        AppExtensionKt.show(imageView4);
                    }
                }
            }
            if (((InforSaved) this.this$0.listFriendPopUp.get(i)).getAvatar().length() == 0) {
                Glide.with(this.binding.getRoot().getContext()).load("file:///android_asset/avatar/avatar1.png").into(this.binding.ivFriends);
            } else {
                Glide.with(this.binding.getRoot().getContext()).load(((InforSaved) this.this$0.listFriendPopUp.get(i)).getAvatar()).into(this.binding.ivFriends);
            }
            this.binding.tvFriends.setText(((InforSaved) this.this$0.listFriendPopUp.get(i)).getnickname());
            this.binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    FriendsPopUpAdapter friendsPopUpAdapter=null;
                    Intrinsics.checkNotNullParameter(friendsPopUpAdapter, "this$0");
                    CallBack.CallBackFriendsPopUp access$getCallBackFriendsPopUp$p = friendsPopUpAdapter.callBackFriendsPopUp;
                    if (access$getCallBackFriendsPopUp$p == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("callBackFriendsPopUp");
                        access$getCallBackFriendsPopUp$p = null;
                    }
                    access$getCallBackFriendsPopUp$p.selectFriendsPopUp(i, ((InforSaved) friendsPopUpAdapter.listFriendPopUp.get(i)).getnickname(), ((InforSaved) friendsPopUpAdapter.listFriendPopUp.get(i)).getphone(), ((InforSaved) friendsPopUpAdapter.listFriendPopUp.get(i)).getAddress(), ((InforSaved) friendsPopUpAdapter.listFriendPopUp.get(i)).getLatitudes(), ((InforSaved) friendsPopUpAdapter.listFriendPopUp.get(i)).getLongitudes(), ((InforSaved) friendsPopUpAdapter.listFriendPopUp.get(i)).getlocateuid());
                }
            });
        }

    }
}
