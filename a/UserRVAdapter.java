package com.app.gpsphonelocator_new;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.app.gpsphonelocator_new.activity.TrackingUserListActivity;
import com.app.gpsphonelocator_new.adapter.AvatarAdapter;

import java.util.List;

public class UserRVAdapter extends ListAdapter<UserFriend,UserRVAdapter.ViewHolder> {

    private OnItemClickListener listener;

    private UserFriendDao userFriendDao;


    public UserRVAdapter(UserFriendDao userFriendDao) {
        super(DIFF_CALLBACK);
        this.userFriendDao = userFriendDao;
        Log.d("@@247", "userFriendDao initialized: " + (userFriendDao != null));
    }
    private static final DiffUtil.ItemCallback<UserFriend> DIFF_CALLBACK = new DiffUtil.ItemCallback<UserFriend>() {
        @Override
        public boolean areItemsTheSame(UserFriend oldItem, UserFriend newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(UserFriend oldItem, UserFriend newItem) {
            // below line is to check the course name, description and course duration.
            return oldItem.getname().equals(newItem.getname()) &&
                    oldItem.getsecurityCode().equals(newItem.getsecurityCode()) &&
                    oldItem.getphoneNumber().equals(newItem.getphoneNumber());
        }
    };

    @NonNull
    @Override
    public UserRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_tracked_user, parent, false);
        return new ViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull UserRVAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        UserFriend userFriend = getUserAt(position);
        holder.nameTV.setText(userFriend.getname());
        holder.securitycodeTV.setText(userFriend.getsecurityCode());
        holder.phonenumberTV.setText(userFriend.getphoneNumber());
        holder.deletedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserFriend userFriend = getUserAt(holder.getAdapterPosition());

                // Check if userFriendDao is not null and userFriend has a valid ID before using it
                if (userFriendDao != null) {
                    userFriendDao.delete(userFriend);
                    notifyDataSetChanged();
                    Log.d("@@245", "Item deleted");

                }else {
                    Log.e("@@245", "userFriendDao is null");
                }
            }
        });

    }
    public UserFriend getUserAt(int position) {
        return getItem(position);
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView nameTV, securitycodeTV, phonenumberTV;
        ImageButton deletedata;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTV = itemView.findViewById(R.id.idTVName);
            securitycodeTV = itemView.findViewById(R.id.idTVSecurityCode);
            phonenumberTV = itemView.findViewById(R.id.idTVPhoneNumber);
            deletedata = itemView.findViewById(R.id.delete);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION)
                      getItem(position);
                }
            });

        }
    }
    public interface OnItemClickListener {
        void onItemClick(UserFriend userFriend);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;;
    }

}
