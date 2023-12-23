package com.app.gpsphonelocator_new.adapter;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.icu.text.Transliterator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.app.gpsphonelocator_new.R;
import com.app.gpsphonelocator_new.common.ExtensionKt;
import com.app.gpsphonelocator_new.common.InforSaved;
import com.app.gpsphonelocator_new.databinding.ItemSimpleFriendBinding;

import java.util.Iterator;
import java.util.List;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;


public final class TrackedSimpleAdapter extends RecyclerView.Adapter<TrackedSimpleAdapter.MyViewHolder> {
    private Activity mcontext;
    private Function1<? super InforSaved, Unit> onUserClick;

    public int selectedPosition = -1;
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

    public TrackedSimpleAdapter(Activity activity, List<InforSaved> list) {
        Intrinsics.checkNotNullParameter(activity, "mcontext");
        Intrinsics.checkNotNullParameter(list, "usersList");
        this.mcontext = activity;
        this.usersList = list;
    }

    public final Function1<InforSaved, Unit> getOnUserClick() {
        return (Function1<InforSaved, Unit>) this.onUserClick;
    }

    public final void setOnUserClick(Function1<? super InforSaved, Unit> function1) {
        this.onUserClick = function1;
    }

    public final void update(InforSaved inforSaved) {
        if (inforSaved != null) {
            int i = 0;
            Iterator<InforSaved> it = this.usersList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                } else if (Intrinsics.areEqual((Object) inforSaved.getUid(), (Object) it.next().getlocatepin())) {
                    break;
                } else {
                    i++;
                }
            }
            if (i != -1) {
                this.usersList.set(i, inforSaved);
                notifyItemChanged(i);
            }
        }
    }

    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        ItemSimpleFriendBinding inflate = ItemSimpleFriendBinding.inflate(LayoutInflater.from(this.mcontext), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f…mcontext), parent, false)");
        return new MyViewHolder(this, inflate);
    }

    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
        Intrinsics.checkNotNullParameter(myViewHolder, "holder");
        myViewHolder.bindData(i);
    }

    public int getItemCount() {
        return RangesKt.coerceAtMost(this.usersList.size(), 4);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/phone/number/gpstracker/familylocator/phonetracker/adapter/TrackedSimpleAdapter$MyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/phone/number/gpstracker/familylocator/phonetracker/databinding/ItemSimpleFriendBinding;", "(Lcom/phone/number/gpstracker/familylocator/phonetracker/adapter/TrackedSimpleAdapter;Lcom/phone/number/gpstracker/familylocator/phonetracker/databinding/ItemSimpleFriendBinding;)V", "getBinding", "()Lcom/phone/number/gpstracker/familylocator/phonetracker/databinding/ItemSimpleFriendBinding;", "setBinding", "(Lcom/phone/number/gpstracker/familylocator/phonetracker/databinding/ItemSimpleFriendBinding;)V", "bindData", "", "position", "", "APP78_NumberLocator_v1.1.0(110)_Nov.27.2023_productionRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TrackedSimpleAdapter.kt */
    public final class MyViewHolder extends RecyclerView.ViewHolder {
        private ItemSimpleFriendBinding binding;
        final /* synthetic */ TrackedSimpleAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MyViewHolder(TrackedSimpleAdapter trackedSimpleAdapter, ItemSimpleFriendBinding itemSimpleFriendBinding) {
            super(itemSimpleFriendBinding.getRoot());
            Intrinsics.checkNotNullParameter(itemSimpleFriendBinding, "binding");
            this.this$0 = trackedSimpleAdapter;
            this.binding = itemSimpleFriendBinding;
        }

        public final ItemSimpleFriendBinding getBinding() {
            return this.binding;
        }

        public final void setBinding(ItemSimpleFriendBinding itemSimpleFriendBinding) {
            Intrinsics.checkNotNullParameter(itemSimpleFriendBinding, "<set-?>");
            this.binding = itemSimpleFriendBinding;
        }

        public final void bindData(int i) {
            InforSaved inforSaved = this.this$0.getUsersList().get(i);
            View view = this.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "itemView");
            ExtensionKt.setOnSingleClickListener(view, new Function1<View, Unit>() {
                @Override
                public Unit invoke(View view) {
                    int position = i;
                    TrackedSimpleAdapter.this.selectedPosition = position;
                    notifyDataSetChanged();
                    Function1<InforSaved, Unit> onUserClick = TrackedSimpleAdapter.this.getOnUserClick();
                    if (onUserClick != null) {
                        onUserClick.invoke(inforSaved);
                    }
                    return Unit.INSTANCE;
                }
            });
            ItemSimpleFriendBinding itemSimpleFriendBinding = this.binding;
            TrackedSimpleAdapter trackedSimpleAdapter = this.this$0;
            itemSimpleFriendBinding.tvName.setText(inforSaved.getnickname());
            itemSimpleFriendBinding.tvName.setTextColor(Color.parseColor(trackedSimpleAdapter.selectedPosition == i ? "#32BE4B" : "#1F1F1F"));
            Drawable avatarDrawable = ExtensionKt.getAvatarDrawable(trackedSimpleAdapter.getMcontext(), ((inforSaved.getAvatar().length() == 0) || Intrinsics.areEqual((Object) inforSaved.getAvatar(), (Object) "null")) ? "avatar_1" : inforSaved.getAvatar());
            if (avatarDrawable != null) {
                itemSimpleFriendBinding.imgAvatar.setImageDrawable(avatarDrawable);
            } else {
                itemSimpleFriendBinding.imgAvatar.setImageResource(R.drawable.avatar_1);
            }
        }
    }
}
