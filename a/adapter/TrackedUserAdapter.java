package com.app.gpsphonelocator_new.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.app.gpsphonelocator_new.R;
import com.app.gpsphonelocator_new.common.InforSaved;
import com.app.gpsphonelocator_new.database.UserDatabase;
import com.app.gpsphonelocator_new.database.UserTracked;
import com.app.gpsphonelocator_new.database.UserTrackedDao;
import com.app.gpsphonelocator_new.databinding.ItemTrackedUserBinding;
import com.app.gpsphonelocator_new.common.InforSaved;
import com.bumptech.glide.Glide;

import java.util.List;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

public final class TrackedUserAdapter extends RecyclerView.Adapter<TrackedUserAdapter.MyViewHolder> {
    private Activity mcontext;
    private Function1<? super InforSaved, Unit> update;
    private List<InforSaved> usersList;

    public final Activity getMcontext() {
        return this.mcontext;
    }

    public final List<InforSaved> getUsersList() {
        return this.usersList;
    }

    public final void setMcontext(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<set-?>");
        this.mcontext = activity;
    }

    public final void setUsersList(List<InforSaved> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.usersList = list;
    }

    public TrackedUserAdapter(Activity activity, List<InforSaved> list) {
        Intrinsics.checkNotNullParameter(activity, "mcontext");
        Intrinsics.checkNotNullParameter(list, "usersList");
        this.mcontext = activity;
        this.usersList = list;
    }

    public final Function1<InforSaved, Unit> getUpdate() {
        return (Function1<InforSaved, Unit>) this.update;
    }

    public final void setUpdate(Function1<? super InforSaved, Unit> function1) {
        this.update = function1;
    }

    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        ItemTrackedUserBinding inflate = ItemTrackedUserBinding.inflate(LayoutInflater.from(this.mcontext), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f…mcontext), parent, false)");
        return new MyViewHolder(this, inflate);
    }

    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
        Intrinsics.checkNotNullParameter(myViewHolder, "holder");
        myViewHolder.bindData(i);
    }

    public int getItemCount() {
        return this.usersList.size();
    }


    public static final class MyViewHolder extends RecyclerView.ViewHolder {
        private ItemTrackedUserBinding binding;
        final /* synthetic */ TrackedUserAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MyViewHolder(TrackedUserAdapter trackedUserAdapter, ItemTrackedUserBinding itemTrackedUserBinding) {
            super(itemTrackedUserBinding.getRoot());
            Intrinsics.checkNotNullParameter(itemTrackedUserBinding, "binding");
            this.this$0 = trackedUserAdapter;
            this.binding = itemTrackedUserBinding;
        }

        public final ItemTrackedUserBinding getBinding() {
            return this.binding;
        }

        public final void setBinding(ItemTrackedUserBinding itemTrackedUserBinding) {
            Intrinsics.checkNotNullParameter(itemTrackedUserBinding, "<set-?>");
            this.binding = itemTrackedUserBinding;
        }

        public final void bindData(int i) {
            UserTrackedDao userDAO;
            List<UserTracked> checkedFriends;
            InforSaved inforSaved = this.this$0.getUsersList().get(i);
            ItemTrackedUserBinding itemTrackedUserBinding = this.binding;
            TrackedUserAdapter trackedUserAdapter = this.this$0;
          //  itemTrackedUserBinding.tvUserName.setText(inforSaved.getnickname());
            if (trackedUserAdapter.getUsersList().get(i).getAvatar().length() == 0) {
                itemTrackedUserBinding.imgAvatar.setImageResource(R.drawable.avatar_1);
            } else {
                Glide.with(this.binding.getRoot().getContext()).load(trackedUserAdapter.getUsersList().get(i).getAvatar()).into(itemTrackedUserBinding.imgAvatar);
            }
            UserDatabase.Companion companion = UserDatabase.Companion;
            Context context = this.binding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "binding.root.context");
            UserDatabase instance = companion.getInstance(context);
//            if (!(instance == null || (userDAO = instance.userDAO()) == null || (checkedFriends = userDAO.getCheckedFriends(inforSaved.getlocateuid())) == null)) {
//                for (UserTracked checked : checkedFriends) {
//                    if (Intrinsics.areEqual((Object) String.valueOf(checked.getChecked()), (Object) "false")) {
//                        itemTrackedUserBinding.imgTrackStatus.setImageResource(R.drawable.ic_not_available);
//                        itemTrackedUserBinding.tvTrackStatus.setText(trackedUserAdapter.getMcontext().getString(R.string.unavailable_for_tracking));
//                        itemTrackedUserBinding.tvTrackStatus.setTextColor(Color.parseColor("#FF543D"));
//                    } else {
//                        itemTrackedUserBinding.imgTrackStatus.setImageResource(R.drawable.ic_available);
//                        itemTrackedUserBinding.tvTrackStatus.setText(trackedUserAdapter.getMcontext().getString(R.string.available_for_tracking));
//                        itemTrackedUserBinding.tvTrackStatus.setTextColor(Color.parseColor("#32BE4B"));
//                    }
//                }
//            }
//            itemTrackedUserBinding.imgMenu.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intrinsics.checkNotNullParameter(trackedUserAdapter, "this$0");
//                    Intrinsics.checkNotNullParameter(inforSaved, "$user");
//                    Function1<InforSaved, Unit> update = trackedUserAdapter.getUpdate();
//                    if (update != null) {
//                        update.invoke(inforSaved);
//                    }
//                }
//            });
        }
    }
}
